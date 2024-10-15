package com.ohgiraffers.section03.uses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Application2 {
    public static void main(String[] args) {
        /* try with resource 구문의 문법을 이해하고 사용할 수 있다.
        * jdk 1.7에서 추가 된 문법으로 close 해야 하는 인스턴스를 try 옆 소괄호 안에서 생성하면
        * 해당 블럭이 종료 될 때 자동으로 close 처리를 한다. */

        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
