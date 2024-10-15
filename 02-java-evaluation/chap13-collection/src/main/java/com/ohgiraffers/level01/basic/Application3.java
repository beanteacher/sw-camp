package com.ohgiraffers.level01.basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Application3 {
    public static void main(String[] args) throws Exception{
        /*
        *
        * 대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): 유관순
        유관순 고객님 대기 등록 되었습니다.
        대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): 홍길동
        홍길동 고객님 대기 등록 되었습니다.
        대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): next
        유관순 고객님 차례입니다.
        대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): 신사임당
        신사임당 고객님 대기 등록 되었습니다.
        대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): next
        홍길동 고객님 차례입니다.
        대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): next
        신사임당 고객님 차례입니다.
        대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): next
        대기 고객이 없습니다.
        대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit'): exit
        * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean isOk = true;
        Queue<String> que = new LinkedList<>();
        do {
            System.out.println("대기 고객 이름 입력 (다음 고객으로 넘어가려면 'next', 종료하려면 'exit') : ");
            String name = br.readLine();
            if(name.equals("next")) {
                if(!que.isEmpty()) {
                    System.out.println(que.poll() + "고객님 차례입니다.");
                } else System.out.println("대기 고객이 없습니다.");
            } else if(name.equals("exit")) {
                isOk = false;
            } else {
                que.offer(name);
            }
        } while (isOk);
    }
}
