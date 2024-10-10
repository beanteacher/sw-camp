/* 객체 리터럴 생성 */
var student = {
    // 프로퍼티 : 객체의 상태를 나타내는 값으로 키-값 쌍으로 구성
    name : "유관순",
    age : 16,
    getInfo : function () {
        return `${this.name}(은)는 ${this.age}세 입니다.`;
    }
};

console.log(student.getInfo());