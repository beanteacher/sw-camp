-- 17. procedure (프로시저)

DROP PROCEDURE getAllEmployees;

-- 프로시저 생성
DELIMITER //  -- 구분자
CREATE PROCEDURE getAllEmployees()
BEGIN 
    SELECT emp_id, emp_name, salary
      FROM employee;
END //

DELIMITER ; -- 구분자

-- 프로시저 호출
CALL getAllEmployees();

-- (2) in 매개변수 : 호출 시 전달된 값을 사용
-- 특정 부서의 직원 정보 조회 프로시저

-- 프로시저 생성
DELIMITER //  -- 구분자

CREATE PROCEDURE getAllEmployeesByDepartment(
	IN dept CHAR(2)
)
BEGIN 
    SELECT emp_id, emp_name, salary
      FROM employee
		WHERE dept_code = dept;
END //

DELIMITER ; -- 구분자

CALL getAllEmployeesByDepartment('D5');

-- (3) out 매개변수 : 결과 값을 호출한 곳으로 반환
-- 특정 직원의 급여를 반환하는 프로시저

-- 프로시저 생성
DELIMITER //  -- 구분자

CREATE PROCEDURE getAllEmployeeSalary(
	IN id CHAR(3)
	, OUT sal DECIMAL(10,2)
)
BEGIN 
    SELECT salary INTO sal
      FROM employee
		WHERE emp_id = id;
END //

DELIMITER ; -- 구분자

-- 프로시저 호출
-- @ : 사용자 변수
SET @sal = 0;
CALL getAllEmployeeSalary('201', @sal);
SELECT @sal;

DROP PROCEDURE getAllEmployeeSalary;

-- (4) inout 매개변수
-- 특정 직원의 급여를 증가시키고 증가된 급여(보너스 포함) 반환하는 프로시저

DELIMITER //  -- 구분자

CREATE PROCEDURE updateAndReturnSalary(
	IN id CHAR(3)
	, INOUT sal DECIMAL(10,2)
)
BEGIN 
	 UPDATE employee
	 	SET salary = sal
	 	WHERE emp_id = id;
	 	
    SELECT salary + (salary * IFNULL(bonus, 0)) INTO sal
      FROM employee
		WHERE emp_id = id;
END //

DELIMITER ; -- 구분자

-- 프로시저 호출
-- @ : 사용자 변수
SET @new_sal = 9000000;
CALL updateAndReturnSalary('200', @new_sal);
SELECT @new_sal;

SELECT *
      FROM employee;
      
-- (5) if else 활용
		
DELIMITER //  -- 구분자

CREATE PROCEDURE checkEmployeeSalary(
	IN id CHAR(3),
	IN threshold DECIMAL(10,2),
	out result VARCHAR(50)
)
BEGIN 
	 DECLARE sal DECIMAL(10,2);
	 
	 SELECT salary INTO sal
		FROM employee
		WHERE emp_id = id;
		
		if sal > threshold then
			SET result = '기준치를 넘는 급여입니다.';
		ELSE 
			SET result = '기준치와 같거나 기준치 이하의 급여입니다.';
		END if;
END //

DELIMITER ; -- 구분자

SET @result = '';
CALL checkEmployeeSalary('200', 3000000, @result);
SELECT @result;

-- (6) case 활용
DELIMITER //  -- 구분자

CREATE PROCEDURE getDepartmentMessage(
	IN id CHAR(3),
	OUT message VARCHAR(100)
)
BEGIN 
	 DECLARE dept VARCHAR(50);
	 
	 SELECT dept_code INTO dept
		FROM employee
		WHERE emp_id = id;
		
		CASE 
			WHEN dept = 'D1' THEN
				SET message = '인사관리부 직원이시군요!';
			WHEN dept = 'D2' THEN
				SET message = '회계관리부 직원이시군요!';
			WHEN dept = 'D3' THEN
				SET message = '마게팅부 직원이시군요!';
			ELSE 
				SET message = '어떤 부서 직원이신지 모르겠어요!';
		END case;
END //

DELIMITER ; -- 구분자

SET @message = '';
CALL getDepartmentMessage('221', @message);
SELECT @message;

-- (7) while 활용
DELIMITER //  -- 구분자

CREATE PROCEDURE calculateSumUpTo(
	IN max_num INT,
	OUT sum_result INT
)
BEGIN 
	 DECLARE current_num INT DEFAULT 1;
	 DECLARE total_sum INT DEFAULT 0;
	 
	while current_num <= max_num DO
	 	SET total_sum = total_sum + current_num;
	 	SET current_num = current_num + 1;
	END while;
	
	SET sum_result = total_sum;
END //

DELIMITER ; -- 구분자

CALL calculateSumUpTo(10 , @result);
SELECT @result;

-- (8) 예외처리
DELIMITER //  -- 구분자

CREATE PROCEDURE divideNumbers(
	IN numerator DOUBLE,
	in denominator DOUBLE,
	OUT result DOUBLE
)
BEGIN 
	 DECLARE division_by_zero CONDITION FOR SQLSTATE '45000'; -- sqlsate -> 임의의 상태 값
	 DECLARE exit handler FOR division_by_zero -- 오류처리 메시지 발생
	 BEGIN 
	 	SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = '0으로 나눌 수 없습니다.';
	 END;
	 
	 IF denominator = 0 then
	 	SIGNAL division_by_zero;	-- SIGNAL : 발생시킨다.
	 ELSE 
	 	SET result = numerator / denominator;
	 END if;
END //

DELIMITER ; -- 구분자

CALL divideNumbers(10, 2, @result);
SELECT @result;
CALL divideNumbers(10, 0, @result);

-- stored function
-- function 생성
DROP FUNCTION getAnnualSalary;

DELIMITER //  -- 구분자

CREATE FUNCTION getAnnualSalary(
	id VARCHAR(3)
)
RETURNS DECIMAL(15,2)
DETERMINISTIC	-- 같은 입력 값을 넣었을 때 항상 같은 출력값을 낸다는 옵션
BEGIN
	DECLARE monthly_salary DECIMAL(10,2);
	DECLARE annual_salary DECIMAL(15,2);
	
	SELECT salary INTO monthly_salary
	 FROM employee
	WHERE emp_id = id;
	
	SET annual_salary = monthly_salary * 12;
	
	RETURN annual_salary;

END //

DELIMITER ; -- 구분자


SELECT emp_name
	, salary
	, getAnnualSalary(emp_id)
	FROM employee;