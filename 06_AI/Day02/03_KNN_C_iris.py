import seaborn as sns
from sklearn.model_selection import train_test_split
from sklearn.neighbors import KNeighborsClassifier
import matplotlib.pyplot as plt

df = sns.load_dataset('iris')
print(df)
print()
df.info()

'''
붓꽃 데이터
1936년 논문에서 처음 사용
영국의 통계학자가 통계적 분류 기법을 설명하기 위해 만든 예제 데이터
총 150개 샘플

꽃받침 길이 (sepal length, cm)
꽃받침 너비 (sepal width, cm)
꽃잎 길이 (petal length, cm)
꽃잎 너비 (petal width, cm)

Setosa (세토사) -> 작고 단순한 꽃, 다른 두 종과 확실하게 구분 가능
Versicolor (버시컬러) -> 중간 크기, 특징이 섞여있음
Virginica (버지니카) -> 가장 크고 구분이 까다로움
''' 

sns.scatterplot(data=df, x='petal_length', y='petal_width', hue='species')
plt.show()

# 훈련 데이터 준비 >>>> 입력 (x), 타깃 (y)
x = df.drop('species', axis=1)
y = df['species']

# 훈련/테스트 데이터셋 분리
x_train, x_test, y_train, y_test = train_test_split(x, y, test_size=0.2, random_state=42)

# 최근접 이웃 3개 모델으로 knn 변수명에 불러오기
knn = KNeighborsClassifier(n_neighbors=3)

# 불러와서 학습 시키기
knn.fit(x_train, y_train)

# 테스트셋 예측 시켜서 y_pred에 담기
y_pred = knn.predict(x_test)

print()
print('예측값: ', y_pred)
print()
print('실제값: ', y_test)
print()

print('테스트 스코어: ', knn.score(x_test, y_test))
print()
print('트레인 스코어: ', knn.score(x_train, y_train))
print()


from sklearn.metrics import accuracy_score

# 스코어랑 같은 결과가 나옴(채점 느낌)
print('정확도: ', accuracy_score(y_test, y_pred))
print()