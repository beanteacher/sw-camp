-- 01. select : 특정 테이블에서 원하는 데이터를 조회해서 가져오는 구문
SELECT 
		menu_code
	   , menu_name
		, menu_price
		, category_code
		, orderable_status
	FROM tbl_menu;

-- * : 모든 컬럼
SELECT 
		* 
	FROM tbl_menu;

-- select 문 단독 사용 가능 (from 절 없이 dual 생략)
-- 내장 함수 사용 가능
SELECT NOW();
SELECT SYSDATE();
SELECT CONCAT('홍', ' ', '길동');
