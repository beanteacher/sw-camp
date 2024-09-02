package com.ohgiraffers.section01.intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Application1 {
    public static void main(String[] args) {
        /* Stream에 대해 이해하고 사용할 수 있다. */
        List<String> list = new ArrayList<>(Arrays.asList("hello", "stream", "world"));

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str.equals("stream")) {
                System.out.println("걸러낸 값 : " + str);
            }
        }
        /* iterator 객체는 이미 모두 사용 되었으므로 반복문은 동작하지 않으며 필요하다면
        * 새로운 iterator 객체를 만들어야 한다. */
        while (iterator.hasNext()) {
            String str = iterator.next();
            System.out.println("반복문 : " + str);
        }

        /* Iterator 대신 Stream의 기능을 활용 */
        list
                .stream()
                .filter("stream"::equals)
                .forEach(str -> System.out.println("걸러낸 값 : " + str));
    }
}
