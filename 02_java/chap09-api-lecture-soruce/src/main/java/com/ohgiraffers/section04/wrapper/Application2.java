package com.ohgiraffers.section04.wrapper;

public class Application2 {
    public static void main(String[] args) {
        /* parsing : 문자열 값을 기본 자료형으로 변경 */

        /* 해당 자료형으로 parsing 될 수 없는 문자열이 제공 되면 exception 발생 */
        byte b = Byte.parseByte("1");
        short s = Short.parseShort("1");
        int i = Integer.parseInt("1");
        long l = Long.parseLong("1");
        float f = Float.parseFloat("1");
        double d = Double.parseDouble("1.0");
        boolean bl = Boolean.parseBoolean("true");
        System.out.println(bl);
        /* Character는 parsing 기능을 제공하지 않는다. */
    }
}
