function Student(name, age) {
    this.name = name;
    this.age = age;
    this.getInfo = function() {
        return `${this.name}은 ${this.age}세 입니다.`;
    }
}

const student = new Student('장보고', 35);

/* 일반 함수와 생성자 함수의 형싱적인 차이는 없다.
* 단 new 연산자와 함께 호출 할 때 생성자 함수로 동작한다.
* new 연산자와 함께 호출하지 않으면 일반함수로 동작한다. */
const student = Student('강감찬', 35);