-- 06. join

SELECT * FROM tbl_menu;
SELECT * FROM tbl_category;


-- 조인의 종류
-- 1. INNER JOIN : 두 테이블의 교집합을 반환
-- (1) ON  : 컬럼명이 동일하거나 동일하지 않아도 사용가능
SELECT menu_code
	, a.category_code
	, category_name
	, menu_name
	, menu_price
	, orderable_status
	, ref_category_code
	FROM tbl_menu a
	JOIN tbl_category b
	ON a.category_code = b.category_code;
	
-- (2) USING : 컬럼명이 동일한 경우만 사용 가능
SELECT menu_code
	, a.category_code
	, category_name
	, menu_name
	, menu_price
	, orderable_status
	, ref_category_code
	FROM tbl_menu a
	JOIN tbl_category b
	USING (category_code);
	
-- employeedb의 employee와 department join
SELECT a.emp_name
	, b.dept_title
	FROM employee a
	JOIN department b ON a.dept_code = b.dept_id;
	
-- 2. LEFT JOIN : 
-- 첫 번째 테이블의 모든 레코드와 두 번째 테이블에서 일치하는 레코드를 반환
SELECT a.emp_name
	, b.dept_title
	FROM employee a
	LEFT JOIN department b ON a.dept_code = b.dept_id;
	
-- 3. RIGHT JOIN : 
-- 두 번째 테이블의 모든 레코드와 첫 번째 테이블에서 일치하는 레코드를 반환
SELECT a.emp_name
	, b.dept_title
	FROM employee a
	RIGHT JOIN department b ON a.dept_code = b.dept_id;

-- 4. CROSS JOIN : 두 테이블의 가능한 모든 조합을 반환하는 조인
SELECT a.menu_name
	, b.category_name
	FROM tbl_menu a
	CROSS JOIN tbl_category b;
	
-- 5. SELF JOIN
-- 같은 테이블 내에서 행과 행 사이의 관계를 찾기 위해 사용되는 유형
SELECT 
		a.category_name AS 대분류이름
	, b.category_name AS 소분류이름
	FROM tbl_category a
	JOIN tbl_category b ON a.category_code = b.ref_category_code;

SELECT 
	a.emp_id AS 관리자번호 
	, b.emp_id AS 사원번호
	, a.emp_name AS 멘토
	, b.emp_name AS 멘티
	FROM employee a
	RIGHT JOIN employee b ON a.emp_id = b.manager_id
	ORDER BY a.emp_name;
	
	
-- employeedb에서 다중 테이블 조인
SELECT a.emp_id AS 관리자번호 
		, b.emp_id AS 사원번호
		, a.emp_name AS 관리자명
		, b.emp_name AS 사원명
		, b.emp_no AS 주민번호
		, b.email AS 이메일
		, b.phone AS 핸드폰번호
		, c.dept_title AS 부서명
		, d.job_name AS 직급
		, b.salary AS 급여
	 	, e.min_sal AS 최소급여
	 	, e.max_sal AS 최대급여
	 	, f.local_name AS 지역명
	 	, g.national_name AS 국가명
	FROM employee a 
	RIGHT JOIN employee b ON a.emp_id = b.manager_id
	JOIN department c ON b.dept_code = c.dept_id
	JOIN job d ON b.job_code = d.job_code
	JOIN sal_grade e ON b.sal_level = e.sal_level
	JOIN location f ON c.location_id = f.local_code
	JOIN NATIONAL g ON f.national_code = g.national_code
	WHERE b.ent_yn != 'Y';
