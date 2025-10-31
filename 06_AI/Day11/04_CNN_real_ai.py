import os, numpy as np, pandas as pd, keras, tensorflow as tf
from sklearn.model_selection import train_test_split
from keras import layers

# ===============================================================
# 설정 - os.path.join() == 자동으로 현재 os에 맞는 구분자를 사용
# full 대문자 - 상수 네이밍 (바꾸지 않음 / 고정 파라미터)
# ===============================================================
BASE_DIR = './Day11/real_ai'
TRAIN_DIR = os.path.join(BASE_DIR, 'train')
TEST_DIR = os.path.join(BASE_DIR, 'test')
TRAIN_CSV = os.path.join(BASE_DIR, 'train.csv')
TEST_CSV = os.path.join(BASE_DIR, 'test.csv')

IMG_SIZE = 128 # 이미지 사이즈 128 x 128로 통일
CHANNELS = 3 # 사진: 3채널(RGB)
BATCH_SIZE = 64 # 배치 사이즈 64
EPOCH = 50 # 에포크 20번
SEED = 42 # 시드 번호 42로 고정


# ===============================================================
# 이미지 -> 배열 함수
# ===============================================================
def load_image_as_array(path, img_size=IMG_SIZE, channels=CHANNELS):
    # Pillow Image 객체를 반환하는 메서드
    img = tf.keras.utils.load_img(path, target_size=(img_size, img_size), color_mode='rgb' if channels==CHANNELS else 'grayscale')
    # PI 객체를 배열로 반환하는 메서드 (128, 128, 3)
    arr = tf.keras.utils.img_to_array(img)
    # 크기 스케일링 작업
    arr = arr / 255.0

    return arr


# ===============================================================
# 경로 컬럼 추가 함수
# ===============================================================
def load_split_data():
    df = pd.read_csv(TRAIN_CSV) # Columns: Image, Label(0 or 1)
    '''
    Image Label
    1.jpg   0
    2.jpg   0
      .     .
      .     .
      .     .
    '''
    # 경로 붙이기
    df['path'] = df['Image'].apply(lambda x : os.path.join(TRAIN_DIR, str(x)))
    '''
    Image Label         path
    1.jpg   0     real_ai/train/1.jpg
    2.jpg   0     real_ai/train/2.jpg
      .     .           .
      .     .           .
      .     .           .
    '''

    # stratify 분할 (클래스 비율 유지 - 데이터 불균형 방지)
    tr_df, va_df = train_test_split(df, test_size=0.2, random_state=SEED, stratify=df['Label'])

    # list comprehension로 로딩
    X_train = np.stack([load_image_as_array(p) for p in tr_df['path'].values])
    y_train = tr_df['Label'].values.astype('float32')

    print('\n----- X_train.shape: ', X_train.shape)
    print('\n----- y_train.shape: ', y_train.shape)
    print()

    X_val = np.stack([load_image_as_array(p) for p in va_df['path'].values])
    y_val = va_df['Label'].values.astype('float32')

    return (X_train, y_train), (X_val, y_val)


# ===============================================================
# CNN 모델 빌드 - 32 - 64 - 128 (3번) / - 256 (4번)
# ===============================================================
def build_cnn():
    # ========== 입력층 ==========
    model = keras.Sequential()
    model.add(layers.Input(shape=(IMG_SIZE, IMG_SIZE, CHANNELS)))

    #========== 은닉층 ==========
    # ---------- 데이터 증강층 (학습 결과 확인 후) ----------
    model.add(layers.RandomFlip('horizontal'))
    model.add(layers.RandomRotation(0.2))
    model.add(layers.RandomZoom(0.2))
    model.add(layers.RandomContrast(0.2))
    model.add(layers.RandomTranslation(0.1, 0.1))

    # ---------- 특징 추출부 1 ----------
    model.add(layers.Conv2D(32, kernel_size=3, padding='same'))
    model.add(layers.BatchNormalization())
    model.add(layers.Activation('relu'))
    model.add(layers.MaxPool2D(2))
    model.add(layers.SpatialDropout2D(0.2))
    # ---------- 특징 추출부 2 ----------
    model.add(layers.Conv2D(64, kernel_size=3, padding='same'))
    model.add(layers.BatchNormalization())
    model.add(layers.Activation('relu'))
    model.add(layers.MaxPool2D(2))
    model.add(layers.SpatialDropout2D(0.2))
    # ---------- 특징 추출부 3 ----------
    model.add(layers.Conv2D(128, kernel_size=3, padding='same'))
    model.add(layers.BatchNormalization())
    model.add(layers.Activation('relu'))
    model.add(layers.MaxPool2D(2))
    model.add(layers.SpatialDropout2D(0.2))
    # ---------- 특징 추출부 4 (학습 결과 확인 후) ----------
    model.add(layers.Conv2D(256, kernel_size=3, padding='same'))
    model.add(layers.BatchNormalization())
    model.add(layers.Activation('relu'))
    model.add(layers.MaxPool2D(2))
    model.add(layers.SpatialDropout2D(0.2))

    # ---------- 분류기 ----------
    model.add(layers.Flatten())
    model.add(layers.Dense(512))
    model.add(layers.BatchNormalization())
    model.add(layers.Activation('relu'))
    model.add(layers.Dropout(0.5))

    # ========== 출력층 ==========
    model.add(layers.Dense(1, activation='sigmoid'))


    # ========== 모델 컴파일 ==========
    model.compile(optimizer='adam', loss='binary_crossentropy', metrics=['accuracy'])

    return model


# ===============================================================
# main 함수 빌드
# ===============================================================
def main():
    # 데이터 로드
    (train_scaled, train_target), (val_scaled, val_target) = load_split_data()

    # 모델
    model = build_cnn()
    print('\n---------- 모델 요약 ----------')
    model.summary()

    # 콜백
    checkpoint_cb = keras.callbacks.ModelCheckpoint('./Day11/models/real_ai_model.keras', save_best_only=True)
    early_stopping_cb = keras.callbacks.EarlyStopping(patience=8, restore_best_weights=True)
    lr_scheduler_cb = keras.callbacks.ReduceLROnPlateau(monitor='val_loss', factor=0.5, patience=3) # 손실값(loss)가 극적으로 줄지 않는 구간에서는 학습률(lr)을 줄여서 미세 조정하는 롤백

    # 학습
    print('\n---------- 모델 훈련 ----------')
    history = model.fit(train_scaled, train_target, epochs=EPOCH, validation_data=(val_scaled, val_target), batch_size=BATCH_SIZE, callbacks=[checkpoint_cb, early_stopping_cb, lr_scheduler_cb], verbose=2)

    # 평가
    print('\n----- 모델 평가 -----')
    print(model.evaluate(val_scaled, val_target, verbose=1))

if __name__ == "__main__":
    main()