-- 10. DML(Data Manipulation Language)
-- : 데이터 조작 언어. 테이블에 값을 삽입하거나 수정하거나 삭제함

-- (1) INSERT : 새로운 행을 추가
INSERT INTO TBL_MENU 
VALUES (
	NULL
	, '바나나해장국'
	, 8500
	, 4
	, 'Y'
);
SELECT * FROM tbl_menu;

-- NULLABLE 컬럼 OR AUTO_INCREMENT 컬럼을 제외하고 
-- INSERT 하고 싶은 컬럼을 지정해서 INSERT 가능
INSERT INTO tbl_menu
(MENU_NAME
,	MENU_PRICE
, category_code
, orderable_status
)
VALUES
(
'초콜릿죽'
, 6500
, 7
, 'Y'
);

-- 컬럼을 명시적으로 작성했을 경우 데이터의 순서를 바꾸는 것 도 가능
INSERT INTO tbl_menu
(MENU_PRICE
, MENU_NAME
, category_code
, orderable_status
)
VALUES
(
 5000
, '파인애플탕'
, 4
, 'Y'
);


-- multi insert
INSERT
INTO tbl_menu
VALUES
(NULL, '참치맛아이스크림', 1700, 12, 'Y'),
(NULL, '멸치맛아이스크림', 1500, 12, 'Y'),
(NULL, '꽁치맛아이스크림', 2000, 12, 'Y'),
(NULL, '쥐치맛아이스크림', 2500, 12, 'Y');



-- (2) : UPDATE : 테이블에 기록 된 컬럼의 값을 수정
-- 0 ~ N개 행이 업데이트 되며 테이블 전체 행의 수는 변화 없음.
UPDATE tbl_menu 
SET category_code = 7,
	menu_name = '딸기맛붕어빵' 
WHERE menu_code=24;

-- subquery를 update 절에 활용할 수 있다.
UPDATE tbl_menu
SET category_code = 6
WHERE menu_code = (SELECT MENU_CODE 
							FROM TBL_MENU
							WHERE MENU_NAME = '파일애플탕');
							
-- (3) DELETE : 테이블의 행을 삭제하는 구문
-- WHERE 절을 이용한 삭제
DELETE 
	FROM TBL_MENU
	WHERE MENU_CODE = 24;
	
-- LIMIT을 활용한 삭제 (offset 지정은 불가)
SELECT * FROM tbl_menu ORDER BY menu_price;

DELETE 
	FROM tbl_menu
	ORDER  BY menu_price
	LIMIT 2;
	
-- (4) REPLACE
-- replace를 통해 중복 된 데이터를 덮어쓸 수 있다.
-- insert : pk 중복으로 오류 발생
REPLACE
	INTO tbl_menu -- INTO 생략 가능
VALUES(
17
,	'참기름소주'
, 5000
, 10
, 'Y';

-- WHERE절 없이 UPDATE 가능
REPLACE tbl_menu
SET	MENU_CODE = 2
	, MENU_NAME = '우럭쥬스'
	, MENU_PRICE = 2000
	, CATEGORY_CODE = 9
	, orderable_status = 'N';