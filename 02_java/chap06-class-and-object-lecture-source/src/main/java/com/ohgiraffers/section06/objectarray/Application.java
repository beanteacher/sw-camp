package com.ohgiraffers.section06.objectarray;

public class Application {
    public static void main(String[] args) {
        /* 객체 배열에 대해 이해할 수 있다. */
        Car[] cars = new Car[5];

        /* cars의 각 인덱스는 기본 값 null로 초기화 되어 있기 때문에 인덱스별로 인스턴스를 생성해야 한다. */
        cars[0] = new Car("페라리", 300);
        cars[1] = new Car("람보르기니", 300);
        cars[2] = new Car("롤스로이스", 300);
        cars[3] = new Car("부가티베이론", 300);
        cars[4] = new Car("포터", 300);

        /* 배열은 반복문을 통해 일괄 처리가 가능하다는 장점이 있다. */
        for(int i = 0; i < cars.length; i++) {
            cars[i].driveMaxSpeed();
        }

        /* 객체 배열도 할당과 동시에 초기화 할 수 있다. */
        Car[] cars2 = {
                new Car("페라리", 200),
                new Car("람보르기니", 200),
                new Car("롤스로이스", 200),
                new Car("부가티베이론", 200),
                new Car("포터", 200),
        };

        for (Car car : cars2) {
            car.driveMaxSpeed();
        }

        int[] arr = {1,2,3,4,5,};
        System.out.println(arr.length);

    }
}
