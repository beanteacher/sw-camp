package com.ohgiraffers.section01.array;

public class Application5 {
    public static void main(String[] args) {
        /* 랜덤한 카드 한 장 뽑아서 출력 */
        String[] shapes = {"SPADE", "HEART", "DIAMOND", "CLOVER"};
        String[] cardNumbers = {"2", "3", "4", "5", "6", "7", "8", "9", "JACK", "QUEEN", "KING", "ACE"};

        int randomShapeIndex = (int) (Math.random() * shapes.length);
        int randomCardNumberIndex = (int) (Math.random() * cardNumbers.length);

        System.out.println(shapes[randomShapeIndex] + " " + cardNumbers[randomCardNumberIndex]);

    }
}
