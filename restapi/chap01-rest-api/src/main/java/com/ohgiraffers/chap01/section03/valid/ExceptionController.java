package com.ohgiraffers.chap01.section03.valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserException(UserNotFoundException e) {
        String code = "ERROR_CODE_0000";
        String description = "회원 정보 조회 실패";
        String detail = e.getMessage();

        return new ResponseEntity<>(new ErrorResponse(code, description, detail), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handlerMethodException(MethodArgumentNotValidException e) {
        String code = "";
        String description = "";
        String detail = "";

        /* 에러가 있다면 */
        if(e.getBindingResult().hasErrors()) {
            detail = e.getBindingResult().getFieldError().getDefaultMessage();
            String bindingResultCode = e.getBindingResult().getFieldError().getCode();
            switch (bindingResultCode) {
                case "NotNull" :
                    code = "ERROR_CODE_00001";
                    description = "필수 값이 누락되었습니다.";
                    break;
                case "NotBlank" :
                    code = "ERROR_CODE_00002";
                    description = "필수 값이 공백으로 처리되었습니다.";
                    break;
                case "Size" :
                    code = "ERROR_CODE_00003";
                    description = "알맞은 크기의 값이 입력되지 않았습니다.";
                    break;
            }
        }

        return new ResponseEntity<>(new ErrorResponse(code, description, detail), HttpStatus.BAD_REQUEST);
    }
}