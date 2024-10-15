// 단축 평가
// 표현식을 평가하는 도중 평가 결과가 확정 된 경우 나머지 평가 과정을 생략하는 것
// &&, || 연산자 표현식의 결과가 때로는 boolean 값이 아닐 수도 있다

// OR의 경우 'apple'이 Truthy한 값이기 때문에 true로 평가 되고
// 논리 연산의 결과를 결정한 첫 번째 피연산자 'apple'을 그대로 반환한다.
console.log('apple' || 'banana');
console.log(false || 'banana');
// AND의 경우 좌항, 우항을 모두 확인해야 하므로
// 논리 연산의 결과를 결정한 두 번째 피연산자 'banana'를 그대로 반환한다.
console.log('apple' && 'banana');
console.log(false && 'banana');

// 단축 평가를 활용하면 if문을 대체할 수 있다.
var num  = 1;
num % 2 == 0 && console.log('짝수');
num % 2 == 0 || console.log('홀수');

// 객체를 가리키기를 기대하는 변수가 null 또는 undefined가 아닌지 확인하고
// 프로퍼티를 참조 할 때 단축 평가를 사용할 수 있다.
var obj = null;
// TypeError: Cannot read properties of null (reading 'value')
// var val = obj.value;

// obj가 Falsy(null, undefined) 값이면 좌항만 실행하여 val -> null
// obj가 Truthy 값이면 val -> obj.value
var val2 = obj && obj.value;
