-- 전화번호가 010으로 시작하는 직원의 직원명과 전화번호를 다음과 같이 출력하세요.
-- 출력한 결과집합 헤더의 명칭은 각각 ‘EMP_NAME’, ‘PHONE’이어야 함
-- 전화번호는 ‘010-0000-0000’ 형식으로 출력해야 함
-- HINT 1
-- CONCAT
-- HINT 2
-- SUBSTRING

SELECT emp_name, 
	CONCAT_WS('-', SUBSTRING(phone,1,3),SUBSTRING(phone,4,4), SUBSTRING(phone,8,4)) as phone 
FROM employee
WHERE phone LIKE '010%';

-- Q2.
-- 근속 일수가 20년 이상인 직원의 직원명, 입사일, 급여를 다음과 같이 출력하세요.
-- 단, 입사한 순서대로 출력하고 입사일이 같으면 급여가 높은 순서로 출력되도록 하세요.
-- DAY5: Question 2
-- 출력한 결과집합 헤더의 명칭은 각각 ‘직원명’, ‘입사일’, ‘급여’여야 함
-- 입사일은 ‘0000년 00월 00일’ 형식으로 출력해야 함
-- 급여는 천 단위로 , 를 찍어 출력해야 함
-- HINT 1
-- CONCAT
-- HINT 2
-- FORMAT
-- HINT 3
-- DATE 관련 함수
-- HING 4
-- YEAR, MONTH, DAY
SELECT emp_name 직원명
	, CONCAT(SUBSTRING(hire_date,1,4),'년 ',SUBSTRING(hire_date,6,2),'월 ', SUBSTRING(hire_date,09,2		),'일') 입사일
	, FORMAT(salary, 0) 급여
FROM employee
WHERE DATE_FORMAT(hire_date, '%Y-%m-%d') < SUBDATE(DATE_FORMAT(NOW(), '%Y-%m-%d'), INTERVAL 20 YEAR)
ORDER BY hire_date, salary DESC;


-- Q3.
-- 모든 직원의 직원명, 급여, 보너스, 급여에 보너스를 더한 금액을 다음과 같이 출력하세요.
-- 단, 급여에 보너스를 더한 금액이 높은 순으로 출력되도록 하세요.
-- DAY5: Question 3
-- 출력한 결과집합 헤더의 명칭은 각각 ‘EMP_NAME’, ‘SALARY’, ‘BONUS’, ‘TOTAL_SALARY’여야 함
-- 보너스를 더한 급여는 소수점이 발생할 경우 반올림 처리함
-- 급여와 보너스를 더한 급여는 천 단위로 , 를 찍어 출력해야 함 
-- 보너스는 백분율로 출력해야 함
-- HINT 2
-- FORMAT
-- HINT 3
-- CONCAT
-- HINT 4
-- TRUNCATE
-- DAY5: Question 4
-- HINT 5
-- ROUND
SELECT emp_name EMP_NAME
	, format(salary ,0) SALARY
	, concat(round(bonus * 100), '%') BOUNUS
	, ROUND(salary * (1 + IFNULL(bonus, 0))) TOTAL_SALARY
FROM employee
ORDER BY TOTAL_SALARY;

-- Q4.
-- 직원의 직원명과 이메일을 다음과 같이 출력하세요.
-- 출력한 결과집합 헤더의 명칭은 각각 ‘EMP_NAME’, ‘EMAIL’이어야 함
-- 이메일의 도메인 주소인 greedy.com 은 모두 동일하므로, 해당 문자열이 맞춰질 수 있
-- 도록 이메일의 앞에 공백을 두고 출력해야 함

SELECT EMP_NAME
		, CONCAT(
		LPAD(
		SUBSTRING_INDEX(EMAIL, '@', 1)
		, (SELECT MAX(LENGTH(SUBSTRING_INDEX(EMAIL, '@', 1))) FROM employee)
		, ' ')
		, '@greedy.com') AS EMAIL 
FROM employee;

-- +@ (심화)
-- 이메일의 도메인 주소가 모두 다르다고 가정할 때, @의 위치를 한 줄로 맞추고 싶은 경
-- 우에는 어떻게 수정할 수 있을까?
-- 답안

SELECT EMP_NAME
		, CONCAT(
		LPAD(
		SUBSTRING_INDEX(EMAIL, '@', 1)
		, (SELECT MAX(LENGTH(SUBSTRING_INDEX(EMAIL, '@', 1))) FROM employee)
		, ' ')
		, '@'
		, SUBSTRING_INDEX(EMAIL, '@', -1)) AS EAMIL
FROM employee;


-- Q5.
-- 사내 행사 준비를 위해 직원 목록을 출력하려고 합니다. 직원 목록을 다음과 같이 출력하세
-- 요.
-- 단, 관리자의 이름순으로 정렬하여 출력되도록 하세요.
-- 직원명, 직급명, 주민등록번호, 부서가 있는 국가, 부서명, 해당 직원의 관리자 직원명을
-- 출력해야 함
-- DAY5: Question 6
-- 출력한 결과집합 헤더의 명칭은 각각 ‘NAME_TAG’, ‘EMP_NO’, ‘BELONG’,
-- ‘MANAGER_NAME’이어야 하며 출력 형식은 각각 아래와 같아야 함
-- NAME_TAG : (직원명) (직급명)님
-- EMP_NO : (생년월일6자리)-(뒷자리 한 자리를 제외하고는 *로 표시)
-- BELONG : (부서의 국가)지사 (부서명) 소속
-- HINT 1
-- JOIN
-- HINT 2
-- CONCAT
-- HINT 3
-- RPAD
-- HINT 4
-- SUBSTRING

SELECT concat(A.emp_name, ' ', job_name, '님') NAME_TAG
	, RPAD(substring(a.emp_no, 1,8) ,  14 ,'*') EMP_NO
	, concat(national_name,'지사 ', dept_title, ' 소속') BELONG
	, B.emp_name MANAGER_NAME
FROM employee a 
left JOIN employee b on a.manager_id = b.emp_id
left JOIN department d ON a.DEPT_CODE = d.DEPT_ID
JOIN job c ON a.JOB_CODE = c.JOB_CODE
JOIN location e ON d.LOCATION_ID = e.LOCAL_CODE
JOIN national f ON e.NATIONAL_CODE = f.NATIONAL_CODE;

