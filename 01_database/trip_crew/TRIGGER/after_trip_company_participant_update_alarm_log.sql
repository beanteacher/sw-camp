DELIMITER //

-- 동행자 상태 변경에 따른 알림 전송 로그 적재
CREATE OR REPLACE TRIGGER after_trip_company_participant_update_alarm_log
	AFTER UPDATE
	ON TRIP_COMPANY_PARTICIPANT
	FOR EACH row

BEGIN
	
  DECLARE company_writer INT;  -- 여행동행 작성자 사용자번호
  DECLARE company_participant_user INT;  -- 여행동행 참가자 사용자번호

  SELECT review_ui.user_no,
  		tcp.trip_company_participant_user_no INTO company_writer, company_participant_user
   FROM TRIP_COMPANY_PARTICIPANT tcp
   JOIN TRIP_COMPANY tc ON tcp.trip_company_no = tc.trip_company_no
	JOIN USER_INFO review_ui ON tc.trip_company_user_no = review_ui.user_no
	WHERE trip_company_participant_no = NEW.trip_company_participant_no;
   
  IF NEW.trip_company_participant_state = 'accept' THEN    -- 처리가 accept 상태로 변경된다면
  
  INSERT INTO ALARM_SEND_LOG (alarm_no
									   , alarm_send_type
	  									, alarm_receiver) 
	SELECT alarm_no
		, 'P'
		, company_participant_user
		FROM ALARM
		WHERE alarm_del_yn = 'N'
		AND alarm_title LIKE '%동행 수락%' -- 동행 수락메시지  동행 신청자에게 알림 발송 
		LIMIT 1;
		
	ELSEIF NEW.trip_company_participant_state = 'deny' THEN    -- 처리가 deny 상태로 변경된다면
  
   INSERT INTO ALARM_SEND_LOG (alarm_no
									   , alarm_send_type
	  									, alarm_receiver) 
	SELECT alarm_no
		, 'P'
		, company_participant_user
		FROM ALARM
		WHERE alarm_del_yn = 'N'
		AND alarm_title LIKE '%동행 거절%'	 -- 동행  거절 메시지동행 신청자에게 알림 발송 
		LIMIT 1;
	
	ELSEIF NEW.trip_company_participant_state = 'quit' THEN    -- 처리가 quit 상태로 변경된다면
  
   INSERT INTO ALARM_SEND_LOG (alarm_no
									   , alarm_send_type
	  									, alarm_receiver) 
	SELECT alarm_no
		, 'P'
		, company_writer
		FROM ALARM
		WHERE alarm_del_yn = 'N'
		AND alarm_title LIKE '%동행 취소%' -- 동행 자진 나가기 동행 모집자에게 알림 발송
		LIMIT 1;
	
	ELSE 
	
	INSERT INTO ALARM_SEND_LOG (alarm_no
									   , alarm_send_type
	  									, alarm_receiver) 
	SELECT alarm_no
		, 'P' -- 메시지 종류
		, company_writer
		FROM ALARM
		WHERE alarm_del_yn = 'N'
		AND alarm_title LIKE '%동행자 변경%' -- 동행자가 정지당했다는 알림을 모집자에게 발송
		LIMIT 1;
		
	END IF;
	
END //

DELIMITER ;
