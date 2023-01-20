import yaml
import json

# Переносим содержимое файлов
with open(r"C:\Users\terni\OneDrive\Рабочий стол\Labs\Schedule.yaml", 'r', encoding="UTF-8") as fin:
    fileYAML = yaml.safe_load(fin)

fout = open(r"C:\Users\terni\OneDrive\Рабочий стол\Labs\NewSchedule2.json", 'w', encoding="UTF-8").close()

with open(r"C:\Users\terni\OneDrive\Рабочий стол\Labs\NewSchedule2.json", 'a', encoding="UTF-8") as fout:
    json.dump(fileYAML, fout, indent=2)
