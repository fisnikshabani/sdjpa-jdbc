package com.fisnikshabani.sdjpajdbc.repositories;

import com.fisnikshabani.sdjpajdbc.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
