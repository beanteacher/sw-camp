-- 알림
ALTER TABLE ALARM
 ADD CONSTRAINT ALARM_FK FOREIGN KEY ( alarm_writer )
 REFERENCES USER_INFO (user_no);

-- 알림 발송 기록
ALTER TABLE ALARM_SEND_LOG
 ADD CONSTRAINT ALARM_SEND_LOG_FK FOREIGN KEY ( alarm_receiver )
 REFERENCES USER_INFO (user_no );

ALTER TABLE ALARM_SEND_LOG
 ADD CONSTRAINT ALARM_SEND_LOG_FK1 FOREIGN KEY ( alarm_no )
 REFERENCES ALARM (alarm_no );


-- 도시
ALTER TABLE CITY
 ADD CONSTRAINT CITY_FK FOREIGN KEY ( country_code )
 REFERENCES COUNTRY (country_code );


-- 여행동행자
ALTER TABLE COMPANY_PARTICIPANT
 ADD CONSTRAINT COMPANY_PARTICIPANT_FK FOREIGN KEY ( trip_company_participant_no )
 REFERENCES TRIP_COMPANY (trip_company_no );

ALTER TABLE COMPANY_PARTICIPANT
 ADD CONSTRAINT COMPANY_PARTICIPANT_FK1 FOREIGN KEY ( trip_company_participant_user_no )
 REFERENCES USER_INFO (user_no );


-- 여행 게시판
ALTER TABLE REPORT_BOARD
 ADD CONSTRAINT REPORT_BOARD_FK FOREIGN KEY ( trip_review_no )
 REFERENCES TRIP_REVIEW (trip_review_no );

ALTER TABLE REPORT_BOARD
 ADD CONSTRAINT REPORT_BOARD_FK1 FOREIGN KEY ( report_user )
 REFERENCES USER_INFO (user_no );

ALTER TABLE REPORT_BOARD
 ADD CONSTRAINT REPORT_BOARD_FK2 FOREIGN KEY ( report_accept_user )
 REFERENCES USER_INFO (user_no );

ALTER TABLE REPORT_BOARD
 ADD CONSTRAINT REPORT_BOARD_FK3 FOREIGN KEY ( report_reason_code )
 REFERENCES REPORT_REASON (report_reason_code );


-- 여행 게시판 댓글
ALTER TABLE REPORT_COMMENT
 ADD CONSTRAINT REPORT_COMMENT_FK FOREIGN KEY ( report_reason_code )
 REFERENCES REPORT_REASON (report_reason_code );

ALTER TABLE REPORT_COMMENT
 ADD CONSTRAINT REPORT_COMMENT_FK1 FOREIGN KEY ( trip_review_comment_no )
 REFERENCES TRIP_REVIEW_COMMENT (trip_review_comment_no );

ALTER TABLE REPORT_COMMENT
 ADD CONSTRAINT REPORT_COMMENT_FK2 FOREIGN KEY ( comment_report_accept_user )
 REFERENCES USER_INFO (user_no );

ALTER TABLE REPORT_COMMENT
 ADD CONSTRAINT REPORT_COMMENT_FK3 FOREIGN KEY ( comment_report_user )
 REFERENCES USER_INFO (user_no );


-- 여행 코스
ALTER TABLE REPORT_COURSE
 ADD CONSTRAINT REPORT_COURSE_FK FOREIGN KEY ( course_report_accept_user )
 REFERENCES USER_INFO (user_no );

ALTER TABLE REPORT_COURSE
 ADD CONSTRAINT REPORT_COURSE_FK1 FOREIGN KEY ( report_reason_code )
 REFERENCES REPORT_REASON (report_reason_code );

ALTER TABLE REPORT_COURSE
 ADD CONSTRAINT REPORT_COURSE_FK2 FOREIGN KEY ( course_report_user )
 REFERENCES USER_INFO (user_no );

ALTER TABLE REPORT_COURSE
 ADD CONSTRAINT REPORT_COURSE_FK3 FOREIGN KEY ( trip_course_no )
 REFERENCES TRIP_COURSE (trip_course_no );


-- 여행 코스 동행자
ALTER TABLE REPORT_PARTNER
 ADD CONSTRAINT REPORT_PARTNER_FK FOREIGN KEY ( report_reason_code )
 REFERENCES REPORT_REASON (report_reason_code );

ALTER TABLE REPORT_PARTNER
 ADD CONSTRAINT REPORT_PARTNER_FK1 FOREIGN KEY ( company_report_user )
 REFERENCES USER_INFO (user_no );

ALTER TABLE REPORT_PARTNER
 ADD CONSTRAINT REPORT_PARTNER_FK2 FOREIGN KEY ( partner_report_accept_user )
 REFERENCES USER_INFO (user_no );

ALTER TABLE REPORT_PARTNER
 ADD CONSTRAINT REPORT_PARTNER_FK3 FOREIGN KEY ( trip_company_no )
 REFERENCES TRIP_COMPANY (trip_company_no );


-- 신고상태
ALTER TABLE REPORT_STATE
 ADD CONSTRAINT REPORT_STATE_FK FOREIGN KEY ( user_no )
 REFERENCES USER_INFO (user_no );

ALTER TABLE REPORT_STATE
 ADD CONSTRAINT REPORT_STATE_FK1 FOREIGN KEY ( report_reason_code )
 REFERENCES REPORT_REASON (report_reason_code );


--	여행댓글 좋아요
ALTER TABLE TRIP_COMMENT_LIKE
 ADD CONSTRAINT TRIP_COMMENT_LIKE_FK FOREIGN KEY ( trip_review_like_user_no )
 REFERENCES USER_INFO (user_no );

ALTER TABLE TRIP_COMMENT_LIKE
 ADD CONSTRAINT TRIP_COMMENT_LIKE_FK1 FOREIGN KEY ( trip_review_comment_no )
 REFERENCES TRIP_REVIEW_COMMENT (trip_review_comment_no );


-- 여행 동행
ALTER TABLE TRIP_COMPANY
 ADD CONSTRAINT TRIP_COMPANY_FK FOREIGN KEY ( trip_course_no )
 REFERENCES TRIP_COURSE (trip_course_no );

ALTER TABLE TRIP_COMPANY
 ADD CONSTRAINT TRIP_COMPANY_FK1 FOREIGN KEY ( trip_company_user_no )
 REFERENCES USER_INFO (user_no );


-- 여행 코스
ALTER TABLE TRIP_COURSE
 ADD CONSTRAINT TRIP_COURSE_FK FOREIGN KEY ( trip_course_user_no )
 REFERENCES USER_INFO (user_no );


-- 여행 코스 세부
ALTER TABLE TRIP_COURSE_CONTENT
 ADD CONSTRAINT TRIP_COURSE_CONTENT_FK FOREIGN KEY ( trip_course_no )
 REFERENCES TRIP_COURSE (trip_course_no );

ALTER TABLE TRIP_COURSE_CONTENT
 ADD CONSTRAINT TRIP_COURSE_CONTENT_FK1 FOREIGN KEY ( city_code )
 REFERENCES CITY (city_code );


-- 여행후기게시글 취향
ALTER TABLE TRIP_COURSE_TASTE
 ADD CONSTRAINT TRIP_COURSE_TASTE_FK FOREIGN KEY ( trip_course_no )
 REFERENCES TRIP_COURSE (trip_course_no );

ALTER TABLE TRIP_COURSE_TASTE
 ADD CONSTRAINT TRIP_COURSE_TASTE_FK1 FOREIGN KEY ( taste_code )
 REFERENCES TASTE_LIST (taste_code );


-- 여행 리뷰 게시판
ALTER TABLE TRIP_REVIEW
 ADD CONSTRAINT TRIP_REVIEW_FK FOREIGN KEY ( trip_review_user_no )
 REFERENCES USER_INFO (user_no );


-- 여행 리뷰 게시판 댓글
ALTER TABLE TRIP_REVIEW_COMMENT
 ADD CONSTRAINT TRIP_REVIEW_COMMENT_FK FOREIGN KEY ( trip_review_no )
 REFERENCES TRIP_REVIEW (trip_review_no );

ALTER TABLE TRIP_REVIEW_COMMENT
 ADD CONSTRAINT TRIP_REVIEW_COMMENT_FK1 FOREIGN KEY ( trip_review_comment_user_no )
 REFERENCES USER_INFO (user_no );


-- 여행 리뷰 게시판 별점
ALTER TABLE TRIP_REVIEW_STAR
 ADD CONSTRAINT TRIP_REVIEW_STAR_FK FOREIGN KEY ( trip_review_score_user_no )
 REFERENCES USER_INFO (user_no );

ALTER TABLE TRIP_REVIEW_STAR
 ADD CONSTRAINT TRIP_REVIEW_STAR_FK1 FOREIGN KEY ( trip_review_no )
 REFERENCES TRIP_REVIEW (trip_review_no );


-- 여행 리뷰 게시판 취향
ALTER TABLE TRIP_REVIEW_TASTE
 ADD CONSTRAINT TRIP_REVIEW_TASTE_FK FOREIGN KEY ( trip_review_no )
 REFERENCES TRIP_REVIEW (trip_review_no );

ALTER TABLE TRIP_REVIEW_TASTE
 ADD CONSTRAINT TRIP_REVIEW_TASTE_FK1 FOREIGN KEY ( taste_code )
 REFERENCES TASTE_LIST (taste_code );


-- 사용자 취향
ALTER TABLE USER_TASTE
 ADD CONSTRAINT USER_TASTE_FK FOREIGN KEY ( user_no )
 REFERENCES USER_INFO (user_no );

ALTER TABLE USER_TASTE
 ADD CONSTRAINT USER_TASTE_FK1 FOREIGN KEY ( taste_code )
 REFERENCES TASTE_LIST (taste_code );