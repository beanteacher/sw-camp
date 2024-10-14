const user = {
    activate : true,
    login : function () {
        console.log("로그인 되었습니다.");
    }
}

const student = {
    passion : true
}

student.__proto__ = user; // __proto__ 는 [[Prototype]]의 getter, setter

/* student의 프로토타입은 user이다. 또는 student는 user를 상속받는다. 라고 표현한다.
* 프로토타입에서 상속받은 프로퍼티를 상속 프로퍼티라고 한다. */

/* 프로토타입 체인 */
const greedyStudent = {
    class : 2,
    __proto__ : student
}

// 상속의 상속