package com.ohgiraffers.level01.basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class Application5 {
    public static void main(String[] args) throws Exception {
        /*
        *
        단어 입력 ('exit' 입력 시 종료): 안녕
        단어 입력 ('exit' 입력 시 종료): java
        단어 입력 ('exit' 입력 시 종료): collection
        단어 입력 ('exit' 입력 시 종료): 프로그래밍
        단어 입력 ('exit' 입력 시 종료): exit
        정렬 된 단어 : [collection, java, 안녕, 프로그래밍] */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean isOk = true;
        TreeSet<String> treeSet = new TreeSet<>();
        do {
            System.out.print(" 단어 입력 ('exit' 입력 시 종료) : ");
            String word = br.readLine();
            if(word.equals("exit")) {
                isOk = false;
            } else {
                treeSet.add(word);
            }
        } while (isOk);

        System.out.println("정렬 된 단어 : " + treeSet);
    }
}
