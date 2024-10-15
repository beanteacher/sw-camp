package com.ohgiraffers.level01.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Application2 {
    /*
    방문 URL을 입력하세요 (단, exit를 입력하면 종료) : https://www.google.com/
    최근 방문 url : [https://www.google.com/]
    방문 URL을 입력하세요 (단, exit를 입력하면 종료) : https://github.com/
    최근 방문 url : [https://github.com/, https://www.google.com/]
    방문 URL을 입력하세요 (단, exit를 입력하면 종료) : https://www.notion.so/
    최근 방문 url : [https://www.notion.so/, https://github.com/, https://www.google.com/]
    방문 URL을 입력하세요 (단, exit를 입력하면 종료) : https://www.naver.com/
    최근 방문 url : [https://www.naver.com/, https://www.notion.so/, https://github.com/, https://www.google.com/]
    방문 URL을 입력하세요 (단, exit를 입력하면 종료) : https://github.com/
    최근 방문 url : [https://github.com/, https://www.naver.com/, https://www.notion.so/, https://github.com/, https://www.google.com/]
    방문 URL을 입력하세요 (단, exit를 입력하면 종료) : https://www.google.com/
    최근 방문 url : [https://www.google.com/, https://github.com/, https://www.naver.com/, https://www.notion.so/, https://github.com/]
    방문 URL을 입력하세요 (단, exit를 입력하면 종료) : exit*/

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            LinkedList<String> list = new LinkedList<>();
            boolean isInput = false;
            do {
                System.out.print("방문 URL 을 입력하세요 (단, exit를 입력하면 종료) : ");

                String url = br.readLine();
                if(!url.equals("exit")) {
                    isInput = true;
                    list.addFirst(url);

                    if(list.size() > 5) {
                        list.removeLast();
                    }
                    System.out.println("최근 방문 URL : " + list);
                } else isInput = false;

            } while (isInput);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
