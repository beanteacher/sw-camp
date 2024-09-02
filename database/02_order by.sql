-- 02. ORDER BY : select 문의 결과 집합을 정렬
SELECT menu_code
		, menu_name
		, menu_price
	FROM tbl_menu
	ORDER BY menu_price DESC; -- 기본 정렬 기준은 오름차순
	

-- 정렬 기준이 2개 이상인 경우
SELECT menu_code
		, menu_name
		, menu_price
	FROM tbl_menu
	ORDER BY menu_price DESC, menu_name ASC;
	

-- 연산 결과 활용
SELECT menu_code
		, menu_name
		, menu_price
		, menu_code * menu_price '연산결과'
	FROM tbl_menu
	ORDER BY menu_code * menu_price;
	

-- field
SELECT FIELD('A', 'A', 'B', 'C');
SELECT FIELD('B', 'A', 'B', 'C');
SELECT FIELD('C', 'A', 'B', 'C');


SELECT menu_name
		, orderable_status
		, FIELD(orderable_status, 'N', 'Y') AS 'N FIRST'
	FROM tbl_menu
	ORDER BY N FIRST;
	
-- 별칭 작성 시 AS 뒤에 작성하며 특수 문자 포함할 경우 ' ' 로 작성
-- order by 절에서는 ' ' 작성 시 정렬 적용 불가

-- null 데이터의 정렬 순서
SELECT category_code
		, category_name
		, ref_category_code
	from tbl_category
	ORDER BY -ref_category_code asc;