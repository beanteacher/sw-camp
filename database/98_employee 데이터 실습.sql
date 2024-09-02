-- 1. 이름에 '형'자가 들어가는 직원들의 사번, 사원명, 부서명을 조회하시오.(1행)
SELECT a.emp_id 사번
	, a.emp_name 사원명
	, b.dept_title 부서명
	FROM employee a
	JOIN department b ON a.dept_code = b.dept_id
	WHERE a.emp_name LIKE '%형%';
	
-- 2. 해외영업팀에 근무하는 사원명, 직급명, 부서코드, 부서명을 조회하시오.(9행)
SELECT a.emp_name 사원명
	, b.job_name 직급명
	, a.dept_code 부서코드
	, c.dept_title 부성명
	FROM employee a 
	JOIN job b ON a.job_code = b.job_code
	JOIN department c ON a.dept_code = c.dept_id
	WHERE a.dept_code IN ('D5', 'D6', 'D7');
	
-- 3. 보너스포인트를 받는 직원들의 사원명, 보너스포인트, 부서명, 근무지역명을 조회하시오.(8행)(INNER JOIN 결과)
SELECT a.emp_name 사원명
	, a.bonus 보너스포인트
	, b.dept_title 부서명
	, c.local_name 근무지역명
	FROM employee a
	JOIN department b ON a.dept_code = b.dept_id
	join location c on b.location_id = c.local_code
	WHERE a.bonus IS NOT NULL;
-- 4. 부서코드가 D2인 직원들의 사원명, 직급명, 부서명, 근무지역명을 조회하시오.(3행)
SELECT a.emp_name
	, b.job_name
	, c.dept_title
	, d.local_name
	FROM employee a
	JOIN job b ON a.job_code = b.job_code
	JOIN department c ON a.dept_code = c.dept_id
	JOIN location d ON c.location_id = d.local_code
	WHERE a.dept_code = 'D2';
	
-- 5. 급여 테이블의 등급별 최소급여(MIN_SAL)보다 많이 받는 직원들의
-- 사원명, 직급명, 급여, 연봉을 조회하시오.
-- 연봉에 보너스포인트를 적용하시오.(20행)
SELECT a.emp_name 사원명
	, b.job_name 직급명
	, a.salary 급여
	, (a.salary * 12) + ((a.salary * 12) * IFNULL(a.bonus, 0)) 연봉
	FROM employee a 
	JOIN job b ON a.job_code = b.job_code
	JOIN sal_grade c ON a.sal_level = c.sal_level
	WHERE c.min_sal < a.salary;
	
-- 6. 한국(KO)과 일본(JP)에 근무하는 직원들의 
-- 사원명, 부서명, 지역명, 국가명을 조회하시오.(15행)
SELECT a.emp_name 사원명
	, b.dept_title 부서명
	, c.local_name 지역명
	, d.national_name 국가명
	FROM employee a
	JOIN department b ON a.dept_code = b.dept_id
	JOIN location c ON b.location_id = c.local_code
	JOIN national d ON c.national_code = d.national_code
	WHERE d.national_code IN ('KO', 'JP')
	ORDER BY d.national_code DESC, emp_name;
	
-- 7. 보너스포인트가 없는 직원들 중에서 직급코드가 J4와 J7인 직원들의 사원명, 직급명, 급여를 조회하시오.
-- 단, join과 IN 사용할 것(8행)
SELECT emp_name 사원명
	, job_name 직급명
	, salary 급여
	FROM employee a
	JOIN job b ON a.job_code = b.job_code
	WHERE a.job_code IN ('J4', 'J7')
	AND bonus IS NULL;
	
-- 8. 직급이 대리이면서 아시아 지역(ASIA1, ASIA2, ASIA3 모두 해당)에 근무하는 직원 조회(2행)
-- 사번(EMPLOYEE.EMP_ID), 이름(EMPLOYEE.EMP_NAME), 직급명(JOB.JOB_NAME), 부서명(DEPARTMENT.DEPT_TITLE),
-- 근무지역명(LOCATION.LOCAL_NAME), 급여(EMPLOYEE.SALARY)를 조회하시오
-- (해당 컬럼을 찾고, 해당 컬럼을 지닌 테이블들을 찾고, 테이블들을 어떤 순서로 조인해야 하는지 고민하고 SQL문을 작성할 것)
SELECT a.emp_id
	, a.emp_name
	, b.job_name
	, c.dept_title
	, d.local_name
	, a.salary
	FROM employee a
	JOIN job b ON a.job_code = b.job_code
	JOIN department c ON a.dept_code = c.dept_id
	JOIN location d ON c.location_id = d.local_code
	WHERE c.location_id IN (SELECT local_code FROM location WHERE local_name IN ('ASIA1', 'ASIA2', 'ASIA3'))
	AND a.job_code = (SELECT job_code FROM job WHERE job_name = '대리');
