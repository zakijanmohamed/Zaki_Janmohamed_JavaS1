package com.company.U1M5ChallengeJanmohamedZaki.dao;

import com.company.U1M5ChallengeJanmohamedZaki.model.Author;

import java.util.List;

public interface AuthorDao {

    Author addAuthor(Author author); //create
    Author getAuthor(int author_id); //read
    List<Author> getAllAuthors();    //read all
    void updateAuthor (Author author); //update
    void deleteAuthor (int author_id); //delete

}


