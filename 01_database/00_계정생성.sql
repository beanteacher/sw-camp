-- swcamp 라는 이름으로 계정생성
CREATE USER 'swcamp'@'%' IDENTIFIED BY 'swcamp';

-- 데이터베이스(스키마) 생성 
CREATE DATABASE menudb;

-- swcamp의 주어진 권한 확인
SHOW GRANTS FOR 'swcamp'@'%';

-- menudb를 다룰 수 있는 모든 권한을 swcamp 꼐정에 부여
GRANT ALL PRIVILEGES ON menudb.* TO 'swcamp'@'%';

-- 세션 관리자에서 swcamp로 접속한 뒤 사용할 때 데이터베이스 선택
USE menudb;      