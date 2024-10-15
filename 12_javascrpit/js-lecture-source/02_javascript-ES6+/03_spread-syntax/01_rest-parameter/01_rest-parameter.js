/* 나머지 매개변수 */
function merge(msg1, msg2) {
    return msg1 + msg2;
};

console.log(merge("안녕하세요."));
console.log(merge("안녕하세요.", "반갑습니다."));
console.log(merge("안녕하세요.", "반갑습니다", "제 이름은 홍길동입니다."));

/* 이 상황에서 나머지 매개변수 ...을 사용하면 매개변수를 한데 모아 배열에 담을 수 있다. */
function mergeAll(...args) {
    let msg = "";
    for(let arg of args) msg+= arg;
    return msg;
}

console.log(mergeAll("안녕하세요."));
console.log(mergeAll("안녕하세요.", "반갑습니다."));
console.log(mergeAll("안녕하세요.", "반갑습니다", "제 이름은 홍길동입니다."));
