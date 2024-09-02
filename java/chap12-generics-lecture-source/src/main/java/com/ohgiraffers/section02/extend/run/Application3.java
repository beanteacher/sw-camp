package com.ohgiraffers.section02.extend.run;

import com.ohgiraffers.section02.extend.*;

public class Application3 {
    public static void main(String[] args) {

        /* 와일드 카드에 대해 이해할 수 있다. */

        WildCardFarm wf = new WildCardFarm();

        /* 1. 매개변수 타입 제한이 없는 경우 => 어떤 토끼를 가진 토끼 농장이던 인자로 전달 가능 */
        wf.anyType(new RabbitFarm<>(new Rabbit()));
        wf.anyType(new RabbitFarm<>(new Bunny()));
        wf.anyType(new RabbitFarm<>(new DrunkenBunny()));

        /* 2. 매개변수 타입이 바니이거나 바니 후손 토끼를 가진 토끼 농장만 인자로 전달 가능 */
//        wf.extendType(new RabbitFarm<>(new Rabbit()));
        wf.extendType(new RabbitFarm<>(new Bunny()));
        wf.extendType(new RabbitFarm<>(new DrunkenBunny()));

        /* 3. 매개변수 타입이 바니이거나 바니 상위 타입 토끼를 가진 토끼 농장만 인자로 전달 가능 */
        wf.superType(new RabbitFarm<>(new Rabbit()));
        wf.superType(new RabbitFarm<>(new Bunny()));
//        wf.superType(new RabbitFarm<DrunkenBunny>(new DrunkenBunny()));

/*        RabbitFarm<DrunkenBunny> drunkenBunnyRabbitFarm = new RabbitFarm<>(new DrunkenBunny());
        wf.superType(drunkenBunnyRabbitFarm);
        RabbitFarm<Bunny> bunnyRabbitFarm = new RabbitFarm<>(new DrunkenBunny());
        wf.superType(bunnyRabbitFarm);*/

    }
}
