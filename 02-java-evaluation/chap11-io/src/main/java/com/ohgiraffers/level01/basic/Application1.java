package com.ohgiraffers.level01.basic;

import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        /* ----- 입력 예시 -----
         *
         * (존재하는 파일명을 입력한 경우)
         * 파일 이름을 입력하세요 : hello.txt
         *
         * ----- 출력 예시 -----
         *
         * ===== 파일 내용 출력 =====
         * 안녕하세요. 반갑습니다. 제 이름은 홍길동입니다.
         *
         * ----- 입력 예시 -----
         *
         * (존재하지 않는 파일명을 입력한 경우)
         * 파일 이름을 입력하세요 : unknown.txt
         *
         * ----- 출력 예시 -----
         *
         * 오류 : 해당 이름을 가진 파일이 없습니다.
         *
         */

        Scanner scanner = new Scanner(System.in);
        System.out.print("파일 이름을 입력하세요 : ");
        String input = scanner.nextLine();
        File file = new File(input);
        if(!file.exists()) System.out.print("오류 : 해당 이름을 가진 파일이 없습니다.");
        else {
            try(FileReader fr = new FileReader(input)) {
                char[] carr = new char[(int)file.length()];

                fr.read(carr);
                for(char c : carr) {
                    System.out.print(c);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}