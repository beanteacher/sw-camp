package com.ohgiraffers.section02.set;

import java.util.Set;
import java.util.TreeSet;

public class Application3 {
    public static void main(String[] args) {
        /* TreeSet에 대해 이해하고 사용할 수 있다. */
        TreeSet<String> tset = new TreeSet<>();

        tset.add("java");
        tset.add("mysql");
        tset.add("jdbc");
        tset.add("html");
        tset.add("css");

        /* 자동 오름차순 정렬하여 이진 트리의 형태로 요소를 저장하고 있다.
        * String 클래스에 implements Comparable 을 통해 compareTo 메소드가 오버라이딩 되어 있는 기준으로 정렬 된다. */
        System.out.println("tset: " + tset);

        for(String s : tset) {
            System.out.println(s);
        }

        /* 정렬, 중복 제거 특징을 이용한 로또 번호 발생기 */
        Set<Integer> lotto = new TreeSet<>();

        while(lotto.size() < 6) {
            lotto.add(((int)(Math.random() * 45)) + 1);
        }

        System.out.println("lotto: " + lotto);

    }
}
