# 군집화 (Clustering)
# !수동으로 하기!

import numpy as np
import matplotlib.pyplot as plt

# 과일 사진 불러오기
fruits = np.load('./Day07/data/fruits_300.npy')

# 출력해보기
print('과일 전체 배열')
print(fruits)
print()

# 300, 100, 100 (100x100 픽셀이 300장)
print('과일 전체 shape')
print(fruits.shape)
print()

# 첫 사진의 첫 행 출력
print('첫 사진 첫 행 출력')
print(fruits[0, 0, :])
print()


# 컴퓨터는 하얀색(255 / 큰 숫자)을 더 비중 있게 다룬다.
# 따라서 흑백 반전된 사진으로 저장 되어 있음.
plt.imshow(fruits[0], cmap='gray')
plt.show()

# 색상만 reverse한 것. (검정 -> 하양 / 하양 -> 검정)
plt.imshow(fruits[0], cmap='gray_r')
plt.show()

# 파인애플과 바나나도 뽑아보기
fig, axs = plt.subplots(1, 2)
axs[0].imshow(fruits[100], cmap='gray_r')
axs[1].imshow(fruits[200], cmap='gray_r')
plt.show()

# 과일 별로 나누면서 사진마다 한 행으로 reshape
apple = fruits[0:100].reshape(-1, 100*100)
pineapple = fruits[100:200].reshape(-1, 100*100)
banana = fruits[200:300].reshape(-1, 100*100)

# 100, 10000
print('사과 데이터 확인')
print(apple.shape)
print()

# 사진인데 mean이 주는 의미는?
print('사과 사진 별로 평균 내보기')
print(apple.mean(axis=1))
print()

# 바나나가 배경이 더 넓어서 대체적으로 평균이 낮음 (배경 == 검정색 / 검정색(0))
# 과일 별로 평균 내서 그래프 그려보기
plt.hist(apple.mean(axis=1), alpha=0.8, label='apple')
plt.hist(pineapple.mean(axis=1), alpha=0.8, label='pineapple')
plt.hist(banana.mean(axis=1), alpha=0.8, label='banana')

plt.legend()
plt.show()

# 각 위치별로 픽셀 평균 값을 구하기
# 바 그래프 / 과일 별로 어느 부분이 높은지 확인하기
# fig, axs = plt.subplots(1, 3, figsize=(20, 5))

# axs[0].bar(range(10000), apple.mean(axis=0))
# axs[1].bar(range(10000), pineapple.mean(axis=0))
# axs[2].bar(range(10000), banana.mean(axis=0))
# plt.show()

# 평균 값들로 한 장의 이미지로 만들어서 출력 (과일 별로.)
apple_mean = apple.mean(axis=0).reshape(100, 100)
pineapple_mean = pineapple.mean(axis=0).reshape(100, 100)
banana_mean = banana.mean(axis=0).reshape(100, 100)

fig, axs = plt.subplots(1, 3, figsize=(20, 5))

axs[0].imshow(apple_mean, cmap='gray_r')
axs[1].imshow(pineapple_mean, cmap='gray_r')
axs[2].imshow(banana_mean, cmap='gray_r')
plt.show()

print('중간 점검')
print(fruits.shape) # 300, 100, 100
print(apple_mean.shape) # 100, 100
print()

# 모든 그림을 '평균 사과 사진'으로 빼기
# 사과 사진이라면 각각의 차이가 작음
abs_diff = np.abs(fruits - apple_mean)
# 각각의 사진에 있는 10000개의 숫자(차이) 평균
abs_mean = np.mean(abs_diff, axis=(1,2))

print(abs_mean.shape)

# 사과 100개의 위치 별 평균을 뽑아서, '평균 사과'를 만듦. (100x100)
# 300장의 과일 사진들을 각각 '평균 사과' 사진 빼기를 함. (평균 사과와 300장의 과일 사진이 한 장, 한 장 대조과 되면서 각 픽셀의 색상 차이 값(거리)가 남게 됨)
# 그럼 300장의 '차이' 사진이 됨.
# 300장의 '차이' 사진을 각각 평균을 냄. (10000 픽셀의 평균)
# 결국 300개의 평균이 남음.
# 즉, 이 평균의 숫자가 작아야 '사과'에 가깝다는 결론이 도출되게 됨.

# '차이' 값이 작은 그림 Top 100의 인덱스를 뽑아서, 그 인덱스를 이용해, 원본 사진 불러오기
apple_index = np.argsort(abs_mean)[:100]
apple_index = apple_index.reshape(10, 10)
fig, axs = plt.subplots(10, 10, figsize=(10, 10))

for i in range(10):
    for j in range(10):
        axs[i, j].imshow(fruits[apple_index[i, j]], cmap='gray_r')
        axs[i, j].axis('off')

plt.show()


# 파인애플/바나나 뽑아보기
abs_pine_diff = np.abs(fruits - pineapple_mean)
abs_banana_diff = np.abs(fruits - banana_mean)
# 각각의 사진에 있는 10000개의 숫자(차이) 평균
abs_pine_mean = np.mean(abs_pine_diff, axis=(1,2))
abs_banana_mean = np.mean(abs_banana_diff, axis=(1,2))

print(abs_pine_mean.shape)
print(abs_banana_mean.shape)

# '차이' 값이 작은 그림 Top 100의 인덱스를 뽑아서, 그 인덱스를 이용해, 원본 사진 불러오기
pineapple_index = np.argsort(abs_pine_mean)[:100]
pineapple_index = pineapple_index.reshape(10, 10)

banana_index = np.argsort(abs_banana_mean)[:100]
banana_index = banana_index.reshape(10, 10)

fig, axs = plt.subplots(10, 20, figsize=(10, 20))

for i in range(10):
    for j in range(10):
        axs[i, j].imshow(fruits[pineapple_index[i, j]], cmap='gray_r')
        axs[i, j].axis('off')

    for r in range(10, 20):
        axs[i, r].imshow(fruits[banana_index[i, j]], cmap='gray_r')
        axs[i, r].axis('off')

plt.show()