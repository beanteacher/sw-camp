package com.ohgiraffers.section07.statickeyword;

public class Application {
    public static void main(String[] args) {
        /* static 키워드에 대해 이해할 수 있다. */

        /* 1. static 키워드를 필드에서 사용 */
        StaticFieldTest sft1 = new StaticFieldTest();

        sft1.increaseNonStaticCount();
        sft1.increaseStaticCount();

        System.out.println("sft1.getNonStaticCount() = " + sft1.getNonStaticCount());
        System.out.println("sft1.getStaticCount() = " + sft1.getStaticCount());

        StaticFieldTest sft2 = new StaticFieldTest();

        sft2.increaseNonStaticCount();
        sft2.increaseStaticCount();

        System.out.println("sft2.getNonStaticCount() = " + sft2.getNonStaticCount());
        System.out.println("sft2.getStaticCount() = " + sft2.getStaticCount());
    }
}
