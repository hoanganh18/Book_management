package com.example.book_management.book_management.repository;

import com.example.book_management.book_management.model.Book;
import com.example.book_management.book_management.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Book,Integer> {
    @Query("SELECT b FROM Book b where b.bookStatus = false ")
    public List<Book> getAllListBook();

    @Query("SELECT b FROM Book b Where b.id = ?1")
    public Book findBookByid(Integer id);
    @Query("SELECT b FROM Book b Where b.id = ?1 and b.bookName = ?2")
    public Book findBook(Integer id,String bookName);
   @Query("SELECT b From Book b where b.idGroupBook =?1")
    public List<Book> getListGroupBookById(Integer idGroupBook);
   @Query("SELECT b From Book b where b.bookName=?1 ")
   public List<Book> getListNameBook(String bookName);



}
