console.log(getSecondsToday());
console.log(getSecondsToTomorrow());

function getSecondsToday() {
    // 코드 작성
    const now = new Date(); // 현재 날짜와 시간
    const startOfDay = new Date(now.getFullYear(), now.getMonth(), now.getDate()); // 오늘 00:00:00
    const seconds = Math.floor((now - startOfDay) / 1000); // 밀리초를 초로 변환
    return seconds + "초나 흘렀습니다. 시간을 소중히 씁시다 ^^";
}

function getSecondsToTomorrow() {
    // 코드 작성
    const now = new Date();
    const tomorrow = new Date(now.getFullYear(), now.getMonth(), now.getDate()+1);
    const seconds = Math.floor((tomorrow-now) / 1000);
    return seconds + "초 밖에 안 남았습니다. 다시는 오지 않는 오늘입니다^^";
}
