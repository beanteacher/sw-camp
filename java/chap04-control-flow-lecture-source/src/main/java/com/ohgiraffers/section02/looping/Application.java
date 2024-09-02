package com.ohgiraffers.section02.looping;

public class Application {
    public static void main(String[] args) {
        A_for a = new A_for();
//        a.testSimpleForStatement();
//        a.testForExample3();
//        a.printSimpleGugudan();

        B_nestedFor b = new B_nestedFor();
//        b.printGugudanFromTwoToNine();
//        b.printStarInputRowTimes();
//        b.printTriangleStar();

        C_while c = new C_while();
//        c.testSimpleWhileStatement();
//        c.testWhileExample2();
        c.testSimpleDoWhileStatement();
    }
}
