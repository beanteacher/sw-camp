const user = {
    id : 'user',
    login : function () {
        console.log(`${this.id} 로그인 되었습니다.`);
    }
}

const student = {
    __proto__ : user
}

// 프로토타입은 프로퍼티를 읽을 때만 사용하며 프로퍼티 추가, 수정, 삭제 연산은 객체에 직접한다.
student.id = 'user01';
// login 메소드 내의 this.는 프로토타입의 영향을 받지 않으며 this는 언제나 . 앞에 있는 객체를 의미한다.
student.login();

for(let key in student) {
    console.log(key);

    let isOwn = student.hasOwnProperty(key);
    if(isOwn) {
        console.log(`객체 자신의 property : ${key}`)
    } else {
        console.log(`상속 property : ${key}`)
    }
}
