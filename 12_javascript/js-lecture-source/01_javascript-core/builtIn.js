console.log(getWeekDay(2022, 6, 21));       // 2022년 6월 21일
console.log(getWeekDay(2022, 12, 12));      // 2022년 12월 12일

function getWeekDay(year, month, date) {
    // 코드 작성
    // JavaScript의 Date 객체는 월을 0부터 시작하므로 1을 빼줍니다.
    const day = new Date(year, month - 1, date);
    const weekdays = ['일', '월', '화', '수', '목', '금', '토'];

    // getDay() 메서드는 0(일요일)부터 6(토요일)까지의 숫자를 반환합니다.
    return weekdays[day.getDay()];
}