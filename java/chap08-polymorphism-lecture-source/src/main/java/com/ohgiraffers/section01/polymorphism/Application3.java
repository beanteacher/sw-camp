package com.ohgiraffers.section01.polymorphism;

public class Application3 {
    public static void main(String[] args) {
        /* 다형성을 적용하여 매개변수에 활용할 수 있다. */

        Application3 app = new Application3();
        app.feed(new Rabbit());
        app.feed(new Tiger());
    }
    /* 다형성을 적용하지 않으면 각 동물별로 먹이를 주는 메소드가 작성 되어야 하며 동물의 종류가 늘어나면 추가 메소드 정의가 필요하다.
    * 지금은 Animal이라는 상위 타입으로 정의했기 때문에 동물이 추가 되어도 동일 메소드를 활용할 수 있다. */
    public void feed(Animal animal) { animal.eat(); }
}
