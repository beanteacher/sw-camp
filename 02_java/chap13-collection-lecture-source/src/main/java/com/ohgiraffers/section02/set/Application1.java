package com.ohgiraffers.section02.set;

import java.util.*;

public class Application1 {
    public static void main(String[] args) {
        /* HashSet 클래스를 이해하고 사용할 수 있다. */
        HashSet<String> hset = new HashSet<>();
        /* 다형성을 적용하여 상위 인터페이스 타입을 사용 가능 */
        Set<String> hset2 = new HashSet<>();
        Collection<String> hset3 = new HashSet<>();

        /* Set 계열에 데이터 추가 시 add() 메소드 사용 */
        hset.add(new String("java"));
        hset.add(new String("mysql"));
        hset.add(new String("jdbc"));
        hset.add(new String("html"));
        hset.add(new String("css"));

        /* 저장 순서가 유지 되지 않는다. (내부적인 해시 연산의 결과로 저장 된다.) */
        System.out.println("hset: " + hset);

        /* 중복 값이 저장 되지 않는다.
        * 동일 객체뿐 아니라 동등 객체도 중복 값으로 판단하여 처리한다.
        * String 클래스에 hashCode(), equals()가 오버라이딩 되어 있기 때문이다.
        * */
        hset.add(new String("java"));
        System.out.println("hset: " + hset);

        /* 해당 객체 포함 여부를 동등 객체 기준으로 판단한다.
        * 내부적으로 equals() 메소드를 호출해서 사용한다. */
        System.out.println(hset.contains(new String("html")));

        /* 저장 된 객체를 인덱스 기준으로 순회할 수 없다.
        * 반복문을 통한 연속 처리 방법 */
        Object[] arr = hset.toArray();
        for(int i = 0; i < arr.length; i++){
            System.out.println(i + " : " + arr[i]);
        }

        /* Collection 인터페이스 상위 타입인 Iterable 인터페이스에 iterator() 메소드가 정의 되어 있다.
        * 따라서 Collection 타입이라면 반복자를 통한 순회가 가능하다. */
        Iterator<String> it = hset.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        for(String s : hset){
            System.out.println(s);
        }

    }
}
