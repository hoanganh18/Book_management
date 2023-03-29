package com.example.book_management.book_management.dto;

public class DeleteBookFromGroupBook {
    private Integer bookId;
    private Integer groupBookId;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getGroupBookId() {
        return groupBookId;
    }

    public void setGroupBookId(Integer groupBookId) {
        this.groupBookId = groupBookId;
    }
}
