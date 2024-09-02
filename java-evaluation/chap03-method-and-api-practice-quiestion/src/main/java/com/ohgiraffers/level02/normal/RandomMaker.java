package com.ohgiraffers.level02.normal;

import java.util.Random;

public class RandomMaker {

    static Random rand = new Random();

    public static int randomNumber(int min, int max) {
        return rand.nextInt(max-min) + min - 1;
    }

    public static String randomUpperAlpabet(int length) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length; i++) {
            result.append((char)((int)(rand.nextInt(26) + 97)));
        }
        return result.toString().toUpperCase();
    }

    public static String rockPaperScissors() {
        int randInt = rand.nextInt(3);
        if(randInt == 0) {
            return "rock";
        } else if (randInt == 1) {
            return "scissors";
        } else {
            return "paper";
        }
    }

    public static String tossCoin() {
        return rand.nextBoolean() ? "앞면" : "뒷면";
    }
}
