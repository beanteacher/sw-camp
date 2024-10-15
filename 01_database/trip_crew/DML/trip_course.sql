-- 여행 코스 작성
INSERT INTO TRIP_COURSE_CONTENT
(trip_course_no, city_code,  trip_detail_course_content,
 trip_detail_course_date, trip_detail_course_start_time, trip_detail_course_end_time)
VALUES 
(1, 1, '금오름', '2024-07-27', NULL, NULL),
(1, 1, '한라산', '2024-07-27', NULL, NULL),
(1, 1, '새별오름', '2024-07-28', NULL, NULL),
(1, 1, '마노르블랑', '2024-07-28', NULL, NULL),
(1, 1, '우도', '2024-07-29', NULL, NULL),
(1, 1, '성산일출봉', '2024-07-29', NULL, NULL),
(2, 2, '도쿄 스카이트리', '2024-07-27', '09:00:00', '10:00:00'),
(2, 2, '가부키초' ,'2024-07-27' ,  '10:00:00', '12:00:00'),
(2, 2, '롯폰기 힐스' ,'2024-07-27' ,  '13:00:00', '14:00:00'),
(2, 2, '긴자 와코 시계탑' ,'2024-07-27' ,  '14:00:00', '16:00:00'),
(2, 2, '우에노 공원' ,'2024-07-27' ,  '16:00:00', '18:00:00'),
(2, 2, '도쿄 시부야 스크램블 교차로' ,'2024-07-27' ,  '18:00:00', '19:00:00'),
(2, 2, '도쿄 디지니랜드' ,'2024-07-28' ,  '10:00:00', '19:30:00'),


(3, 9, '오사카성', '2024-07-30', '09:00:00', '10:00:00'),
(3, 9, '도톤보리' ,'2024-07-30' ,  '10:00:00', '12:00:00'),
(3, 9, '덴포잔 대관람차' ,'2024-07-30' ,  '13:00:00', '14:00:00'),
(3, 9, '우메다 스카이빌딩' ,'2024-07-30' ,  '14:00:00', '16:00:00'),
(3, 9, '유니버셜 스튜디오 재팬' ,'2024-07-31' ,  '08:00:00', '20:00:00'),


(4, 2, '우라야스 만게쿄 오오에도 온천','2024-07-29'  , '15:00:00', '19:00:00'),
(4, 2, '스시잔마이', '2024-07-29' , NULL , NULL);


COMMIT;


-- 여행모집자가 여행모집에 신청
INSERT INTO TRIP_COMPANY_PARTICIPANT 
(trip_company_no, trip_company_participant_user_no, trip_company_participant_state)
VALUES(
1, 1, 'wait'
),(
1, 2, 'wait'
),(
1, 7, 'wait'
),(
1, 10, 'wait'
),(
1, 20, 'wait'
),(
2, 3, 'wait'
),(
2, 6, 'wait'
),(
2, 7, 'wait'
),(
3, 21, 'wait'
),(
3, 22, 'wait'
),(
3, 6, 'wait'
),(
4, 5, 'wait'
),(
4, 6, 'wait'
);


-- 여행모집자가 여행모집요청자를 수락
UPDATE TRIP_COMPANY_PARTICIPANT
	SET trip_company_participant_state = 'accept'
	WHERE trip_company_no = 1 
	AND trip_company_participant_user_no IN(2,7,10,20);

-- 여행모집자가 여행모집요청자를 반려
UPDATE TRIP_COMPANY_PARTICIPANT 
	SET trip_company_participant_state = 'deny' 
	WHERE trip_company_no = 1 
	AND trip_company_participant_user_no = 1;
	
-- 여행모집자가 여행모집요청자를 강퇴
UPDATE TRIP_COMPANY_PARTICIPANT 
	SET trip_company_participant_state = 'ban' 
	WHERE trip_company_no = 1 
	AND trip_company_participant_user_no = 2
	AND trip_company_participant_state = 'accept';



COMMIT;

-- 여행모집요청 대기자 조회
SELECT 
		
		c.trip_company_title '여행동행제목'
		, c.trip_company_content '여행동행내용'
		, u2.user_name '여행동행 모집자'
		, u.user_name '여행동행 모집요청자'
	FROM TRIP_COMPANY c	
	JOIN TRIP_COMPANY_PARTICIPANT cp ON c.trip_company_no = cp.trip_company_no
	JOIN USER_INFO u ON u.user_no = cp.trip_company_participant_user_no
	JOIN USER_INFO u2 ON u2.user_no = c.trip_company_user_no
	WHERE c.trip_company_no = 2 
	AND trip_company_participant_state = 'wait';

-- 여행모집요청자가 스스로 나가기
UPDATE TRIP_COMPANY_PARTICIPANT
	SET trip_company_participant_state = 'quit'
	WHERE trip_company_no = 2 -- 상세조회를 통해 나갈테니 상위인 여행모집의 no는 파라미터로 전달된 값
	AND (trip_company_participant_state = 'wait' OR trip_company_participant_state = 'access')
	AND trip_company_participant_user_no = 3; -- 로그인을 했으니 user_no는 파라미터로 전달된 값
	
	
	
-- 댓글 작성자 프로필 조회 (상세조회 조회 페이지에 들어와있음.)
SELECT 
	u.user_name '댓글 작성자명'
	, u.user_phone_no '댓글 작성자 휴대폰번호'
	, u.user_gender '댓글 작성자 성별'
	, u.user_birth '댓글 작성자 생년월일'
	, IFNULL(u.user_mbti, 'MBTI가 등록되지 않은 회원입니다.') '댓글 작성자 MBTI'
	, if u.user_self_intro '댓글 작성자 자기소개'
FROM TRIP_REVIEW_COMMENT rc
JOIN USER_INFO u ON rc.trip_review_comment_user_no = u.user_no
WHERE rc.trip_review_comment_user_no = 7
AND trip_review_no = 1  -- 상세조회를 통해 댓글 작성자를 조회할테니 여행게시판 no는 파라미터로 전달된 값
