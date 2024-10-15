--  07. GROUPING

-- group by : 결과 집합을 특정 열의 값에 따라 그룹화
-- having : group by 절과 함께 사용하며 그룹의 조건을 적용

SELECT category_code
	FROM tbl_menu
	GROUP BY category_code;
	
-- count 함수 : 행의 개수를 세는 함수
SELECT COUNT(*)
		, category_code
	FROM tbl_menu
	GROUP BY category_code;
	
-- count 함수 특성: null은 세지 않는다.
SELECT COUNT(*)
	, COUNT(category_code)
	, COUNT(ref_category_code)
	FROM tbl_category;
	
-- sum 함수 : 합계
SELECT SUM(menu_price)
		, category_code
	FROM tbl_menu
	GROUP BY category_code;
	
-- avg 함수 : 평균값
SELECT AVG(menu_price)
		, category_code
	FROM tbl_menu
	GROUP BY category_code;
	
-- min 함수 : 최소값
SELECT MIN(menu_price)
		, category_code
	FROM tbl_menu
	GROUP BY category_code;
	
-- max 함수 : 최대값
SELECT MAX(menu_price)
		, category_code
	FROM tbl_menu
	GROUP BY category_code;
	
	

-- sum, avg는 숫자 데이터에 사용
-- count, min, max는 모든 데이터에 사용
SELECT MIN(emp_name)
	, MAX(emp_name)
	, MIN(hire_date)
	, MAX(hire_date)
	FROM employee;
	
-- group by에서 2개 이상의 그룹 생성
SELECT menu_price
	, category_code
	FROM tbl_menu
	GROUP by menu_price, category_code;
	

-- join과 함께 사용
SELECT a.category_code
	, b.category_name
	, AVG(a.menu_price)
	FROM tbl_menu a
	JOIN tbl_category b 
	ON a.category_code = b.category_code
	GROUP BY a.category_code, b.category_code;
	
-- having 절 사용
SELECT a.category_code
	, b.category_name
	, AVG(a.menu_price) AS 평균값
	FROM tbl_menu a
	JOIN tbl_category b 
	ON a.category_code = b.category_code
	GROUP BY a.category_code, b.category_code
	HAVING AVG(a.menu_price) <= 10000;
	
-- select (6) : 조회 컬럼
-- from (1) : 조회 대상 테이블
-- join (2) : 조회 대상 테이블
-- where (3) : 테이블 행을 조건으로 필터링
-- group by (4) : 대상 컬럼으로 결과 집합 그루팡
-- having (5) : 그루핑 결과를 조건으로 필터링
-- order by (7) : 정렬 기준

-- 집계 함수 rollup : 컬럼 한 개를 활용 했을 경우(SUM의 합계 출력)
SELECT category_code
		, SUM(menu_price)
	FROM tbl_menu
	GROUP BY category_code
	WITH ROLLUP;
	
SELECT menu_price 
		, category_code
		, SUM(menu_price)
	FROM tbl_menu
	GROUP BY menu_price, category_code
	WITH ROLLUP;