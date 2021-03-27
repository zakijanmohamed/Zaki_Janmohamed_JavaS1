package com.company.U1M5ChallengeJanmohamedZaki.dao;

import com.company.U1M5ChallengeJanmohamedZaki.model.Book;

import java.util.List;

public interface BookDao {

    Book addBook(Book book); //create
    Book getBook (int book_id); //read
    List<Book> getAllBooks();    //read all
    void updateBook (Book book); //update
    void deleteBook (int book_id); //delete
    List<Book> getBooksByAuthor (int author_id); //get books by author
}
