package com.ohgiraffers.section03.math;

public class Application1 {
    public static void main(String[] args) {
        /* Math 클래스에서 제공하는 static 메소드를 호출할 수 있다. */
        /* java.lang 패키지의 하위 기능은 매우 자주 사용 되는 기능들이 있어 컴파일러가 자동으로
        * import java.lang.*; 코드를 추가한다.
        * */

        /* 1. 절대값 */
        System.out.println(java.lang.Math.abs(-7));

        /* 2. 최대값, 최소값 */
        System.out.println(Math.min(10, 20));
        System.out.println(Math.max(10, 20));

        /* 3. 난수 출력 */
        System.out.println(Math.random());
    }
}
