DELIMITER //

-- 동행자가 동행요청 후 여행동행 생성자에게 알림 발송
CREATE OR REPLACE TRIGGER after_trip_company_participant_insert_alarm_log
	AFTER INSERT
	ON TRIP_COMPANY_PARTICIPANT
	FOR EACH row

BEGIN
	
  DECLARE company_writer INT;  -- 여행동행 작성자 사용자번호

  SELECT review_ui.user_no INTO company_writer
   FROM TRIP_COMPANY_PARTICIPANT tcp
   JOIN TRIP_COMPANY tc ON tcp.trip_company_no = tc.trip_company_no
	JOIN USER_INFO review_ui ON tc.trip_company_user_no = review_ui.user_no
	WHERE trip_company_participant_no = NEW.trip_company_participant_no;	-- 댓글 작성 시 댓글의 
   
  
  INSERT INTO ALARM_SEND_LOG (alarm_no
									   , alarm_send_type
	  									, alarm_receiver) 
	SELECT alarm_no
		, 'P'
		, company_writer
		FROM ALARM
		WHERE alarm_del_yn = 'N'
		AND alarm_title LIKE '%동행 참가요청%'
		LIMIT 1;
	
	
END //

DELIMITER ;


DROP TRIGGER after_trip_company_participant_insert_alarm_log;