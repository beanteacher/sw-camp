# Node.js LTS 버전이 설치된 alpine linux 이미지를 가져온다.
FROM node:lts-alpine
# 컨테이너 내부 작업 디렉토리를 /app으로 설정
WORKDIR /app
# 현재 디렉토리 내의 모든 내용을 작업 디렉토리로 복사
COPY . .
# npm을 통해 종속성 설치
RUN npm install
# npm run dev 명령 실행 ( 모든 네트워크 인터페이스에서 접근 가능하도록 설정 )
CMD ["npm", "run", "dev", "--", "--host", "0.0.0.0"]