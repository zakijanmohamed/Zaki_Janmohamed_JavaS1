package com.company.U1M5ChallengeJanmohamedZaki.dao;

import com.company.U1M5ChallengeJanmohamedZaki.model.Author;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorDaoTemplateImplementationTest {

    @Autowired
    protected AuthorDao authorDao;

    @Before
    public void setUp() throws Exception {
        List<Author> aList = authorDao.getAllAuthors();

        aList.stream()
                .forEach(author -> authorDao.deleteAuthor(author.getAuthor_id()));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addGetDeleteAuthor() {

        Author author = new Author();
        author.setFirst_name("Robert");
        author.setLast_name("Kiyosaki");
        author.setStreet("123 Kiyosaki Drive");
        author.setCity("Rich");
        author.setState("TX");
        author.setPostal_code("77777");
        author.setPhone("123-456-7890");
        author.setEmail("robert@email.com");

        Author author2 = authorDao.addAuthor(author);

        author = authorDao.getAuthor(author.getAuthor_id());

        assertEquals(author, author2);

        authorDao.deleteAuthor(author.getAuthor_id());

    }

    @Test
    public void getAllAuthors() {
        Author author = new Author();
        author.setFirst_name("Robert");
        author.setLast_name("Kiyosaki");
        author.setStreet("123 Kiyosaki Drive");
        author.setCity("Rich");
        author.setState("TX");
        author.setPostal_code("77777");
        author.setPhone("123-456-7890");
        author.setEmail("robert@email.com");

        author = authorDao.addAuthor(author);

        author = new Author();
        author.setFirst_name("J.K.");
        author.setLast_name("Rowling");
        author.setStreet("123 Hogwarts Blvd");
        author.setCity("Muggle");
        author.setState("TX");
        author.setPostal_code("77777");
        author.setPhone("123-456-7890");
        author.setEmail("hpotter@email.com");

        author = authorDao.addAuthor(author);

        List<Author> authorList = authorDao.getAllAuthors();

        assertEquals(authorList.size(), 2);
    }

    @Test
    public void updateAuthor() {

        Author author = new Author();
        author.setFirst_name("Robert");
        author.setLast_name("Kiyosaki");
        author.setStreet("123 Kiyosaki Drive");
        author.setCity("Rich");
        author.setState("TX");
        author.setPostal_code("77777");
        author.setPhone("123-456-7890");
        author.setEmail("robert@email.com");

        author = authorDao.addAuthor(author);

        author.setFirst_name("ROBERTO");
        author.setPhone("111-222-3456");
        author.setEmail("robertoUPDATEDhis@email.com");

        authorDao.updateAuthor(author);

        Author author2 = authorDao.getAuthor(author.getAuthor_id());

        assertEquals(author2, author);

    }
}