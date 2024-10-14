class Animal {
    constructor(name, weight) {
        this.name = name;
        this.weight = weight;
    }
}

/* 다른 클래스를 상속받고 constructor를 선언하지 않으면 비어있는 생성자가 만들어진다.
* class Tiger extends Animal {
*   constructor(...args) {
*       super(...args);
*   }
* } */

class Deer extends Animal {
    constructor(name, weight, legLength) {
        /* 상속 클래스의 생성자는 부모 클래스의 생성자를 무조건 호출해야한다. */
        super(name, weight);
        this.legLength = legLength;
    }
}