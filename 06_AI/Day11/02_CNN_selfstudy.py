import keras
import tensorflow as tf
from sklearn.model_selection import train_test_split
import matplotlib.pyplot as plt 

#시드 고정
keras.utils.set_random_seed(42)
tf.random.set_seed(42)
tf.config.experimental.enable_op_determinism()

'''
데이터 설명 - CIFAR-10
keras에서 준비한 데이터셋 중 하나로, 
airplane(비행기), automobile(자동차), bird(새),
cat(고양이), deer(사슴), dog(개), frog(개구리),
horse(말), ship(배)로 나뉘어져 있다.

색상이 있는 이미지 파일 (총 60000장)
32 x 32 픽셀
10개의 클래스
'''

print('\n---------- 데이터 로드 ----------')
(train_input, train_target), (test_input, test_target) = keras.datasets.cifar10.load_data()

print('\n----- train_input 크기 확인 -----')
print(train_input.shape) # (50000, 32, 32, 3)

print('\n----- 첫 이미지 출력해서 확인해보기 -----')
plt.imshow(train_input[0])
plt.show() # 실재 사진 ==> 개구리

# reshape
train_scaled = train_input.reshape(-1, 32, 32, 3) / 255.0

print('\n----- 변환 후 크기 -----')
print(train_scaled.shape) # (50000, 32, 32, 3)

train_scaled, val_scaled, train_target, val_target = train_test_split(train_scaled, train_target, test_size=0.2, random_state=42)


# -------------------- !!합성곱 신경망 만들기!! --------------------
# ============================ 입력층 ============================
model = keras.Sequential()
model.add(keras.layers.Input(shape=(32,32,3)))
# ===============================================================

# ============================ 은닉층 ============================
# 데이터 증강층 추가
# 데이터 증강층에서는 데이터를 무작위로 돌리고, 뒤집고, 확대/축소해서 과적합을 막는다
model.add(keras.layers.RandomFlip('horizontal'))
model.add(keras.layers.RandomRotation(0.1))
model.add(keras.layers.RandomZoom(0.1))
# ---------------------------------------------------------------
# 데이터 추출부 1
model.add(keras.layers.Conv2D(32, kernel_size=3, padding='same'))
model.add(keras.layers.BatchNormalization())
model.add(keras.layers.Activation('relu'))
model.add(keras.layers.MaxPool2D(2))
# 데이터 추출부 2
model.add(keras.layers.Conv2D(64, kernel_size=3, padding='same'))
model.add(keras.layers.BatchNormalization())
model.add(keras.layers.Activation('relu'))
model.add(keras.layers.MaxPool2D(2))
# 데이터 추출부 3
model.add(keras.layers.Conv2D(128, kernel_size=3, padding='same')) 
model.add(keras.layers.BatchNormalization())
model.add(keras.layers.Activation('relu'))
model.add(keras.layers.MaxPool2D(2))
# 데이터 추출부 4
model.add(keras.layers.Conv2D(256, kernel_size=3, padding='same')) 
model.add(keras.layers.BatchNormalization())
model.add(keras.layers.Activation('relu'))
model.add(keras.layers.MaxPool2D(2))
# ---------------------------------------------------------------
model.add(keras.layers.Flatten())
model.add(keras.layers.Dense(512))
model.add(keras.layers.BatchNormalization())
model.add(keras.layers.Activation('relu'))
model.add(keras.layers.Dropout(0.4))
# ================================================================

# ============================ 출력층 ============================
model.add(keras.layers.Dense(10, activation='softmax'))
# ================================================================
# ----------------------------------------------------------------

model.summary()

model.compile(optimizer='adam', loss='sparse_categorical_crossentropy', metrics=['accuracy'])
checkpoint_cb = keras.callbacks.ModelCheckpoint('./Day11/models/best-cnn-model_cifar10.keras', save_best_only=True)
early_stopping_cb = keras.callbacks.EarlyStopping(patience=8, restore_best_weights=True)
lr_scheduler_cb = keras.callbacks.ReduceLROnPlateau(monitor='val_loss', factor=0.5, patience=3) # 손실값(loss)가 극적으로 줄지 않는 구간에서는 학습률(lr)을 줄여서 미세 조정하는 롤백

# 모델 훈련
history = model.fit(train_scaled, train_target, epochs=50, validation_data=(val_scaled, val_target), callbacks=[checkpoint_cb, early_stopping_cb, lr_scheduler_cb])

plt.plot(history.history['loss'], label='train')
plt.plot(history.history['val_loss'], label='val')
plt.xlabel('epoch')
plt.ylabel('loss')
plt.legend()
plt.show()

print('\n----- 모델 evaluate -----')
print(model.evaluate(val_scaled, val_target)) # [0.5467036366462708, 0.8184999823570251]

# 첫 번째 사진 그림으로 확인
print('\n첫 번째 사진의 차원: ', val_scaled[0].shape)

plt.imshow(val_scaled[0])
plt.show() # 실재 사진 ==> 개구리


# 훈련된 모델로 첫 번째 사진 클래스 예측해보기 (결과값: 확률)
print('\n----- 첫 번째 사진 예측 -----')
preds = model.predict(val_scaled[0:1])
print(preds)

classes = ['비행기', '자동차', '새', '고양이', '사슴', '개', '개구리', '말', '배', '트럭']

import numpy as np

print('\n----- 예측 클래스 -----')
print(classes[np.argmax(preds)])

# 위 확률을 그래프로 확인
plt.bar(range(1,11), preds[0])
plt.xlabel('class')
plt.ylabel('prob')
plt.show()


# 테스트 데이터로 확인해보기
test_scaled = test_input.reshape(-1, 32, 32, 3) / 255.0

print('\n----- 테스트 데이터셋 크기 -----')
print(test_scaled.shape) # (10000, 32, 32, 3)

print('\n----- 테스트 점수 -----')
print(model.evaluate(test_scaled, test_target)) # [0.5813654065132141, 0.8116000294685364]