import time
start = time.time()

import re

# Переносим содержимое файлов
with open(r"C:\Users\terni\OneDrive\Рабочий стол\Labs\Schedule.yaml", 'r', encoding="UTF-8") as fin:
    lines = fin.read()


# Разделяем мультифайл на отдельные файлы
separators = re.compile(r'---(.*?)(?:\.\.\.|---)', flags=re.DOTALL)
files = re.findall(separators, lines)


def primitives(value):
    if re.search(r'\d+', value) is not None:
        return value
    if re.search(r'false|no|not', value, flags=re.IGNORECASE) is not None:
        return "False"
    if re.search(r'true|yes', value, flags=re.IGNORECASE) is not None:
        return "True"
    return f"\"{value}\""


rkeywords = re.compile(r'.+: .+')
rnames = re.compile(r'.+:\s*(?!.+)')
rarrays = re.compile(r'(?:- .+\s+){2,}')


# Реализация конвертера на ходу
convertedFiles = []
for file in files:
    keywords = re.findall(rkeywords, file)
    for word in keywords:
        key, value = re.search(r'(.+): (.+)', word.strip()).groups()
        file = file.replace(word.strip(), "\"" + key + "\": " + primitives(value), 1)
    names = re.findall(rnames, file)
    for name in names:
        file = file.replace(name.strip(), name.strip() + " {", 1)
    arrays = re.findall(rarrays, file)
    for array in arrays:
        box = [x for x in re.findall(r'- (.+)\s+', array)]
        file = file.replace(array, str(box) + "\n\t\t", 1)
    convertedFiles.append(file)



fout = open(r"C:\Users\terni\OneDrive\Рабочий стол\Labs\NewSchedule3.json", 'w', encoding="UTF-8").close()

with open(r"C:\Users\terni\OneDrive\Рабочий стол\Labs\NewSchedule3.json", 'a', encoding="UTF-8") as fout:
    for file in convertedFiles:
       fout.write("}\n" + file + "\n}")

