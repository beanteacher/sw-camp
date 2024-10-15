-- 18.trigger

DELIMITER //

CREATE TRIGGER after_order_menu_insert
	AFTER insert
	ON tbl_order_menu
	FOR EACH row
BEGIN
	UPDATE tbl_order
	SET total_order_price = total_order_price + NEW.order_amount * (SELECT 
																								menu_price 
																							FROM tbl_menu
																						  WHERE menu_code = NEW.menu_code)
	WHERE order_code = NEW.order_code;
END //

DELIMITER ;


-- insert 테스트 
INSERT INTO tbl_order
	VALUES (
		NULL
		, DATE_FORMAT(CURRENT_DATE, '%Y%m%d')
		, DATE_FORMAT(CURRENT_TIME, '%H%i%s')
		, 0
	);
	
INSERT INTO tbl_order_menu
VALUES  (
	1
	, 4
	, 3
);