/* 순수 함수와 비순수 함수
* 순수 함수 : 외부 상태에 의존하지 않고 변경하지 않는 함수
* 비순수 함수 : 외부 상태에 의존하거나 외부 상태를 변경하는 함수
* 함수 외부의 상태의 변경을 지양하는 순수 함수를 사용하는 것이 좋다. */

var cnt = 0;
function increase(n) {return ++n}
cnt = increase(cnt);
console.log(cnt);

function decrease() {return --cnt}
decrease();
console.log(cnt);