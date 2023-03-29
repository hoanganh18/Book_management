package com.example.book_management.book_management.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "students", schema = "new_schema")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;
    @Column(name = "student_name")
    private String studentName;

    @ManyToOne
    @JoinColumn(name = "student_id",updatable = false,insertable = false)
    private Book book;

    public Student() {
    }

    public Student(Integer studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;

    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
