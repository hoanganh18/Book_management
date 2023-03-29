package com.example.book_management.book_management.model;

import jakarta.persistence.*;

@Entity
@Table(name = "group_books", schema = "new_schema")
public class GroupBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_group_book")
    private Integer idGroupBook;
    @Column(name = "book_group_name", nullable = false)
    private String bookGroupName;
    @Column(name = "book_group_status")
    private Boolean bookGroupStatus;

    public GroupBook() {
    }

    public GroupBook(Integer idGroupBook, String bookGroupName, Boolean bookGroupStatus) {
        this.idGroupBook = idGroupBook;
        this.bookGroupName = bookGroupName;
        this.bookGroupStatus = bookGroupStatus;
    }

    public Integer getIdGroupBook() {
        return idGroupBook;
    }

    public void setIdGroupBook(Integer idGroupBook) {
        this.idGroupBook = idGroupBook;
    }

    public String getBookGroupName() {
        return bookGroupName;
    }

    public void setBookGroupName(String bookGroupName) {
        this.bookGroupName = bookGroupName;
    }

    public Boolean getBookGroupStatus() {
        return bookGroupStatus;
    }

    public void setBookGroupStatus(Boolean bookGroupStatus) {
        this.bookGroupStatus = bookGroupStatus;
    }

    @Override
    public String toString() {
        return "GroupBook{" +
                "idGroupBook=" + idGroupBook +
                ", bookGroupName='" + bookGroupName + '\'' +
                ", bookGroupStatus=" + bookGroupStatus +
                '}';
    }
}
