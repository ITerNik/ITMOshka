import matplotlib.pyplot as plt
import pandas as pd
import seaborn as sns


df = pd.read_csv(r"C:\Users\terni\OneDrive\Рабочий стол\Labs\SPFB.RTS-12.18_180901_181231.csv", sep=",")
df.drop(['<TICKER>', '<PER>', '<TIME>', '<VOL>'], axis=1, inplace=True)
df.rename(columns={'<DATE>':'Дата', '<OPEN>':'Открытие', '<HIGH>':'Макс', '<LOW>':'Мин', '<CLOSE>':'Закрытие'}, inplace=True)

dateFilter = ['25/09/18', '23/10/18', '23/11/18', '04/12/18']
stateFilter = ['Открытие', 'Макс', 'Мин', 'Закрытие']

newDf = pd.DataFrame()

for i in dateFilter:
    tmpDf = df[df['Дата'] == i]
    tmpInd = [k for k in range(len(tmpDf))]
    tmpDf.index = tmpInd
    for j in stateFilter:
        newDf['{} - {}'.format(i, j)] = tmpDf[j]

fig, ax = plt.subplots(figsize = (12,10), dpi = 300)
ax = sns.boxplot(data=newDf)
ax.legend(newDf.columns)
sns.move_legend(ax, "lower center", bbox_to_anchor=(.5, 1), ncol=4, title=None, frameon=False)
plt.xticks([])
plt.figure(figsize=(2, 2))
plt.show()