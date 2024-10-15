-- Q1.
-- 부서별 직원 급여의 총합 중 가장 큰 액수를 출력하세요.
SELECT MAX(salary)
	FROM employee
	WHERE dept_code IS NOT NULL
	GROUP BY dept_code
	LIMIT 1;
	
-- Q2.
-- 서브쿼리를 이용하여 영업부인 직원들의 사원번호, 직원명, 부서코드, 급여를 출력하세요.
-- 참고. 영업부인 직원은 부서명에 ‘영업’이 포함된 직원임
SELECT emp_id 사원번호
	, emp_name 직원명
	, dept_code 부서코드
	, ROUND(salary) 급여
	FROM employee a
	WHERE dept_code IN (SELECT dept_id FROM department WHERE dept_title LIKE '%영업%');

-- Q3.
-- 서브쿼리와 JOIN을 이용하여 영업부인 직원들의 사원번호, 직원명, 부서명, 급여를 출력하세요.
SELECT emp_id 사원번호
	, emp_name 직원명
	, dept_title 부서명
	, ROUND(salary) 급여
	FROM employee a
	JOIN department b ON a.dept_code = b.dept_id
	WHERE dept_code IN (SELECT dept_id FROM department WHERE dept_title LIKE '%영업%');


-- Q4.
-- 1. JOIN을 이용하여 부서의 부서코드, 부서명, 해당 부서가 위치한 지역명, 국가명을 추출
-- 하는 쿼리를 작성하세요.
SELECT dept_id 부서코드
	, dept_title 부서명
	, local_name 지역명
	, national_name 국가명
FROM department a
JOIN location b ON a.location_id = b.local_code
JOIN national c ON b.national_code = c.national_code;

-- 2. 위 1에서 작성한 쿼리를 서브쿼리로 활용하여 모든 직원의 사원번호, 
-- 직원명, 급여, 부서명, (부서의) 국가명을 출력하세요.
-- 단, 국가명 내림차순으로 출력되도록 하세요.
SELECT emp_id
	, emp_name
	, salary
	, dept_title
	, national_name
	FROM employee a
	LEFT JOIN department b ON a.dept_code = b.dept_id
	JOIN location c ON b.location_id = c.local_code
	JOIN national d ON c.national_code = d.national_code
	ORDER BY national_name DESC;		
	
-- DAY3: Question 
-- Q5.
-- 러시아에서 발발한 전쟁으로 인해 정신적 피해를 입은 직원들에게 위로금을 전달하려고 합
-- 니다. 위로금은 각자의 급여에 해당 직원의 급여 등급에 해당하는 최소 금액을 더한 금액으로
-- 정했습니다.
-- Q4에서 작성한 쿼리를 활용하여 해당 부서의 국가가 ‘러시아’인 직원들을 대상으로, 직원의
-- 사원번호, 직원명, 급여, 부서명, 국가명, 위로금을 출력하세요.
-- 단, 위로금 내림차순으로 출력되도록 하세요.
SELECT emp_id 사원번호
	, emp_name 직원명
	, salary 급여
	, dept_title 부서명
	, national_name 국가명
	, salary + (SELECT min_sal from sal_grade s WHERE a.sal_level = s.SAL_LEVEL) 위로금
	FROM employee a
	LEFT JOIN department b ON a.dept_code = b.dept_id
	JOIN location c ON b.location_id = c.local_code
	JOIN national d ON c.national_code = d.national_code
	WHERE d.national_code = (SELECT national_code FROM national WHERE national_name = '러시아')
	ORDER BY national_name DESC;