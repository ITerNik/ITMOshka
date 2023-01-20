# Переносим содержимое файлов
with open(r"C:\Users\terni\OneDrive\Рабочий стол\Labs\Schedule.yaml", 'r', encoding="UTF-8") as fin:
    lines = list(fin) 
tokens = [f.strip() for f in lines] # Слова без пробельных символов


# Разделяем мультифайл на отдельные файлы
files = []
try:
    lastIndex = tokens.index('---')
except ValueError:
    print("YAML file should start with \'---\'") # Обработка на начало файла
    exit()
separators = ['---', '...']
separatorsIn = [sub for sub in separators if sub in tokens[lastIndex + 1:]]
while separatorsIn:
    nextIndex = min(tokens.index(sub, lastIndex + 1) for sub in separatorsIn)
    try:
        files.append(lines[tokens.index('---', lastIndex) + 1: nextIndex])
    except ValueError:
       break
    lastIndex = nextIndex
    separatorsIn = [sub for sub in separators if sub in tokens[lastIndex + 1:]]
if '---' in tokens[lastIndex:]: # Обработка файла без '...' в конце
    files.append(lines[lastIndex + 1:])
while [] in files:
    files.remove([])


def primitives(value):
    boolTrue = ["yes", "YES", "true", "True"]
    boolFalse = ["no", "NO", "false", "False"]
    if all(c.isdigit() for c in value):
        return value
    if value in boolFalse:
        return "False"
    if value in boolTrue:
        return "True"
    return f"\"{value}\""


# Функция для рекурсивного поиска вложений
def searchForTokens(nesting, currLine, file):
    nest = ''
    _lines = file
    _tokens = [line.strip() for line in _lines]
    if nesting != 0:
        while currLine < len(_lines) and _lines[currLine].startswith(' ' * nesting): # Проверяем на отступы
            if nest != '':
                nest += ",\n" + '\t'*nesting
            if _tokens[currLine][-1] == ':':
                localLine = currLine
                currLine, underNest = searchForTokens(nesting + 1, currLine + 1, file) # Ищем вложения
                if underNest.startswith("Array"):
                    nest += "\"" + _tokens[localLine][:-1] + "\": " + underNest[5:]
                elif underNest:
                    nest += "\"" + _tokens[localLine][:-1] + "\": {\n"  + '\t'*nesting + underNest + "\n" + '\t'*nesting + "}"
                else:
                    nest += "\"" + _tokens[localLine][:-1] + "\": " + "null"
            elif _tokens[currLine][0:2] == "- ":
                nestArray = []
                while _tokens[currLine][0:2] == "- ":
                    nestArray.append(_tokens[currLine][2:])
                    currLine += 1
                nest += "Array" + str(nestArray)
                continue
            elif ': ' in _tokens[currLine]:
                index = _tokens[currLine].index(": ")
                if _tokens[currLine][index + 2:] == '':
                    _tokens[currLine] += "null"
                nest += "\"" + _tokens[currLine][:index] + "\": " + primitives(_tokens[currLine][index + 2:])
                currLine += 1
    else:
        while currLine < len(_lines) and not _lines[currLine].startswith(' '):
            if nest != '':
                nest += ",\n" + '\t'*nesting
            if _tokens[currLine][-1] == ':':
                localLine = currLine
                currLine, underNest = searchForTokens(nesting + 1, currLine + 1, file)
                if underNest.startswith("Array"):
                    nest += "\"" + _tokens[localLine][:-1] + "\": " + underNest[5:]
                elif underNest:
                    nest += "\"" + _tokens[localLine][:-1] + "\": {\n" + '\t'*nesting + underNest + "\n" + '\t'*nesting + "}"
                else:
                    nest += "\"" + _tokens[localLine][:-1] + "\": " + "null"
            elif _tokens[currLine][0:2] == "- ":
                nestArray = []
                while _tokens[currLine][0:2] == "- ":
                    nestArray.append(_tokens[currLine][2:])
                    currLine += 1
                nest += "Array" + str(nestArray)
                continue
            elif ': ' in _tokens[currLine]:
                index = _tokens[currLine].index(": ")
                if _tokens[currLine][index + 2:] == '':
                    _tokens[currLine] += "null"
                nest += "\"" + _tokens[currLine][:index] + "\": " + primitives(_tokens[currLine][index + 2:])
                currLine += 1
    return currLine, nest


# Реализация парсера
fout = open(r"C:\Users\terni\OneDrive\Рабочий стол\Labs\NewSchedule1.json", 'w', encoding="UTF-8").close()
for file in files:
    with open(r"C:\Users\terni\OneDrive\Рабочий стол\Labs\NewSchedule1.json", 'a', encoding="UTF-8") as fout:
        fout.write("{\n" + str(searchForTokens(0, 0, file)[1]) + "\n}")

