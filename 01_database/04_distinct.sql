-- 04. distinct : 중복 컬럼 값 제거하고 조회
-- 메뉴 테이블에 존재하는 카테고리 종류를 조회
SELECT DISTINCT category_code
FROM tbl_menu;

-- null 값이 존재하는 경우
SELECT DISTINCT ref_category_code
FROM tbl_category;

-- 다중열에 distinct 키워드 사용: 다중 열 값들이 모두 동일하면 중복으로 처리
SELECT DISTINCT category_code
		, orderable_status
		FROM tbl_menu;