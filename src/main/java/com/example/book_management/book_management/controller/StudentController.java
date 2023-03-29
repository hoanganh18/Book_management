package com.example.book_management.book_management.controller;

import com.example.book_management.book_management.dto.BaseResponse;
import com.example.book_management.book_management.dto.BorrowedBook;
import com.example.book_management.book_management.dto.ReturnBook;
import com.example.book_management.book_management.exceptions.BadRequestExceptions;
import com.example.book_management.book_management.model.Book;
import com.example.book_management.book_management.model.Student;
import com.example.book_management.book_management.repository.BooksRepository;
import com.example.book_management.book_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    BooksRepository booksRepository;

    @PostMapping("/borrowed")
    public ResponseEntity borrowedBook(@RequestBody BorrowedBook request) throws BadRequestExceptions, ParseException {
        Optional<Student> optionalStudent = studentRepository.findById(request.getStudentId());
        Optional<Book> bookOptional = booksRepository.findById(request.getBookId());
        BaseResponse baseResponse = new BaseResponse();
        if (optionalStudent == null || optionalStudent.isEmpty()) {
            throw new BadRequestExceptions("Hiện tại đang không có sinh viên có Id là!" + request.getStudentId(), 1213);
        }
        if (bookOptional == null || bookOptional.isEmpty()) {
            throw new BadRequestExceptions("Hiện tại không có sách nào có Id" + request.getBookId(), 1213);
        }
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            if (bookOptional.isPresent()) {
                Book book = bookOptional.get();

                if (book.getStudentId() == null) {
                    Date date = new Date();
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String strDate = dateFormat.format(date);
                    Date d = (Date) dateFormat.parse(strDate);

                    book.setBorrowedDate(d);
                    book.setStudentId(student.getStudentId());
                    book.setBookStatus(true);
                    book.setReturnDate(request.getReturnDate());
                    booksRepository.save(book);
                    baseResponse.setMessage("Mượn sách thành công");
                    baseResponse.setCode(5);
                }

            }
        }
        return ResponseEntity.ok(baseResponse);

    }

    @DeleteMapping("/borrowed")
    public ResponseEntity returnBook(@RequestBody ReturnBook request) throws BadRequestExceptions {
        Optional<Student> optionalStudent = studentRepository.findById(request.getStudentId());
        Optional<Book> bookOptional = booksRepository.findById(request.getBookId());
        BaseResponse baseResponse = new BaseResponse();
        if (optionalStudent == null || optionalStudent.isEmpty()) {
            throw new BadRequestExceptions("Hiện tại đang không có sinh viên có Id là!" + request.getStudentId(), 1213);
        }
        if (bookOptional == null || bookOptional.isEmpty()) {
            throw new BadRequestExceptions("Hiện tại không có sách nào có Id" + request.getBookId(), 1213);
        }
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            if (bookOptional.isPresent()) {
                Book book = bookOptional.get();
                if (!book.getStudentId().equals(student.getStudentId())) {
                    throw new BadRequestExceptions("Sinh viên không mượn sách này", 1213);
                }
                if (book.getStudentId().equals(student.getStudentId())) {
                    book.setStudentId(null);
                    book.setReturnDate(null);
                    book.setBorrowedDate(null);
                    book.setBookStatus(false);
                    booksRepository.save(book);
                    baseResponse.setMessage("Trả sách thành công");
                    baseResponse.setCode(6);
                }

            }
        }
        return ResponseEntity.ok().build();
    }

}
