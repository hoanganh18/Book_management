package com.example.book_management.book_management.controller;

import com.example.book_management.book_management.model.Book;
import com.example.book_management.book_management.model.GroupBook;
import com.example.book_management.book_management.repository.BooksRepository;
import com.example.book_management.book_management.repository.GroupBookRepository;
import com.example.book_management.book_management.dto.AddBookToGroupBook;
import com.example.book_management.book_management.dto.DeleteBookFromGroupBook;
import com.example.book_management.book_management.exceptions.BadRequestExceptions;
import com.example.book_management.book_management.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class GroupBookController {
    @Autowired
    GroupBookRepository groupBookRepository;
    @Autowired
    BooksRepository booksRepository;

    @GetMapping("/groupbooks/getall")
    public List<GroupBook> getListGroupBook() throws BadRequestExceptions{
        List<GroupBook> groupBook = groupBookRepository.getListGroupBook();
        if(groupBook == null || groupBook.size()==0){
           throw new BadRequestExceptions("Danh sách trống: ",1215);
        }
        return groupBookRepository.getListGroupBook();
    }

    @PostMapping("/groupbooks/create")
    public ResponseEntity addGroupBook(@RequestBody GroupBook groupBook) {
        groupBookRepository.save(groupBook);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/groupbooks/{id}")
    public GroupBook editGroupBook(@PathVariable(name = "id") Integer id, @RequestBody GroupBook groupBook)throws NotFoundException {
        if(groupBookRepository.findGroupBookById(id)==null){
            throw new NotFoundException("Không tìm thấy Id: "+ id,1231);
        }
        groupBook.setIdGroupBook(id.intValue());
        groupBookRepository.save(groupBook);
        return groupBook;
    }
    @PostMapping("groupbooks/add")
    public ResponseEntity addBookToGroupBook(@RequestBody AddBookToGroupBook request) throws BadRequestExceptions {
        Optional<Book> bookOptional = booksRepository.findById(request.getBookId());
        Optional<GroupBook> groupBookOptional = groupBookRepository.findById(request.getGroupbookId());
        if(!bookOptional.isPresent()){
            throw new BadRequestExceptions("Không tìm thấy Id: " + request.getBookId(),1213);
        }
        if(!groupBookOptional.isPresent()) {
            throw new BadRequestExceptions("Không tìm thấy Id: "+ request.getGroupbookId(),1214);
        }
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            if (groupBookOptional.isPresent()) {
                GroupBook groupBook = groupBookOptional.get();
                if (book.getIdGroupBook() == null) {
                    book.setIdGroupBook(groupBook.getIdGroupBook());
                    booksRepository.save(book);
                }
            }
        }
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("groupbooks")
    public ResponseEntity deleteBookFromGroupBook(@RequestBody DeleteBookFromGroupBook request) throws BadRequestExceptions {
        Optional<Book> bookOptional = booksRepository.findById(request.getBookId());
        Optional<GroupBook> groupBookOptional = groupBookRepository.findById(request.getGroupBookId());
        if(!bookOptional.isPresent()){
            throw new BadRequestExceptions("Không tìm thấy Id: "+ request.getBookId(), 1213);
        }
        if(!groupBookOptional.isPresent()){
            throw new BadRequestExceptions("Không tìm thấy Id: " + request.getGroupBookId(),1214);
        }
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            if (groupBookOptional.isPresent()) {
                GroupBook groupBook = groupBookOptional.get();
                if (book.getIdGroupBook() == groupBook.getIdGroupBook()) {
                    book.setIdGroupBook(null);
                    booksRepository.save(book);
                }
            }
        }
        return ResponseEntity.ok().build();
    }
}
