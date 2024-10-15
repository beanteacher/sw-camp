package com.ohgiraffers.section02.stream;

import java.io.FileWriter;
import java.io.IOException;

public class Application4 {
    public static void main(String[] args) {
        /* FileWriter를 이해하고 사용할 수 있다. */
        try (FileWriter fw = new FileWriter("testWriter.txt")) {
            fw.write(97);
            fw.write('A');
            fw.write(new char[] {'a', 'b', 'c', 'd', 'e', 'f'});
            fw.write("안녕하세요");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
