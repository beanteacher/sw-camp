package com.sansam.bootproject.service;

import com.sansam.bootproject.dto.CalculatorDTO;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public int plusTwoNumbers(CalculatorDTO dto) {
        return dto.getNum1() + dto.getNum2();
    }
}
