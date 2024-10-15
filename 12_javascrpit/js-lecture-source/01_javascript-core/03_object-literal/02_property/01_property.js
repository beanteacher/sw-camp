// 프로퍼티 키 : 빈 문자열을 포함하는 모든 문자열 또는 심벌 값
// 문자열이므로 따옴표를 사용하지만 식별자 네이밍 규칙을 따르는 경우 사용하지 않아도 되며
// 규칙을 따르지 않을 경우에는 반드시 따옴표 사용 (규칙 따를 것을 권장)
// 프로퍼티 값 : 자바스크립트에서 사용할 수 있는 모든 값
var obj = {
    normal : 'normal value',
    '@ s p a c e @' : 'space value',    // 특수문자 사용시 '' 필요
    0 : 1,                              // 숫자 키는 내부적으로 문자열로 변환
    var : 'var',                        // 예약어 키는 오류 발생하지 않지만 권장하지 않음
    normal : 'new value'                // 이미 존재하는 키를 중복 선언하면 나중에 선언한 프로퍼티로 덮어씀
};

console.log(obj);