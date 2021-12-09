package com.fisnikshabani.sdjpajdbc.repositories;

import com.fisnikshabani.sdjpajdbc.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
