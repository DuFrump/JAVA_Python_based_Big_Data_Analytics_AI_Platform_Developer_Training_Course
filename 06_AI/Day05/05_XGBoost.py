from xgboost import XGBRegressor # XGBoost 라이브러리 임포트

# 모델 정의
xgb = XGBRegressor(n_jobs=-1, random_state=42)

# 교차 검증 과정을 거친 최적의 해 찾기
scores_xgb = cross_validate(xgb, train_scaled, train_target, return_train_score=True, n_jobs=-1)

# 훈련/검증 스코어 평균
print("XGBoost 평균 스코어 (훈련/검증):")
print(np.mean(scores_xgb['train_score']), np.mean(scores_xgb['test_score']))
# 일반적으로 검증 스코어가 RF/ET보다 높게 나옵니다.

# 모델 학습 및 최종 평가
xgb.fit(train_scaled, train_target)

print()
print("------------- XGBoost 최종 성능 평가 -------------")
print('훈련 스코어:', xgb.score(train_scaled, train_target))
print('테스트 스코어:', xgb.score(test_scaled, test_target))