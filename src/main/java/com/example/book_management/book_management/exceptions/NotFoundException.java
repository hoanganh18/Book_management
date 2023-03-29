package com.example.book_management.book_management.exceptions;

import jakarta.persistence.criteria.CriteriaBuilder;

public class NotFoundException extends Exception {
    private Integer code;
    private String errorMessage;

    public NotFoundException() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public NotFoundException(String message,Integer code) {
        super(message);
        this.code = code;

    }
}
