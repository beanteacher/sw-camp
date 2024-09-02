package com.ohgiraffers.level01.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Application4 {
    public static void main(String[] args) {
        /*
        학생 ID 입력('exit' 입력 시 종료): hello
        ID가 추가 되었습니다.
        학생 ID 입력('exit' 입력 시 종료): java
        ID가 추가 되었습니다.
        학생 ID 입력('exit' 입력 시 종료): programmer
        ID가 추가 되었습니다.
        학생 ID 입력('exit' 입력 시 종료): java
        이미 등록 된 ID입니다.
        학생 ID 입력('exit' 입력 시 종료): exit
        모든 학생의 ID : [java, programmer, hello]
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean isOk = true;

        try {
            Set<String> idSet = new HashSet<>();

            do {
                System.out.print("학생 ID 입력('exit' 입력 시 종료): ");
                String id = br.readLine();
                if(id.equals("exit")) {
                    isOk = false;
                } else if(idSet.contains(id)) {
                    System.out.println("이미 등록 된 ID 입니다.");
                } else {
                    idSet.add(id);
                }
            } while (isOk);

            System.out.println("모든 학생의 ID : " + idSet);
        } catch (IOException e) {

        }
    }
}
