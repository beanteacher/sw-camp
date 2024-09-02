DELIMITER //

-- 	trp_review_comment 테이블에 insert 이후 작동하는 트리거 생성
CREATE OR REPLACE TRIGGER after_review_comment_insert_alarm
	AFTER INSERT
	ON TRIP_REVIEW_COMMENT
	FOR EACH row

BEGIN
	
  DECLARE review_replace_count INT; -- 치환 값 개수
  DECLARE review_writer INT;  -- 리뷰 작성자 사용자번호
  DECLARE review_writer_name VARCHAR(20); -- 리뷰 작성자 이름
  DECLARE review_comment_writer_name VARCHAR(20); -- 댓글 작성자 이름
  DECLARE review_title VARCHAR(255); -- 리뷰 제목
  DECLARE review_comment_content VARCHAR(255); -- 댓글 내용

  SELECT review_ui.user_no
  		, review_ui.user_name
	  	, tr.trip_review_title
	  	, comment_ui.user_name
	  	, trc.trip_review_comment_content 
	 		 	INTO review_writer, 
				  	review_writer_name, 
					review_title, 
					review_comment_writer_name, 
					review_comment_content
   FROM TRIP_REVIEW_COMMENT trc
   JOIN TRIP_REVIEW tr ON trc.trip_review_no = tr.trip_review_no
	JOIN USER_INFO comment_ui ON trc.trip_review_comment_user_no = comment_ui.user_no
	JOIN USER_INFO review_ui ON tr.trip_review_user_no = review_ui.user_no
	WHERE trip_review_comment_no = NEW.trip_review_comment_no;
   
  
  INSERT INTO ALARM_SEND_LOG (alarm_no
  										, alarm_content
									   , alarm_send_type
	  									, alarm_receiver) 
	SELECT alarm_no
		, 
		( SELECT 
			REPLACE(
				REPLACE(alarm_template,
				(SELECT alarm_replace_key FROM ALARM_REPLACE ORDER BY alarm_no desc LIMIT review_replace_count - 1, review_replace_count)
				, review_writer_name), 
				(SELECT alarm_replace_key FROM ALARM_REPLACE ORDER BY alarm_no desc LIMIT review_replace_count - 2, review_replace_count - 1)
				review_title)
		REPLACE(
			REPLACE(
				REPLACE(
					REPLACE(alarm_template
					, alarm_etc1, review_writer_name)
					, alarm_etc2, review_title)
					, alarm_etc3, review_comment_writer_name)
					, alarm_etc4, review_comment_content)
		
		, 'P'
		, review_writer
		FROM ALARM
		WHERE alarm_purpose = 'trip_review_comment_insert'
		AND alarm_del_yn = 'N'
		LIMIT 1;
	
	
END //

DELIMITER ;