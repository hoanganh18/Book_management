package com.example.book_management.book_management.exceptions;

import com.example.book_management.book_management.dto.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ExceptionAdvicer {
    @ExceptionHandler(value = BadRequestExceptions.class)
    public ResponseEntity<Object> badRequestException(BadRequestExceptions exceptions) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(2);
        baseResponse.setMessage(exceptions.getMessage());
        return new ResponseEntity<>(baseResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> notFoundException(NotFoundException exception) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(3);
        baseResponse.setMessage(exception.getMessage());
        return new ResponseEntity<>(baseResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleUnwantedException(Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(500).body("Unknow error");
    }
}
