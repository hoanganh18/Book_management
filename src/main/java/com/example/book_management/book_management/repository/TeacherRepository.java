package com.example.book_management.book_management.repository;

import com.example.book_management.book_management.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    @Query("SELECT b From Teacher b")
    public List<Teacher> getListTeacher();
}
