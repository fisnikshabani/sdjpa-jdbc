package com.fisnikshabani.sdjpajdbc.dao;

import com.fisnikshabani.sdjpajdbc.domain.Author;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;

@Component
public class AuthorDaoImpl implements AuthorDao{

    private final JdbcTemplate jdbcTemplate;

    private final DataSource source;

    public AuthorDaoImpl(JdbcTemplate jdbcTemplate, DataSource source) {
        this.jdbcTemplate = jdbcTemplate;

        this.source = source;
    }

    @Override
    public Author getById(Long id) {

        return jdbcTemplate.queryForObject("SELECT * FROM author where id = ?", getRowMapper(), id);
    }

    @Override
    public Author findAuthorByName(String firstName, String lastName){

        return jdbcTemplate.queryForObject("SELECT * FROM author WHERE first_name = ? and last_name = ?",
                getRowMapper(), firstName, lastName);
    }

    @Override
    public Author saveNewAuthor(Author author) {
        return null;
    }

    @Override
    public Author updateAuthor(Author saved) {
        return null;
    }

    @Override
    public void deleteAuthorById(Long id) {
    }

    private RowMapper<Author> getRowMapper(){
        return new AuthorMapper();
   }


}
