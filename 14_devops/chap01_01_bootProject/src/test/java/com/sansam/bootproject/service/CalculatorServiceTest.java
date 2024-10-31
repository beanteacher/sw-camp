package com.sansam.bootproject.service;

import com.sansam.bootproject.dto.CalculatorDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculatorServiceTest {

    @Autowired
    private CalculatorService calculatorService;

    private static Stream<Arguments> provideDTOSource() {
        return Stream.of(
                Arguments.of(new CalculatorDTO(1,2)),
                Arguments.of(new CalculatorDTO(3,4)),
                Arguments.of(new CalculatorDTO(5,6)),
                Arguments.of(new CalculatorDTO(100,200)),
                Arguments.of(new CalculatorDTO(10000000,200000000))
        );
    }
    @ParameterizedTest
    @MethodSource("provideDTOSource")
    void test(CalculatorDTO input) {
        int expected = input.getNum1() + input.getNum2();
        int actual = calculatorService.plusTwoNumbers(input);

        assertEquals(expected, actual);
    }
}