package com.ohgiraffers.section07.statickeyword;

public class StaticFieldTest {

    private int nonStaticCount;
    private static int staticCount;

    /* 두 필드의 값을 1씩 증가시키는 메소드 */
    public void increaseNonStaticCount() { this.nonStaticCount++; }
    public void increaseStaticCount() { StaticFieldTest.staticCount++; }

    public int getNonStaticCount() { return nonStaticCount; }
    public int getStaticCount() { return StaticFieldTest.staticCount; }
}
