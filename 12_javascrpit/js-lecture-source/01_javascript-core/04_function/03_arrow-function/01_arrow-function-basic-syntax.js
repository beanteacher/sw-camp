/* 화살표 함수 기본 문법
*  ES6에서 도입 된 화살표 함수는 function 키워드 대신 화살표를 사용해보다 간략하게
* 함수를 선언하는 방법이다. 상상 익명함수로 정의하며 본문이 한 줄인 함수를 작성할 때 유용하다. */

var message = function () {
    return 'hello world';
}

message = () => {
    return 'Arrow Function';
}

/* 명령문이 하나만 있을 경우 중괄호 생략 가능
* 함수 몸체 내부의 문이 값으로 평가 될 수 있는 표현식인 문이라면 암묵적으로 변환 */
message = () => 'simple~~!';