package com.ohgiraffers.level01.basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Application6 {
    public static void main(String[] args) throws Exception {
        /*
        *
        이름과 전화번호를 띄어쓰기 기준으로 입력하세요 (검색하려면 'search', 종료하려면 'exit'): 홍길동010-1234-5678
        입력이 잘못 되었습니다. 다음 양식으로 입력해주세요 : <이름> <전화번호>
        이름과 전화번호를 띄어쓰기 기준으로 입력하세요 (검색하려면 'search', 종료하려면 'exit'): 홍길동 010-1234-5678
        추가 완료 : 홍길동 010-1234-5678
        이름과 전화번호를 띄어쓰기 기준으로 입력하세요 (검색하려면 'search', 종료하려면 'exit'): 유관순 010-9876-5432
        추가 완료 : 유관순 010-9876-5432
        이름과 전화번호를 띄어쓰기 기준으로 입력하세요 (검색하려면 'search', 종료하려면 'exit'): search
        검색 할 이름 : 유관순
        유관순씨의 전화번호 : 010-9876-5432
        이름과 전화번호를 띄어쓰기 기준으로 입력하세요 (검색하려면 'search', 종료하려면 'exit'): search
        검색 할 이름 : 이순신
        이순신씨의 번호는 등록 되어 있지 않습니다.
        이름과 전화번호를 띄어쓰기 기준으로 입력하세요 (검색하려면 'search', 종료하려면 'exit'): exit
        * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean isOk = true;
        Map<String, String> map = new HashMap<>();
        do {
            System.out.print("이름과 전화번호를 띄어쓰기 기준으로 입력하세요 (검색하려면 'search', 종료하려면 'exit') : ");
            String word = br.readLine();
            if(word.equals("search")) {
                System.out.print("검색 할 이름 : ");

                String searchWord = br.readLine();
                if(map.get(searchWord) != null) {
                    System.out.println(searchWord + "씨의 전화번호 : " + map.get(searchWord));
                } else {
                    System.out.println(searchWord + "씨의 번호는 등록 되어 있지 않습니다.");
                }

            } else if(word.equals("exit")) {
                isOk = false;
            } else if(!word.contains(" ")) {
                System.out.println("입력이 잘못 되었습니다. 다음 양식으로 입력해주세요 : <이름> <전화번호>");
            } else {
                String[] words = word.split(" ");
                map.put(words[0], words[1]);
            }
        } while (isOk);
    }
}
