package com.ohgiraffers.section01.list.run;

import java.util.*;

public class Application1 {
    public static void main(String[] args) {
        /* ArrayList
        * : 배열의 단점을 보완. 배열은 크기 변경 불가, 요소의 추가/삭제/정렬 등이 복잡.
        * 이러한 기능을 메소드로 구현해서 제공하고 있으며 속도가 빨라지는 것은 아니다.
        * */

        /* 다형성을 이용해서 상위 레퍼런스로 ArrayList 객체를 참조할 수 있다.
        * List 인터페이스 하위의 다양한 구현체들로 타입 변경이 가능하므로
        * 상위 타입으로 선언하는 것이 더 유연한 코드를 작성하는 방법이다. */
        ArrayList alist = new ArrayList();
        List list = new ArrayList();
        Collection clist = new ArrayList();

        /* add 메소드를 통해 element(요소)를 저장할 수 있고 현재는 Object 하위 타입 모두를 저장할 수 있다. */
        alist.add("apple");
        alist.add(123);
        alist.add(45.67);
        alist.add(new Date());

        /* 저장 순서가 유지 되며 index(순번)이 적용 된다. */
        System.out.println("alist : " + alist);

        /* 배열의 크기가 아니라 저장 된 요소의 개수를 반환한다.
        * 내부 관리 배열의 사이즈는 외부에서 알 필요가 없으므로 기능으로 제공하지 않는다. */
        System.out.println("alist.size() : " + alist.size());

        for(int i = 0; i < alist.size(); i++) {
            /* get 메소드에 index를 전달하여 하나의 요소에 접근 가능하다. */
            System.out.println(i + " : " + alist.get(i));
        }

        /* 데이터의 중복 저장 */
        alist.add("apple");
        System.out.println("alist : " + alist);

        /* 원하는 위치에 값을 추가할 수 있다. */
        alist.add(1, "banana");
        System.out.println("alist : " + alist);

        /* 저장 된 값을 삭제할 때는 remove() */
        alist.remove(2);
        System.out.println("alist : " + alist);

        /* 지정 된 위치의 값 수정 */
        alist.set(1, true);
        System.out.println("alist : " + alist);

        /* 모든 컬렉션 프레임워크는 제네릭 클래스로 작성 되어 있다. */
        List<String> stringList = new ArrayList<>();
        stringList.add("apple");
        stringList.add("banana");
        stringList.add("orange");
        stringList.add("mango");
        stringList.add("grape");
//        stringList.add(123);

        /* 저장 순서대로 유지 된 리스트가 정렬을 하면 문자열 오름차순으로 정렬 된다.
        * Collections 는 컬렉션에서 활용되는 기능들을 static 메소드로 구현해 둔 클래스이다. */
        System.out.println("stringList : " + stringList);
        Collections.sort(stringList);
        System.out.println("stringList : " + stringList);

    }
}
