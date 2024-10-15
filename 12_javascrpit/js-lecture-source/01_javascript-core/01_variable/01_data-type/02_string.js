var string;
string = 'JavaScript';
string = "JavaScript";
string = `JavaScript`;  // 백틱(``)

string = '작은 따옴표로 감싼 문자열 내의 "큰 따옴표"는 문자열로 인식';
string = "큰 따옴표로 감싼 문자열 내의 '작은 따옴표'는 문자열로 인식";

// 템플릿 리터럴 : ES6부터 도입 된 멀티라인 문자열, 표현식 삽입 등
// 편리한 문자열 처리 기능을 제공하는 문자열 표기법

// var str = '안녕하세요.
//     반갑습니다.'; - 일반 문자열 내에서는 줄바꿈이 허용 되지 않는다.

var multiline = `안녕하세요 
    반갑습니다
    제 이름은 홍길동 입니다.`;    // 백틱을 사용하면 줄 바꿈 허용, 모든 공백 적용
console.log(multiline)

var lastName = '홍';
var firstName = '길동';

console.log('제 이름은 ' + lastName + firstName + "입니다.");
// 표현식 삽입을 이용하면 문자열 연산자보다 가독성 좋고 간편하게 문자를 조합할 수 있다.
console.log(`제 이름은 ${lastName}${firstName}입니다.`);
// 표현식 삽입은 반드시 백틱 내에서만 사용해야 한다.
console.log('제 이름은 ${lastName}${firstName}입니다.');






