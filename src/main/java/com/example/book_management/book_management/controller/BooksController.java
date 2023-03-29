package com.example.book_management.book_management.controller;

import com.example.book_management.book_management.dto.BaseResponse;
import com.example.book_management.book_management.dto.BookResponse;
import com.example.book_management.book_management.model.Book;
import com.example.book_management.book_management.model.Teacher;
import com.example.book_management.book_management.repository.BooksRepository;
import com.example.book_management.book_management.repository.GroupBookRepository;
import com.example.book_management.book_management.exceptions.BadRequestExceptions;
import com.example.book_management.book_management.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class BooksController {
    @Autowired
    BooksRepository booksRepository;
    @Autowired
    GroupBookRepository groupBookRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping("/books")
    public List<Book> getAllListBook() {
        return booksRepository.getAllListBook();
    }
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable(name = "id") Integer id){
        return booksRepository.findBookByid(id);
    }

 /*   @GetMapping("/books/simple")
    public List<Book> getListBookSimple(){
        BookResponse bookResponse = new BookResponse();
        List<Book> listBook = booksRepository.getAllListBook();
        for(Book b: listBook){
            bookResponse.setId(b.getId());
            bookResponse.setAuthor(b.getBookAuthor());
            bookResponse.setName(b.getBookName());
        }
   }*/

    @GetMapping("/teachers")
    public List<Teacher> getListTeacher(){
        return teacherRepository.getListTeacher();
    }

    @GetMapping("/books/map")
    public Book getBook(@RequestParam(name = "id") Integer id, @RequestParam(name = "bookName", required = false) String bookName){
        return booksRepository.findBook(id,bookName);
    }

    @PostMapping("/books")
    public ResponseEntity addBook(@RequestBody Book book) throws ParseException, BadRequestExceptions {
        if (book.getBookName().length() > 25) {
            throw new BadRequestExceptions("Vượt quá ký tự ", 1213);
        }
        List<Book> bookOptional = booksRepository.getListNameBook(book.getBookName());
        if(bookOptional.size()>0){
            throw new BadRequestExceptions("Ten bi trung!!",1213);
        }
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setMessage("Thêm thành công");
            baseResponse.setCode(4);
            book.setBookStatus(false);
            booksRepository.save(book);
            return ResponseEntity.ok(baseResponse);
    }

    @PutMapping("/books/{id}")
    public Book editBook(@PathVariable(name = "id") Integer id, @RequestBody Book book) throws BadRequestExceptions {
        if (booksRepository.findBookByid(id) == null) {
            throw new BadRequestExceptions("Không tìm thấy Id " + id, 1213);
        }
        book.setId(id.intValue());
        book.setBookStatus(false);
        booksRepository.save(book);
        return book;
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity deleteBookbyId(@PathVariable(name = "id") Integer id) throws BadRequestExceptions {
        Book book = booksRepository.findBookByid(id);
        if (booksRepository.findBookByid(id) == null) {
            throw new BadRequestExceptions("Không tìm thấy Id: " + id, 1214);
        }
        book.setBookStatus(true);
        booksRepository.save(book);
        return ResponseEntity.ok().build();
    }
}
