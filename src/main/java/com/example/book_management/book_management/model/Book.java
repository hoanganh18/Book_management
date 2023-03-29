package com.example.book_management.book_management.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "book", schema = "new_schema")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "book_name", nullable = false,length = 25)
    private String bookName;
    @Column(name = "book_author", nullable = false)
    private String bookAuthor;
    @Column(name = "book_status")
    private Boolean bookStatus;
    @Column(name = "book_price")
    private Double bookPrice;
   @Column(name = "is_deleted")
    private Boolean isDeleted;
    @Column(name = "id_group_book")
    private Integer idGroupBook;
    @Column(name = "student_id")
    private Integer studentId;
    @Column(name = "borrowed_date")
    private Date borrowedDate;
    @Column(name = "return_date")
    private Date returnDate;
    @ManyToOne
    @JoinColumn(name = "id_group_book", insertable = false, updatable = false)
    private GroupBook groupBook;

    public Book() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Boolean getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Integer getIdGroupBook() {
        return idGroupBook;
    }

    public void setIdGroupBook(Integer idGroupBook) {
        this.idGroupBook = idGroupBook;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Book(Integer id, String bookName, String bookAuthor, Boolean bookStatus, Double bookPrice, Boolean isDeleted, Integer idGroupBook, Integer studentId, Date borrowedDate, Date returnDate) {
        this.id = id;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookStatus = bookStatus;
        this.bookPrice = bookPrice;
        this.isDeleted = isDeleted;
        this.idGroupBook = idGroupBook;
        this.studentId = studentId;
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookStatus=" + bookStatus +
                ", bookPrice=" + bookPrice +
                ", isDeleted=" + isDeleted +
                ", idGroupBook=" + idGroupBook +
                ", studentId=" + studentId +
                ", borrowedDate=" + borrowedDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
