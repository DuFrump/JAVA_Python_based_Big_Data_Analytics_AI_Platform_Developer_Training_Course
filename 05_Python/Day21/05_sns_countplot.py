import matplotlib.pyplot as plt
import seaborn as sns

titanic = sns.load_dataset('titanic')

sns.set_style('whitegrid')

fig, axes = plt.subplots(1, 4, figsize=(15, 5))

sns.countplot(x='class', data=titanic, ax=axes[0])

sns.countplot(x='class', data=titanic, hue='who', dodge=True, palette='Set1', ax=axes[1])
  
sns.countplot(x='class', data=titanic, hue='who', dodge=False, palette='Set2', ax=axes[2])

sns.countplot(x='class', data=titanic, hue='who', palette='Set3', ax=axes[3])

plt.show()