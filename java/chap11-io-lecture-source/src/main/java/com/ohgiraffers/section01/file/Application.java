package com.ohgiraffers.section01.file;

import java.io.File;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        /* File 클래스의 사용 용법을 이해할 수 있다. */

        /* 대상 파일이 존재하지 않더라도 인스턴스를 생성할 수 있다. */
        File file = new File("test.txt");

        try {
            /* 파일 생성 후 성공 실패 여부 boolean 반환 */
            boolean createSuccess = file.createNewFile();
            /* 최초 실행 시 생성 되어 true, 파일이 존재할 경우 새롭게 만들지 않아 false */
            System.out.println("createSuccess: " + createSuccess);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("file.length() : " + file.length());
        System.out.println("file.getPath() : " + file.getPath());
        System.out.println("file.getParent() : " + file.getParent());
        System.out.println("file.getAbsolutePath() : " + file.getAbsolutePath());

        boolean deleteSuccess = file.delete();
        System.out.println("deleteSuccess: " + deleteSuccess);

    }
}
