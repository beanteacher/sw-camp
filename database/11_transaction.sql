-- 11. transaction
-- : 데이터베이스에서 한번에 수행되는 작업의 단위

-- 기본적으로 commit 이 자동으로 수행하도록 설정되어 있으므로 
-- 해당 설정을 변경한 뒤 테스트한다.
SET autocommit = 1;  -- autocommit 활성화
SET autocommit = ON;	-- autocommit 활성화
SET autocommit = 0;	-- autocommit 비활성화
SET autocommit = OFF;-- autocommit 비활성화

START TRANSACTION;

SELECT * FROM tbl_menu;

INSERT INTO tbl_menu VALUES(NULL, '바나나해장국', 8500 , 4, 'Y');
UPDATE tbl_menu SET MENU_NAME = '수정된 이름' WHERE menu_code = 5;

-- ROLLBACK;

COMMIT;
