-- 15. view : select 쿼리문을 저장한객체로 가상 테이블로 불림
-- 실질적인 데이터를 물리적으로 저장하는 것이 아니라 논리적으로 저장

-- (1) 보안성
-- (2) 복잡한 SELECT 구문을 간결하게 작성할 수 있다.

CREATE VIEW HANSIK AS
SELECT 
	MENU_CODE
	, MENU_NAME
	, MENU_PRICE
	, CATEGORY_CODE
	, ORDERABLE_STATUS
FROM TBL_MENU
WHERE CATEGORY_CODE = 4;


SELECT * FROM hansik;

-- VIEW를 통해 테이블에 DML 작업가능

INSERT INTO tbl_menu
VALUES(NULL, '식혜맛국밥', 5500, 4, 'Y');
INSERT INTO HANSIK
VALUES(99, '수정과맛국밥', 5500, 4, 'Y');

SELECT * FROM TBL_MENU;

UPDATE HANSIK
	SET MENU_NAME = '버터맛국밥'
	, MENU_PRICE = 5700
	WHERE MENU_CODE = 99;
	
DELETE FROM HANSIK WHERE MENU_CODE = 99;

-- VIEW로 DML 명령어 조작이 불가능한 경우
-- (1) 뷰 정의에 포함되지 않은 컬럼을 조작하는 경우
-- (2) 뷰에 포함되지 않은 컬럼 중 베이스테이블에 NOT NULL 조건이 있는 경우
-- (3) 산술 표현식이 정의 된 경우
-- (4) JOIN을 이용해 여러 테이블을 연결한 경우
-- (5) distinct를 포함한 경우
-- (6) 그룹함수 또는 group by 절을 포함한 경우

-- 생성한 view 삭제
DROP VIEW hansik;

-- view 생성 시의 옵션 : or replace
CREATE OR REPLACE VIEW HANSIK AS
SELECT 
	MENU_CODE
	, MENU_NAME
	, MENU_PRICE
	, CATEGORY_CODE
	, ORDERABLE_STATUS
FROM TBL_MENU
WHERE CATEGORY_CODE = 4;