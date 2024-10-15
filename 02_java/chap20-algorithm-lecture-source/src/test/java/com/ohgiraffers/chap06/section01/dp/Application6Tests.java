package com.ohgiraffers.chap06.section01.dp;

import com.ohgiraffers.chap05.section01.greedy.Application7;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class Application6Tests {
    private static String input1;
    private static Integer output1;
    @BeforeAll
    public static void set() {

        /* 예시1 */
        input1 = "4 7\n" +
                "6 13\n" +
                "4 8\n" +
                "3 6\n" +
                "5 12\n";
        output1 = 14;
    }

    public static Stream<Arguments> provideSource() {
        return Stream.of(
                arguments(input1, output1)
        );
    }
    @DisplayName("dp6")
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("provideSource")
    public void dp6test(String input, Integer output) throws Exception {
        Integer result = Application6.solution(input);
        Assertions.assertEquals(output, result);
    }
}
