package com.ohgiraffers.section01.list.run;

import com.ohgiraffers.section01.list.comparator.AscendingPrice;
import com.ohgiraffers.section01.list.dto.BookDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Application2 {
    public static void main(String[] args) {
        /* ArrayList 사용자 정의 자료형으로 이용하기, 정렬하기 */

        List<BookDTO> bookList = new ArrayList<>();
        bookList.add(new BookDTO(1, "홍길동전", "허균", 50000));
        bookList.add(new BookDTO(2, "목민심서", "정약용", 30000));
        bookList.add(new BookDTO(3, "동의보감", "허준", 40000));
        bookList.add(new BookDTO(4, "삼국사기", "김부식", 46000));
        bookList.add(new BookDTO(5, "삼국유사", "일연", 58000));

        for(BookDTO bookDTO : bookList) {
            System.out.println(bookDTO);
        }

        /* implements Comparable 을 통해 compareTo 메소드(정렬 기준 반환)가 재정의 되어야만 사용 가능하다. */
//        Collections.sort(bookList);

        /* Comparator 인터페이스를 구현한 정렬 기준을 작성한다. */
        System.out.println("가격 오름차순 정렬 ==============");
//        Collections.sort(bookList, new AscendingPrice());
        bookList.sort(new AscendingPrice());
        for(BookDTO bookDTO : bookList) {
            System.out.println(bookDTO);
        }

        /* 정렬 기준을 계속 사용하는 경우 별도의 클래스를 만들어서 사용해도 되지만
        * 한 번만 사용하기 이해서 더 간편하게 익명 클래스(Anonymous class)를 사용할 수도 있다. */
        System.out.println("가격 내림차순 정렬 ==============");
        bookList.sort(new Comparator<BookDTO>() {
            @Override
            public int compare(BookDTO o1, BookDTO o2) {
                return o2.getPrice() - o1.getPrice();
            }
        });
        for(BookDTO bookDTO : bookList) {
            System.out.println(bookDTO);
        }

        System.out.println("제목 오름차순 정렬 ===========");
        bookList.sort(new Comparator<BookDTO>() {
            @Override
            public int compare(BookDTO o1, BookDTO o2) {
                /* 문자열 대소비교는 String 클래스에 정의 된 compareTo() 메소드를 활용한다. */
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        for(BookDTO bookDTO : bookList) {
            System.out.println(bookDTO);
        }

        System.out.println("제목 내림차순 정렬 ===========");
        /* implements Comparable<BookDTO> 수행 후에는 해당 코드가 동작 된다. */
        Collections.sort(bookList);
        for(BookDTO bookDTO : bookList) {
            System.out.println(bookDTO);
        }

    }
}
