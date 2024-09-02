package com.ohgiraffers.section04.scanner;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        /* java.util.Scanner 를 이용한 다양한 자료형 값 입력 받기 */

        /* 1. Scanner 객체 생성 */
        Scanner scanner = new Scanner(System.in);

        /* 2. 자료형별 값 입력 받기 */
        /* 2-1. 문자열 입력 : nextLine() */
        System.out.print("이름 입력 : ");
        String name = scanner.nextLine();
        System.out.println("입력 받은 값 : " + name);

        /* 2-2. 정수형 입력 : nextInt()
        * 숫자가 아닌 값을 입력하면 or int 범위를 벗어나는 값을 입력하면
        * java.util.InputMismatchException 이 발생 (런타임 에러) */
        System.out.print("나이 입력 : ");
        int age = scanner.nextInt();
        System.out.println("입력 받은 값 : " + age);

        /* 2-3. 실수형 입력 : nextDouble()
        * 정수값 입력은 실수로 반환되지만 숫자가 아닌 값 입력하면
        * java.util.InputMismatchException 이 발생 (런타임 에러) */
        System.out.print("키 입력 : ");
        double height = scanner.nextDouble();
        System.out.println("입력 받은 값 : " + height);

        /* 2-4. 논리값 입력 : nextBoolean()
        * true or false 외의 다른 값 입력 시 java.util.InputMismatchException 이 발생 (런타임 에러) */
        System.out.print("참과 거짓 중 하나를 true or false로 입력 : ");
        boolean isTrue = scanner.nextBoolean();
        System.out.println("입력 받은 값 : " + isTrue);

        /* 2-5. 문자값 입력
        * 문자를 직접 입력 받는 기능은 제공하지 않으며 문자열 -> 문자로 분리 해야 함
        * java.lang.String 의 charAt(index) 메소드 활용
        * 존재하지 않는 인덱스 입력 시 java.lang.StringIndexOutOfBoundsException 발생 */
        System.out.print("아무 문자나 입력 : ");
        char ch = scanner.nextLine().charAt(5);
        System.out.println(ch);

    }
}
