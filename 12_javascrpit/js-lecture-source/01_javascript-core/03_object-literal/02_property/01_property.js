/* 프로퍼티 키 : 빈 문자열을 포함하는 모든 문자열 또는 심벌 값
* 문자열이므로 따옴표를 사용하지만 식별자 네이밍 규칙을 따르는 경우 사용하지 않아도 되며
* 규칙을 따르지 않을 경우에는 반드시 따옴표 사용 ( 규칙을 따를 것을 권장 ) */
var obj = {
    normal : "normal value",
    '@ s p a c e @' : 'space value', // 특수문자 사용 시 '' 필요
    0 : 1,
    var : 'var',
    normal : 'new value'
};

console.log(obj);

