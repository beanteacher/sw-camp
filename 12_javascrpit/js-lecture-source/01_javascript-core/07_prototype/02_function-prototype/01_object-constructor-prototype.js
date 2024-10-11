const user = {
    activate : true,
    login : function () {
        console.log("로그인 되었습니다.");
    }
}

function Student(name) {
    this.name = name;
}

//  여기서의 프로토타입은 앞에서 배운 프로토타입(__proto__)과 이름만 같을 뿐 실제로는 일반 프로퍼티이다.
Student.prototype = user;

// Function.prototype 은 new Function()을 호출할 때만 사용되며
// 이 때 만들어지는 객체이ㅡ [[Prototype]]을 할당한다.
let student = new Student("홍길동");
console.log(student.name);
console.log(student.activate);
student.login();