# Git 명령어 요약 정리

## 1. Git 저장소 초기화 및 기본 설정
- `git init` → 현재 폴더를 Git 저장소로 초기화 (.git 폴더 생성)
- `git config --global user.name "홍길동"` → 사용자 이름 설정
- `git config --global user.email "you@example.com"` → 사용자 이메일 설정
- `git --version` → Git 설치 여부 및 버전 확인

## 2. 파일 추가 및 커밋
- `git status` → 현재 Git 상태 확인
- `git add .` → 모든 변경 파일 Git에 추가
- `git add [파일명]` → 특정 파일만 Git에 추가
- `git commit -m "메시지"` → 변경 사항을 커밋

## 3. GitHub 저장소 연결 및 연동
- `git remote add origin [URL]` → GitHub 저장소 연결
- `git remote -v` → 연결된 저장소 확인
- `git push origin main` → GitHub로 업로드
- `git pull origin main` → GitHub에서 변경 사항 가져오기

## 4. 브랜치 관련
- `git branch` → 브랜치 목록 확인
- `git branch [새브랜치]` → 새 브랜치 생성
- `git checkout [브랜치]` → 브랜치 전환
- `git checkout -b [브랜치]` → 브랜치 생성 후 전환
- `git branch -M main` → 브랜치 이름 변경
- `git merge [브랜치]` → 브랜치 병합

## 5. 변경 사항 확인 및 로그
- `git log` → 커밋 기록 확인
- `git show` → 최근 커밋 상세 보기
- `git diff` → 변경점 비교

## 6. 되돌리기 및 추적 해제
- `git reset [파일명]` → add 한 파일 다시 제외
- `git rm --cached [파일명]` → Git 추적 해제
- `git checkout -- [파일명]` → 파일 변경 취소

## 7. 무시 파일 설정
- `.gitignore` → 추적 제외할 파일 목록 지정 (예: *.log, *.env 등)
