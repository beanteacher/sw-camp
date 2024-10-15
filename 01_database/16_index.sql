-- 16. index : 데이터 검색 속도 향상을 위해 사용
CREATE TABLE phone (
	phone_code INT PRIMARY KEY,
	phone_name VARCHAR(100),
	phone_price DECIMAL(10,2)
);

INSERT INTO phone
VALUES (1, 'galaxyS23', 1200000),
(2, 'iPhone14pro', 1430000),
(3, 'galaxyZflod3', 1730000);

COMMIT;

ALTER TABLE phone ADD INDEX phone_idx (phone_name, phone_price);
EXPLAIN  SELECT * FROM phone WHERE phone_name = 'galaxyS23' AND phone_price = 13000000;
EXPLAIN  SELECT * FROM phone WHERE phone_code = 1;

-- 인덱스 조회
SHOW INDEX FROM PHONE;

-- 인덱스 최적화 (재구성)
ALTER TABLE PHONE DROP INDEX PHONE_IDX; 
ALTER TABLE PHONE ADD INDEX PHONE_IDX (phone_name, phone_price);
OPTIMIZE TABLE PHONE; -- INNODB만 가능