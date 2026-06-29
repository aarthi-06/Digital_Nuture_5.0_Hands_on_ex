package com.librarymanagementboot.repository;

import com.librarymanagementboot.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}