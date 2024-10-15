-- Q1. View 생성하기
-- students 테이블 생성
-- student_id (INT, PRIMARY KEY)
-- name (VARCHAR)
-- class (VARCHAR)
-- grades 테이블 생성
-- grade_id (INT, PRIMARY KEY)
-- student_id (INT, FOREGIN KEY)
-- subject (VARCHAR)
-- grade (CHAR)
-- students 와 grades 를 조인하여 과목별로 정렬하여 학생들의 이름, 반, 성적을 보여주는
-- 뷰를 생성하세요.
-- 1단계 : create table
-- 2단계 : 데이터 insert
-- 3단계 : create view
-- 4단계 : select * from view

CREATE TABLE students (
 student_id INT PRIMARY key
 , NAME VARCHAR(20)
 , class VARCHAR(30)
 );
 
CREATE TABLE grades (
	grade_id INT PRIMARY key
	, student_id int
	, subject VARCHAR(100)	
	, grade CHAR(2)
	, FOREIGN KEY (student_id) 
	REFERENCES students(student_id) 
  );
  
    
  INSERT into grades 
 VALUES (
 	1
	 , 1
	 , '과학'
	 , 'A'
 ) , (
 2
 , 1
 , '수학'
 , 'B'), (
 3
 , 2
 , '과학'
 , 'B'), (
 4
 , 2
 , '수학'
 , 'C'), (
 5
 , 3
 , '과학'
 , 'B') , (
 6
 , 3
 , '수학'
 , 'A');
  INSERT INTO students 
  VALUES (
  	1
  	, '유관순'
  	, 'A'
  ), (
  	2
  	, '심사임당'
  	, 'B'
  ), (
  	3
  	, '홍길동'
  	, 'A'
  );

CREATE VIEW studentGrade AS (
SELECT 
	subject
	, name
	, class
	, grade
	FROM students s
	JOIN grades g ON s.student_id = g.student_id
	
);

SELECT * from studentGrade ORDER BY SUBJECT;


-- Q2. Index 생성 / 삭제
-- employeedb의 employee 테이블을 대상으로 dept_code 컬럼에 인덱스를 생성하여
-- 부서코드로 직원들을 검색할 때의 성능을 향상시키세요.
-- Question 2
-- employee 테이블의 인덱스를 조회해보세요.
-- 생성한 인덱스를 다시 삭제하세요.

show INDEX from employee;

ALTER TABLE employee ADD INDEX employee_idx(dept_code);
ALTER TABLE employee DROP INDEX employee_idx;
DROP INDEX employee_idx ON employee;

-- Q3. Stored Procedure 생성
-- 두 개의 숫자를 입력 받아 더한 결과를 출력하는 addNumbers stored procedure를 작
-- 성하세요.
-- 호출 실행 테스트는 아래와 같습니다.
DELIMITER //

CREATE PROCEDURE addNumbers  (
	IN first_number INT
	,IN second_number INT 
	,INOUT sum_number INT 
)

BEGIN 
	SELECT first_number + second_number INTO sum_number;

END //

DELIMITER ;

CALL addNumbers(10, 20, @sum);
SELECT @sum; -- 30 조회


-- Q4. Stored function 생성
-- 현재 가격과 인상 비율을 입력 받아 인상 예정가를 반환하는 increasePrice stored
-- function을 만들고 메뉴 가격을 대상으로 select 절에서 사용하여 아래와 같이 조회하
-- 세요. 예정가는 십의 자리까지 버림처리합니다.
-- 조회 결과는 아래와 같습니다.
DROP FUNCTION increasePrice;

DELIMITER //

CREATE FUNCTION increasePrice(
	id INT
)

RETURNS INT
DETERMINISTIC
BEGIN 
	DECLARE current_price INT;
	DECLARE increase_price INT;

	SELECT menu_price INTO current_price 
	FROM tbl_menu
	WHERE menu_code = id;
	
	SET increase_price = FLOOR(current_price * 1.1 / 100) * 100;
	
	RETURN increase_price;

END //

DELIMITER ;

SELECT FLOOR(menu_price * 1.1/ 100) * 100
	FROM tbl_menu;
	
	
	SELECT MENU_NAME
		, menu_price
		, increasePrice(menu_code)
		FROM tbl_menu;
		
		
-- Q5. trigger 생성
-- salary_history 테이블 생성
-- history_id (INT, PRIMARY KEY)
-- emp_id (VARCHAR, FOREGIN KEY)
-- old_salary (DECIMAL)
-- new_salary (DECIMAL)
-- change_date (DATETIME)
-- employeedb의 salary 컬럼이 update 될 경우 해당 이력을 salary_history 테이블에
-- insert 하는 트리거를 생성합니다.
-- 1단계 : salary_history 테이블 생성
-- 2단계 : trg_salary_update 트리거 생성
-- 3단계 : employee의 특정 행의 salary 컬럼 수정 시 트리거 동작하는지 확인
-- 테스트 결과는 아래와 같습니다.

DROP TABLE salary_history;

CREATE table salary_history(
history_id INT AUTO_INCREMENT PRIMARY KEY 
,emp_id VARCHAR(5)
,old_salary DECIMAL(10,2)
,new_salary DECIMAL(10,2)
,change_date DATETIME
, FOREIGN KEY (emp_id) REFERENCES employee(emp_id)
);

DROP TRIGGER trg_salary_update;

DELIMITER //

CREATE TRIGGER trg_salary_update
	AFTER UPDATE
	ON employee
	FOR EACH row
BEGIN
	if OLD.salary != NEW.salary then 
		INSERT INTO salary_history
		VALUES (
			NULL
			, OLD.emp_id
			, OLD.salary
			, NEW.salary
			, NOW()
		);
	END if;
	
END //

DELIMITER ;


UPDATE employee SET SALARY = 14000000 WHERE emp_id = 200;

SELECT * FROM salary_history;


SELECT * FROM employee;
