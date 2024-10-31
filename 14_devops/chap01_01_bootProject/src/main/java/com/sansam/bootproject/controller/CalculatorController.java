package com.sansam.bootproject.controller;

import com.sansam.bootproject.dto.CalculatorDTO;
import com.sansam.bootproject.service.CalculatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CalculatorController {

    private final CalculatorService calculatorService;

    @GetMapping("/health")
    public String healthCheck() {
        return "I'm alive";
    }

    @GetMapping("/plus")
    public ResponseEntity<CalculatorDTO> plusTwoNumbers(CalculatorDTO dto) {
        log.info("dto : {}", dto);

        dto.setSum(calculatorService.plusTwoNumbers(dto));

        return ResponseEntity.ok(dto);
    }
}
