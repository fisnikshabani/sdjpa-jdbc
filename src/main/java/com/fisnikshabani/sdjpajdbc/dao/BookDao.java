package com.fisnikshabani.sdjpajdbc.dao;

import com.fisnikshabani.sdjpajdbc.domain.Book;

public interface BookDao {

    Book getById(Long id);

    Book findBookByTitle(String title);

    Book saveNewBook(Book book);

    Book updateBook(Book book);

    void deleteBookById(Long id);
}
