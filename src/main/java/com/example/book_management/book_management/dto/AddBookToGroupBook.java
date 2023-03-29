package com.example.book_management.book_management.dto;

public class AddBookToGroupBook {
      private Integer bookId;
      private  Integer groupbookId;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getGroupbookId() {
        return groupbookId;
    }

    public void setGroupbookId(Integer groupbookId) {
        this.groupbookId = groupbookId;
    }
}
