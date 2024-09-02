package com.ohgiraffers.section02.extend;

public class WildCardFarm {

    public void anyType(RabbitFarm<?> farm) {
        farm.getRabbit().cry();
    }

    public void extendType(RabbitFarm<? extends Bunny> farm) {
        farm.getRabbit().cry();
    }

    public void superType(RabbitFarm<? super Bunny> farm) {
        farm.getRabbit().cry();
    }
}
