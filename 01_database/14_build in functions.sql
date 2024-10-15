-- 14. built in functions(내장함수)

-- (1) 문자열 관련 함수
-- ASCII(아스키 코드), CHAR(숫자)
SELECT ASCII('A'), CHAR(65);

SELECT BIT_LENGTH('PIE'), CHAR_LENGTH('PIE'), LENGTH('PIE');

SELECT CONCAT_WS('|', '호랑이', '기린', '토끼');

SELECT ELT(2, '사과', '딸기', '바나나')
	, FIELD('딸기', '딸기', '사과', '바나나')
	, FIND_IN_SET('바나나', '사과,딸기,바나나')
	, INSTR('사과딸기바나나', '딸기')
	, LOCATE('딸기', '사과딸기바나나');
	
SELECT FORMAT(1123123123312123.567567, 3);

SELECT BIN(65), OCT(65), HEX(65);

SELECT INSERT('내 이름은 아무개', 7, 3, '홍길동');

SELECT LEFT('Hello World!', 3), RIGHT('Hello World!', 3);

SELECT UPPER('Hello World!'), LOWER('Hello World!');

SELECT LPAD('왼쪽', 6, '@'), LPAD('왼쪽', 6, '@');

SELECT LTRIM('        왼쪽'), RTRIM('오른쪽       '), TRIM('     오왼       ');

SELECT REPLACE('마리아DB', '마리아', 'maria');

SELECT REVERSE('stressed');

SELECT CONCAT('제 이름은', SPACE(5), '이고 나이는', SPACE(3), '세 입니다.');

SELECT 
		SUBSTRING('안녕하세요 반갑습니다.', 7, 2),
		SUBSTRING('안녕하세요 반갑습니다.', 7);
		
SELECT SUBSTRING_INDEX('hong.testgmail.com','.', 2);
SELECT SUBSTRING_INDEX('hong.testgmail.com','.', -2);

-- (2) 숫자 관련 함수

-- abs : 절대값 반환
SELECT ABS(-123);


-- ceiling : 올림, floor : 내림, round : 반올림
SELECT CEILING(1234.56), FLOOR(1234.56), ROUND(1234.56);

-- conv(숫자, 원래진수, 변환진수)
SELECT CONV('A',16,10), CONV('A',16,2), CONV(1010,2,8);

-- mod : 나머지
SELECT MOD(75, 10), 75%10, 75 MOD 10;

-- pow : 거듭제곱의 값, sqrt : 제곱근(루트를 씌운 값)
SELECT POW(2,4), SQRT(16);

-- rand : 0 이상 1 미만의 랜덤값
SELECT RAND();

-- m <= 임의의 정수 < n 을 구하고 싶다면 floor(rand() * (n-m) + m)
SELECT FLOOR(RAND() * (11 - 1) + 1);

-- sign(양수, 음수, 0을 판단)
SELECT SIGN(10.1) , SIGN(0), SIGN(-10.1);

-- truncate (잘라내기..)
SELECT TRUNCATE(12345.12345, 2), TRUNCATE(12345.12345, -2);
-- (3) 날짜/시간 관련 함수

-- adddate, subdate, addtime, subtime
SELECT ADDDATE('2023-05-31', INTERVAL 31 DAY),
	SUBDATE('2023-05-31', INTERVAL 31 DAY),
	ADDTIME('2023-05-31 09:00:31', '1:0:1'),
	SUBTIME('2023-05-31 09:00:31', '1:0:1');

-- 현재 시스템 날짜/ 시간 반환
SELECT CURDATE(), CURRENT_DATE(), CURRENT_DATE;
SELECT CURTIME(), CURRENT_TIME(), CURRENT_TIME;
SELECT NOW(), LOCALTIME, LOCALTIME(), LOCALTIMESTAMP, LOCALTIMESTAMP();

SELECT YEAR(CURDATE()), MONTH(CURDATE()), DAY(CURDATE());
SELECT HOUR(CURTIME()), MINUTE(CURTIME()), SECOND(CURTIME()), MICROSECOND(CURTIME(6));

-- datediff, timediff
SELECT DATEDIFF('2023-05-31', '2023-02-28');

SELECT DAYOFWEEK(CURDATE()) , MONTHNAME(CURDATE()), DAYOFYEAR(CURDATE());

SELECT LAST_DAY('2023-02-01');

-- MAKEDATE, MAKETIME
SELECT MAKEDATE(2023,32), MAKETIME(17,03,02);

-- quarter
SELECT QUARTER('2023-05-01');

-- TIME TO SEC
SELECT TIME_TO_SEC('1:1:1 );
