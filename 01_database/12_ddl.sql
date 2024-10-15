-- 12. DDL(Data Definition Language)
-- : 데이터베이스의 스키마를 정의하거나 수정

-- (1) CREATE TABLE : 테이블 생성
CREATE TABLE if NOT EXISTS tb 
(
		pk INT PRIMARY KEY -- 컬럼 레벨 제약 조건
		, fk INT
		, col VARCHAR(255)
		, CHECK(col IN ('Y', 'N')) -- 테이블 레벨 제약 조건
	 	
) ENGINE=INNODB;

DESC TB;


-- INSERT TEST
INSERT INTO TB
VALUES(
NULL
, 10
, 'Y'
);

-- AUTO_INCREMENT 적용
CREATE TABLE if NOT EXISTS tb2
(
		pk INT AUTO_INCREMENT PRIMARY KEY -- 컬럼 레벨 제약 조건
		, fk INT
		, col VARCHAR(255)
		, CHECK(col IN ('Y', 'N')) -- 테이블 레벨 제약 조건
	 	
) ENGINE=INNODB;


INSERT INTO tb2
VALUES(
NULL
, 10
, 'Y'
);


-- (2) ALTER : 테이블에 추가/변경/수정/삭제
-- 2-1. 컬럼 추가
ALTER TABLE tb2 ADD COLUMN col2 VARCHAR(255);
-- 2-2. 컬럼 이름 및 데이터 형식 변경
ALTER TABLE tb2 CHANGE COLUMN col col1 VARCHAR(255) NOT NULL;
-- 2-3. 컬럼 삭제
ALTER TABLE tb2 DROP COLUMN col2;
-- 2-4. 제약조건 추가 및 삭제
ALTER TABLE tb
DROP PRIMARY KEY;
-- AUTO_INCREMENT 설정이 있을 경우 PK 제약조건 제거 불가
ALTER TABLE TB MODIFY PK INT;
DESC tb2;

ALTER TABLE TB MODIFY PK INT AUTO_INCREMENT PRIMARY KEY;

-- 2-5. 컬럼 다중 추가
ALTER TABLE tb2 ADD COLUMN col3 INT, ADD COLUMN col4 VARCHAR(255);
ALTER TABLE tb2 DROP COLUMN COL3, DROP COLUMN COL4;
SELECT * FROM tb2;

-- (3) DROP : 테이블 삭제 구문
DROP TABLE tb2;
-- 여러 개의 테이블 삭제 가능
DROP TABLE tb2, tb;

-- (4) TRUNCATE : 모든 데이터 삭제
-- 논리적으로 DELETE 구문과 차이가 없어 보이지만
-- DROP 이후에 테이블을 재생성 해주는 동작이 일어난다.
TRUNCATE TABLE tb;

SELECT * FROM tb;

