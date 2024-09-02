package com.ohgiraffers.section01.extend;

public class Application {
    public static void main(String[] args) {
        /* Car 인스턴스 테스트 */
        Car car = new Car();
        car.soundHorn();
        car.run();
        car.soundHorn();
        car.stop();
        car.soundHorn();

        /* 소방차, 레이싱카는 모두 자동차이다.
        * FireCar is a Car.
        * RacingCar is a Car.
        * => IS-A 관계가 성립하는 경우 상속을 사용할 수 있다.
        * */

        /* FireCar 인스턴스 테스트 */
        FireCar fireCar = new FireCar();
        fireCar.soundHorn();
        fireCar.run();
        fireCar.soundHorn();
        fireCar.stop();
        fireCar.soundHorn();

        /* FireCar 클래스에서는 아무것도 작성하지 않아도 Car 클래스의 메소드를 상속 받아 모두 사용할 수 있다.
        * 하지만 자식 클래스에 맞게 다르게 기능하게끔 오버라이딩(재작성) 해서 사용할 수도 있다.
        * 또는 추가적인 기능을 정의하여 부모 클래스를 확장할 수도 있다.
        * */
        fireCar.sprayWater();
//        car.sprayWater(); -> 부모는 자식의 멤버에 접근해서 사용할 수 없다.

        /* RacingCar 인스턴스 테스트 */
        RacingCar racingCar = new RacingCar();
        racingCar.soundHorn();
        racingCar.run();
        racingCar.soundHorn();
        racingCar.stop();
        racingCar.soundHorn();

        /* 레이싱카의 경우 경적 소리를 내는 것이 적합하지 않지만 Car를 상속 받았기 때문에 어쩔 수 없이 해당 기능을 가지게 됨.
        * 상속 구조로 인해 불필요한 기능이 추가 될 수도 있다.
        * */




    }
}










