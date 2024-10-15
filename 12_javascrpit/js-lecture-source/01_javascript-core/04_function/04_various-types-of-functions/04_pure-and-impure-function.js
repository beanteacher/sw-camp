// 순수 함수와 비순수 함수
// 순수 함수 : 외부 상태에 의존하지 않고 변경하지 않는 함수
// 비순수 함수 : 외부 상태에 의존하거나 외부 상태를 변경하는 함수
// 함수 외부의 상태의 변경을 지양하는 순수 함수를 사용하는 것이 좋다.

var cnt = 0;

// 순수 함수는 최소 하나 이상의 인수를 전달 받으며 인수의 불변성을 유지한다.
function increase(n) { return ++n; }
cnt = increase(cnt);
console.log(cnt);

// 비순수 함수는 외부 상태에 의존하며 외부 상태를 변경하여 상태 변화를 추적하기 어렵게 한다.
function decrease() { return --cnt; }
decrease();
console.log(cnt);