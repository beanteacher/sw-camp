package com.ohgiraffers.section01.list.run;

import java.util.LinkedList;
import java.util.List;

public class Application3 {
    public static void main(String[] args) {
        /* LinkedList에 대해 이해하고 사용할 수 있다. */
        LinkedList<String> linkedList = new LinkedList<>();

        /* List 인터페이스에 있는 내용을 동일하게 수행할 수 있다. (내부 구현 코드는 구현체마다 다르지만) */
        linkedList.add("apple");
        linkedList.add("banana");
        linkedList.add("mango");
        linkedList.add("orange");
        linkedList.add("grape");

        for(int i = 0; i < linkedList.size(); i++) {
            System.out.println(i + " : " + linkedList.get(i));
        }

        linkedList.remove(1);

        for(String str : linkedList) {
            System.out.println(str);
        }

        linkedList.set(0, "peach");

        System.out.println(linkedList);

        System.out.println(linkedList.isEmpty());
        linkedList.clear();
        System.out.println(linkedList.isEmpty());

        /* LinkedList는 ArrayList와 사용 방법이 유사하다. List 인터페이스를 상속 받았기 때문이다.
        * 단, 내부적으로 요소를 저장하는 방법의 차이가 있는 것이니 특징을 파악하고
        * 적합한 자료 구조를 구현한 클래스를 선택해서 쓰는 것이 좋다.
        * ~first, ~last 접미어를 붙여 순차적 기능을 강조한 함수들이 LinkedList에는 정의 되어 있다.
        * */
        linkedList.add("java");
        linkedList.addFirst("hello");
        linkedList.addLast("world");
        System.out.println(linkedList);
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        linkedList.removeFirstOccurrence("world");
        linkedList.removeLastOccurrence("java");
        System.out.println(linkedList);

    }
}
