package com.company.U1M5ChallengeJanmohamedZaki.dao;

import com.company.U1M5ChallengeJanmohamedZaki.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.List;

@Repository
public class AuthorDaoTemplateImplementation implements AuthorDao {

    // Prepared statement strings
    private static final String INSERT_AUTHOR_SQL =
            "Insert into author (first_name, last_name, street, city, state, postal_code, phone, email) values (?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SELECT_AUTHOR_SQL =
            "select * from author where author_id = ?";

    private static final String SELECT_ALL_AUTHORS_SQL =
            "select * from author";

    private static final String UPDATE_AUTHOR_SQL =
            "update author set first_name = ?, last_name = ?, street = ?, city = ?, state =?, postal_code =?, phone =?, email =? where author_id =?";

    private static final String DELETE_AUTHOR_SQL =
            "delete from author where author_id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorDaoTemplateImplementation(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Author getAuthor(int author_id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_AUTHOR_SQL, this::mapRowToAuthor, author_id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }

    @Override
    @Transactional
    public Author addAuthor(Author author) {
        jdbcTemplate.update(INSERT_AUTHOR_SQL,
                author.getFirst_name(),
                author.getLast_name(),
                author.getStreet(),
                author.getCity(),
                author.getState(),
                author.getPostal_code(),
                author.getPhone(),
                author.getEmail());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        author.setAuthor_id(id);
        return author;
    }


    @Override
    public List<Author> getAllAuthors() {
        return jdbcTemplate.query(SELECT_ALL_AUTHORS_SQL, this::mapRowToAuthor);
    }

    @Override
    public void updateAuthor(Author author) {
        jdbcTemplate.update(UPDATE_AUTHOR_SQL,
                author.getFirst_name(),
                author.getLast_name(),
                author.getStreet(),
                author.getCity(),
                author.getState(),
                author.getPostal_code(),
                author.getPhone(),
                author.getEmail(),
                author.getAuthor_id());

    }

    @Override
    public void deleteAuthor(int author_id) {
        jdbcTemplate.update(DELETE_AUTHOR_SQL, author_id);

    }


    private Author mapRowToAuthor(ResultSet rs, int rowNum) throws SQLException {
        Author author = new Author();
        author.setAuthor_id(rs.getInt("author_id"));
        author.setFirst_name(rs.getString("first_name"));
        author.setLast_name(rs.getString("last_name"));
        author.setStreet(rs.getString("Street"));
        author.setCity(rs.getString("City"));
        author.setState(rs.getString("State"));
        author.setPostal_code(rs.getString("postal_code"));
        author.setPhone(rs.getString("Phone"));
        author.setEmail(rs.getString("Email"));

        return author;
    }
}
