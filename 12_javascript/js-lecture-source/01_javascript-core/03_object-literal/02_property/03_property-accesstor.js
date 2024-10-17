/* 자바스크립트의 함수는 객체이다.
* 함수는 값으로 취급할 수 있고, 프로퍼티 값으로도 사용할 수 있다. */
var dog = {
    name : "뽀삐",
    eat : function (food) {
        console.log(`${this.name}(은)는 ${food}를 맛있게 먹어요.`);
    }
}

/* 1. 마침표 표기법 (dot notation) */
console.log(dog.name);
dog.eat("사료");
/* 2. 대괄호 표기법 (square bracket notation) */
console.log((dog["name"]));
dog["eat"]('닭가슴살');

var obj = {
    'dasy-key' : 'dash-value',
    "0":1,
}

console.log(obj);
console.log(obj["dasy-key"]);
console.log(obj["0"]);
console.log(obj[0]);