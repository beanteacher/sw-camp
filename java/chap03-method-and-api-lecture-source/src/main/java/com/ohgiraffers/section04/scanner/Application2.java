package com.ohgiraffers.section04.scanner;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* nextLine() : 공백을 포함한 한 줄 입력을 위해 개행문자 전까지 읽어서 문자열로 반환 */
        System.out.print("인사말 입력 : ");
        String greeting = scanner.nextLine();
        System.out.println(greeting);
        /* next() : 공백 문자나 개행 문자 전까지 읽어서 문자열로 반환 */
        System.out.print("인사말 입력 : ");
        String greeting2 = scanner.next();
        System.out.println(greeting2);
    }
}
