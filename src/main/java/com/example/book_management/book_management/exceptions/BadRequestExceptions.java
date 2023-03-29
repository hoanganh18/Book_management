package com.example.book_management.book_management.exceptions;

public class BadRequestExceptions extends  Exception {
    private Integer code;
    private String errorMessage;

    public BadRequestExceptions() {
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

    public BadRequestExceptions(String message,Integer code) {
        super(message);
        this.code = code;

    }
}
