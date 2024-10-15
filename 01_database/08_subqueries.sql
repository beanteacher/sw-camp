-- 08. subqueries : 서브 쿼리는 다른 쿼리(메인 쿼리) 내에서 실행되는 쿼리
--  서브 쿼리를 통해 복잡한 메인 쿼리를 한 번에 여러 작업을 수행할 수 있다.


SELECT menu_name 
FROM tbl_menu
WHERE category_code = 
	(SELECT category_code
		FROM tbl_menu 
		WHERE menu_name = '민트미역국');
		
		
-- 서브쿼리를 활용한 메인 쿼리
-- from 절에 쓰이는 서브쿼리는 인라인뷰라고 한다.
SELECT MAX(COUNT)
	FROM (SELECT COUNT(*) AS 총합
				FROM tbl_menu
				GROUP BY category_code) AS count_menu;
				
-- 상관 서브쿼리 : 메인 쿼리가 서브 쿼리 결과에 영향을 주는 형태
SELECT menu_code
	, menu_name
	, menu_price
	, category_code
	, orderable_status
	FROM tbl_menu a
	WHERE menu_price > (SELECT AVG(menu_price) FROM tbl_menu WHERE category_code = a.category_code);
	
	
-- exist : 조회 결과가 있을 때 true, 없을 때 false
SELECT category_name
	FROM tbl_category a
	WHERE EXISTS( SELECT 1 
						FROM tbl_menu b
						WHERE b.category_code = a.category_code)
	ORDER BY 1;
	
	
-- CTE (common Table Expression)
-- 인라인 뷰로 ㅆ/ㅡ이는 서브쿼리를 미리 정의해서 사용
WITH menucate AS (
	SELECT menu_name
		, category_name
	FROM tbl_menu a
	JOIN tbl_category b ON a.category_code = b.category_code)
	SELECT * 
	FROM menucate
	ORDER BY menu_name;
