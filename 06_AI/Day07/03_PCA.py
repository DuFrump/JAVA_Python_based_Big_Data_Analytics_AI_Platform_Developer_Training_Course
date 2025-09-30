# PCA (Principal Component Analysis)

import numpy as np

# 과일사진 불러오기
fruits = np.load('./Day07/data/fruits_300.npy')
fruits_2d = fruits.reshape(-1, 100*100)

# 주성분 분석
# 2차원 데이터를 기대
# 사진인지 아닌지 상관 없음

from sklearn.decomposition import PCA

pca = PCA(n_components=50)
pca.fit(fruits_2d)

# 주성분 모양 50, 10000
print(pca.components_.shape)

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

print('주성분 뽑아보기')
print(pca.components_)
print()

# 주성분 그려보기
draw_fruits(pca.components_.reshape(-1, 100, 100))

# 원본 배열 크기
print(fruits_2d.shape) # 300, 10000
print()

# 주성분으로 차원 축소
friuts_pca = pca.transform(fruits_2d)

print('차원 축소 후 크기')
print(friuts_pca.shape) # 300, 50
print()
print('첫 번째 요소')
print(friuts_pca[0])
print()

# 다시 복원해서 그려보기
fruits_inverse = pca.inverse_transform(friuts_pca)

print('복원 후 크기')
print(fruits_inverse.shape) # 300, 10000
print()

fruist_reconstruct = fruits_inverse.reshape(-1, 100, 100)

for start in [0, 100, 200]:
    draw_fruits(fruist_reconstruct[start:start+100])
    print()

# (설명된 분산) 50개의 주성분이 원본을 얼마나 잘 표현 했을까?
print('주 성분별 설명 퍼센티지')
print(pca.explained_variance_ratio_)
print()
print('50개의 성분이 원본을 얼마나 잘 표현했나?')
print(np.sum(pca.explained_variance_ratio_)) # 92%
print()

# 주성분 TOP 10개면 충분히 표현 가능
plt.plot(pca.explained_variance_ratio_)
plt.show()

# ==============================================================
# 차원을 축소해서 분류 시키기 (로지스틱 리그레션 - 지도학습)
# 원본 그대로 분류 시키기
# 두 개를 비교 (누가 더 빠른지, 스코어는 어떤가?)