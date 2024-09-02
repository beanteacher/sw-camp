-- 05. limit : select 문의 결과 집합에서 반환할 행의 갯수 제한
SELECT * 
FROM tbl_menu 
ORDER BY menu_price DESC
-- [offset] : 시작할 번호의 인덱스 번호, row_count : 이후 행부터 반환할 갯수
LIMIT  5;