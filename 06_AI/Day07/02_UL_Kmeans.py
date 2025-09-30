# 클러스터링 모델 KMeans

import numpy as np
import matplotlib.pyplot as plt

# 과일 사진 불러오기
fruits = np.load('./Day07/data/fruits_300.npy')
fruits_2d = fruits.reshape(-1, 100*100) # -1은 컴퓨터가 알아서 계산해라.. 즉, x / 과일 사진 하나에 100 * 100 픽셀이니, 뒤에는 100 * 100

print('2d 과일 사진 크기')
print(fruits_2d.shape) # (300, 10000)
print()

# KMeans 훈련
from sklearn.cluster import KMeans

km = KMeans(n_clusters=3, random_state=42)
km.fit(fruits_2d)

print('라벨링 결과 확인')
print(km.labels_)
print()

print('라벨별 카운트 확인')
print(np.unique(km.labels_, return_counts=True))
print()

# 출력 함수 정의
import matplotlib.pyplot as plt 

def draw_fruits(arr, ratio=1):
    n = len(arr) # n은 샘플 개수

    # 한 줄에 10개씩 이미지 그리기 (rows = 총 몇 줄인지)
    rows = int(np.ceil(n/10))
    # 행이 1개이면 열 개수는 샘플 개수, 아니면 10열
    cols = n if rows < 2 else 10

    fig, axs = plt.subplots(rows, cols, figsize=(cols*rows, rows*ratio), squeeze=False)

    for i in range(rows):
        for j in range(cols):
            if i*10 + j < n:
                axs[i, j].imshow(arr[i*10 + j], cmap='gray_r')
            axs[i, j].axis('off')
    plt.show()


print(fruits[km.labels_ == 0].shape) # 112, 100, 100
print()

# 과일 별로 뽑아보기
draw_fruits(fruits[km.labels_ == 0]) # 0 = 파인애플 (대부분이 파인애플)
draw_fruits(fruits[km.labels_ == 1]) # 1 = 바나나 (전체가 바나나)
draw_fruits(fruits[km.labels_ == 2]) # 2 = 사과 (전체가 사과)


# KMeans가 저장해 놓은 클러스터 별 평균으로 그림 그리기\
draw_fruits(km.cluster_centers_.reshape(-1, 100, 100), ratio=3)

# 100번 째 인덱스 사진의 클러스터 중심 별 거리 뽑아보기 (유클리드 거리)
print('클러스터 중심 별 거리')
print(km.transform(fruits_2d[100:101]))
print()

# 무슨 클러스터인지 예측해보기
print(f'100번 째 과일은 : {km.predict(fruits_2d[100:101])}')
print()

# 실제 무슨 과일인지 확인해보기
draw_fruits(fruits[100:101])

# 알고리즘 반복 횟수
print(km.n_iter_) # 4번 돌아감

'''
실제 업무에서는 클러스터가 몇 개인지 정확하게 파악하는 것은 사실 상 불가능!
클러스터를 늘려가면서 '이너셔' 변화를 확인해 봐야 함!
이너셔 - 데이터 별로 클러스터 중심과의 거리 제곱의 합
이너셔가 작아지는 속도가 줄어드는 지점이 적정 클러스터이다. (엘보우 방법)
'''

# 최적의 K 찾기
inerita = []
for k in range(2, 7):
    km = KMeans(n_clusters=k, init='k-means++', n_init=4, random_state=42)
    km.fit(fruits_2d)
    inerita.append(km.inertia_)

plt.plot(range(2, 7), inerita)
plt.xlabel('K')
plt.ylabel('inerita')
plt.show()