package com.ohgiraffers.section03.filterstream;

import java.io.*;

public class Application1 {
    public static void main(String[] args) {
        /* 필터 스트림(보조 스트림) : 기반 스트림에 추가 되어 성능 향상, 기능 추가
        * BufferedReader/Writer : 버퍼 공간을 이용하여 데이터를 쌓아 두었다가 입출력하여 입출력 횟수를 줄이고 성능을 향상
        * */

        BufferedWriter writer = null;

        try {
            /* 보조 스트림 객체 생성 시에는 생성자의 인자로 연결 될 기반 스트림을 전달한다. */
            writer = new BufferedWriter(new FileWriter("testBuffered.txt"));

            writer.write("안녕하세요.\n");
            writer.write("반갑습니다.\n");

            /* 버퍼를 이용하는 경우 버퍼가 가득 차면 자동으로 내보내기를 하지만 가득 차지 않은 경우 flush() 로 내보내기를
            * 해야 출력이 이루어진다. */
            // writer.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if(writer != null) {
                try {
                    /* close()를 호출하면 내부적으로 flush()를 실행하고 난 뒤 자원을 반납한다. */
                    writer.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        try(BufferedReader reader = new BufferedReader(new FileReader("testBuffered.txt"))) {

            /* readLine() 메소드 기능을 추가로 제공하고 있다.
            * 버퍼의 한 줄을 읽어와서 문자열로 반환하며 더 이상 읽어올 값이 없을 경우 null이 반환 된다. */
            String temp;
            while((temp = reader.readLine()) != null) {
                System.out.println(temp);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
