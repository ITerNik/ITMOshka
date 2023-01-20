import re

# Функция для открытия тестовых файлов и файлов вывода

def setTests(inname, outname):
    with open(r"Tasks\\" + inname, 'r', encoding='utf-8') as fin:
        regex = re.compile('\\b\d\)\s*')
        tests = re.split(regex, fin.read())
    tests.pop(0)
    fout = open(r"Outputs\\" + outname, 'w', encoding='utf-8').close()
    fout = open(r"Outputs\\" + outname, 'a', encoding='utf-8')
    return tests, fout 


# Задание №1

tests, fout = setTests('Task1.txt', 'Output1.txt')

print ('Задание №1\n')

regex = re.compile(r'\b=-{[OО]\b|^=-{[OО]')
k = 0
for t in tests:
    result = len(re.findall(regex, t))
    k += 1
    fout.write(f"{k}) " + re.sub(regex, ' --> =-{O <-- ', t)) 
    print('В примере №{} найдено {} смайлика(ов)'.format(k, result))

fout.close()

# Задание №2

tests, fout = setTests('Task2.txt', 'Output2.txt')

print('\nЗадание №2\n')

regex = re.compile(r'\b(?:[01]\d|2[0-3]):[0-5]\d\b(?:\:[0-5]\d)?\b')
k = 0
for t in tests:
    changes = re.findall(regex, t)
    k += 1
    fout.write(f"{k}) " + re.sub(regex, '(TBD)', t))
    if changes:
        print ('В примере №{} заменены {}'.format(k, changes))
    else:
        print ('В примере №{} нет замен'.format(k))

fout.close()

# Задание №3
    
tests, fout = setTests('Task3.txt', 'Output3.txt')

print('\nЗадание №3\n')

group = input('Введите номер группы: ')
regex = re.compile(group + r"\W*([А-ЯЁ])[^А-ЯЁ]*(?:-\1.*)?(?:\1\.){2}")
k = 0
for t in tests:
    k += 1
    if re.search(regex, t) != None:
        print ('\nИз списка №{} удалены:'.format(k))
        while re.search(regex, t) != None:
            student = re.search(regex, t).group()
            print(student.replace(group, ''))
            t = t.replace(student, '-')
    else:
        print('Из списка №{} никто не удален'.format(k))
    fout.write(f"{k}) " + t)
        
fout.close()

