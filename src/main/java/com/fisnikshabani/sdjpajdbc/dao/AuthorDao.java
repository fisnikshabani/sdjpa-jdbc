package com.fisnikshabani.sdjpajdbc.dao;

import com.fisnikshabani.sdjpajdbc.domain.Author;

public interface AuthorDao {

    Author getById(Long id);
    Author getAuthorByName(String firstName, String lastName);
    Author saveNewAuthor(Author author);

    Author updateAuthor(Author saved);
}
