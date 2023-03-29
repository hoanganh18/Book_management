package com.example.book_management.book_management.repository;

import com.example.book_management.book_management.model.Book;
import com.example.book_management.book_management.model.GroupBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupBookRepository extends JpaRepository<GroupBook,Integer> {
    @Query("SELECT g FROM GroupBook g")
    public List<GroupBook> getListGroupBook();
    @Query("SELECT g FROM GroupBook g where g.idGroupBook =?1")
    public Book findGroupBookById(Integer id);


}
