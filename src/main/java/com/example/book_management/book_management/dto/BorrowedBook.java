package com.example.book_management.book_management.dto;

import javax.xml.crypto.Data;
import java.util.Date;

public class BorrowedBook {
    private Integer studentId;
    private Integer bookId;
    private Date returnDate;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
