DELIMITER //

-- 	trp_review_comment 테이블에 insert 이후 작동하는 트리거 생성
CREATE OR REPLACE TRIGGER after_review_comment_insert_alarm
	AFTER INSERT
	ON TRIP_REVIEW_COMMENT
	FOR EACH row

BEGIN
	
  DECLARE review_writer INT;  -- 리뷰 작성자 사용자번호

  SELECT review_ui.user_no INTO review_writer
   FROM TRIP_REVIEW_COMMENT trc
   JOIN TRIP_REVIEW tr ON trc.trip_review_no = tr.trip_review_no
	JOIN USER_INFO review_ui ON tr.trip_review_user_no = review_ui.user_no
	WHERE trip_review_comment_no = NEW.trip_review_comment_no;	-- 댓글 작성 시 댓글의 
   
  
  INSERT INTO ALARM_SEND_LOG (alarm_no
									   , alarm_send_type
	  									, alarm_receiver) 
	SELECT alarm_no
		, 'P'
		, review_writer
		FROM ALARM
		WHERE alarm_del_yn = 'N'
		AND alarm_title LIKE '%리뷰게시판댓글%'
		LIMIT 1;
	
	
END //

DELIMITER ;


DROP TRIGGER after_review_comment_insert_alarm;