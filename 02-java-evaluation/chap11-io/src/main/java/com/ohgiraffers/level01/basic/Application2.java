package com.ohgiraffers.level01.basic;

import java.io.*;
import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        /* ----- 입력 예시 -----
         *
         * (원본 파일이 존재 하는 경우)
         * 원본 파일의 이름을 입력하세요 : origin.txt
         * 복사 파일의 이름을 입력하세요 : copy.txt
         *
         * ----- 출력 예시 -----
         *
         * 파일 복사가 성공적으로 완료 되었습니다.
         *
         * ----- 입력 예시 -----
         *
         * (원본 파일이 존재하지 않는 경우)
         * 원본 파일의 이름을 입력하세요 : origin2.txt
         * 복사 파일의 이름을 입력하세요 : copy2.txt
         *
         * ----- 출력 예시 -----
         *
         * 오류 : origin2.txt (지정된 파일을 찾을 수 없습니다)
         *
         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("원본파일의 이름을 입력하세요 : ");
        String originFileName = scanner.nextLine();
        System.out.print("복사파일의 이름을 입력하세요 : ");
        String copyFileName = scanner.nextLine();

        try(FileReader fr = new FileReader(originFileName);
            FileWriter fw = new FileWriter(copyFileName)) {

            char[] buf = new char[(int)new File(originFileName).length()];
            fr.read(buf);
            fw.write(buf);
        } catch (FileNotFoundException e) {
            System.out.println("오류 : " + originFileName + " (지정된 파일을 찾을 수 없습니다.)");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}