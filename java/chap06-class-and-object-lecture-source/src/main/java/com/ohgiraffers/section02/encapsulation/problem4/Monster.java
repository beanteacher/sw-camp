package com.ohgiraffers.section02.encapsulation.problem4;

public class Monster {
    /* 접근 제한자
    * 클래스 혹은 클래스의 멤버에 참조 연산자로 접근할 수 있는 범위를 제한하기 위한 키워드
    * 1. public : 접근 제한 없음
    * 2. protected : 동일 패키지 내 접근 허용 (단, 상속 관계 시 다른 패키지도 접근 허용)
    * 3. default : 동일 패키지 내 접근 허용 (작성하지 않는 것이 default)
    * 4. private : 해당 클래스 내부만 접근 허용
    * 위의 4가지 접근 제한자는 클래스의 멤버(필드, 메소드)에 모두 사용 가능하다.
    * 단, 클래스 선언 시 사용하는 접근 제한자는 public, default 뿐이다.
    * */

    private String kinds;
    private int hp;

    public void setInfo(String info) { this.kinds = info; }
    public void setHp(int hp) {
        this.hp = Math.max(hp, 0);
    }
    public String getInfo() {
        return kinds + " " + hp;
    }
}
