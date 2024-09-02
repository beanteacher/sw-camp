-- 1. 모든 사원 모든 컬럼 조회
SELECT emp_id
	, emp_name
	, emp_no
	, email
	, phone
	, dept_code
	, job_code
	, sal_level
	, salary
	, bonus
	, manager_id
	, hire_date
	, ent_date
	, ent_yn
 FROM employee;
  
-- 2. 사원들의 사번(사원번호), 이름 조회
SELECT emp_id
	, emp_name
 FROM employee;
  
-- 3. 201번 사번의 사번 및 이름 조회
SELECT emp_id
	, emp_name
 FROM employee 
 where emp_id = 201;
 
-- 4. employee 테이블에서 부서 코드가 'D9'인 사원 조회
SELECT *
 FROM employee 
 where dept_code = 'D9';
 
-- 5. employee 테이블에서 직급 코드가 'J1'인 사원 조회
SELECT *
 FROM employee 
 where job_code = 'J1';
 
-- 6. employee 테이블에서 급여가 300만원 이상(>=)인 사원의
-- 사번, 이름, 부서코드, 급여를 조회하시오.
SELECT emp_id
	, emp_name
	, dept_code
	, salary
 FROM employee
 WHERE salary >= 3000000;

-- 7. 부서코드가 'D6'이고 급여를 300만원보다 많이 받는
-- 직원의 이름, 부서코드, 급여 조회
SELECT emp_name
	, dept_code
	, salary
 FROM employee
 WHERE salary > 3000000
 AND dept_code = 'D6'; 

-- 8. 보너스를 받지 않는 사원에 대한
-- 사번, 직원명, 급여, 보너스를 조회
SELECT emp_id 
	, emp_name
	, salary
	, bonus
 FROM employee
 WHERE bonus IS NULL;
 
-- 9. 'D9' 부서에서 근무하지 않는 사원의
-- 사번, 이름, 부서코드를 조회
SELECT emp_id 
	, emp_name
	, dept_code
 FROM employee
 WHERE dept_code != 'D9';

 
-- 10. employee 테이블에서 퇴사 여부가 N인 직원들 조회하고
-- 사번, 이름, 입사일을 별칭을 사용해 조회해 보기
-- (퇴사 여부 컬럼은 ENT_YN이고 N은 퇴사 안한 사람, Y는 퇴사 한 사람)
SELECT emp_id AS 사번
	, emp_name AS 이름
	, hire_date AS 입사일
 FROM employee
 WHERE ENT_YN = 'N';

-- 11. employee 테이블에서 급여 350만원 이상
-- 550만원 이하를 받는 직원의
-- 사번, 이름, 급여, 부서코드, 직급코드를 별칭을 사용해 조회해 보기
SELECT emp_id AS 사번
	, emp_name AS 이름
	, salary AS 급여
	, dept_code AS 부서코드
	, sal_level AS 직급코드
 FROM employee
 WHERE salary BETWEEN 3500000 AND 5500000;
 
-- 12. employee 테이블에서 '성이 김씨'인 직원의 사번, 이름, 입사일 조회
SELECT emp_id 
	, emp_name
	, hire_date
 FROM employee
 WHERE emp_name LIKE '김%';
 
-- 13. employee 테이블에서 '성이 김씨'가 아닌 직원의 사번, 이름, 입사일 조회
SELECT emp_id 
	, emp_name
	, hire_date
 FROM employee
 WHERE emp_name NOT LIKE '김%';

-- 14. EMPLOYEE 테이블에서 '하'문자가 이름에 포함 된
-- 직원의 이름, 주민번호, 부서코드 조회
SELECT  emp_name
	, emp_no
	, dept_code
 FROM employee
 WHERE emp_name NOT LIKE '%하%';
 
-- 15. 'J2'직급이면서 급여가 200만원 이상인 직원이거나
-- 'J7'직급인 직원의 이름, 급여, 직급코드 조회
SELECT  emp_name
	, salary
	, job_code
 FROM employee
 WHERE job_code = 'J2'
 AND salary >= 2000000
 OR job_code = 'J7';
 
-- 16. 'J2'직급이거나 'J7'직급인 직원들 중에
-- 급여가 200만원 이상인 직원의 이름, 급여, 직급코드 조회
SELECT  emp_name
	, salary
	, job_code
 FROM employee
 WHERE (job_code = 'J2' OR job_code = 'J7')
 AND salary >= 2000000;

-- 17. IN 연산자로 업그레이드
SELECT  emp_name
	, salary
	, job_code
 FROM employee
 WHERE job_code IN ('J2', 'J7')
 AND salary >= 2000000;