package com.company.U1M5ChallengeJanmohamedZaki.dao;

import com.company.U1M5ChallengeJanmohamedZaki.model.Author;
import com.company.U1M5ChallengeJanmohamedZaki.model.Book;
import com.company.U1M5ChallengeJanmohamedZaki.model.Publisher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookDaoTemplateImplementationTest {

    @Autowired
    protected BookDao bookDao;
    @Autowired
    protected AuthorDao authorDao;
    @Autowired
    protected PublisherDao publisherDao;

    @Before
    public void setUp() throws Exception {
        List<Book> bList = bookDao.getAllBooks();

        bList.stream()
                .forEach(book -> bookDao.deleteBook(book.getBook_id()));

        List<Author> aList = authorDao.getAllAuthors();

        aList.stream()
                .forEach(author -> authorDao.deleteAuthor(author.getAuthor_id()));

        List<Publisher> pList = publisherDao.getAllPublishers();

        pList.stream()
                .forEach(publisher -> publisherDao.deletePublisher(publisher.getPublisher_id()));
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void addGetDeleteBook() {

        Author author = new Author();
        author.setFirst_name("Robert");
        author.setLast_name("Kiyosaki");
        author.setStreet("123 Kiyosaki Drive");
        author.setCity("Rich");
        author.setState("TX");
        author.setPostal_code("77777");
        author.setPhone("123-456-7890");
        author.setEmail("robert@email.com");

        Publisher publisher = new Publisher();
        publisher.setName("Plata Publishing");
        publisher.setStreet("321 Plata Road");
        publisher.setCity("Publisher");
        publisher.setState("TX");
        publisher.setPostal_code("88888");
        publisher.setPhone("098-765-4321");
        publisher.setEmail("publisher@email.com");

        author = authorDao.addAuthor(author);
        publisher = publisherDao.addPublisher(publisher);

        Book book = new Book();
        book.setIsbn("12345123");
        book.setPublish_date(LocalDate.of(2020, 02, 03));
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("Rich Dad Poor Dad");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("10.99"));

        book = bookDao.addBook(book);

        Book book2 = bookDao.getBook(book.getBook_id());

        assertEquals(book, book2);

        bookDao.deleteBook(book.getBook_id());
    }

    @Test
    public void getAllBooks(){
        Author author = new Author();
        author.setFirst_name("Robert");
        author.setLast_name("Kiyosaki");
        author.setStreet("123 Kiyosaki Drive");
        author.setCity("Rich");
        author.setState("TX");
        author.setPostal_code("77777");
        author.setPhone("123-456-7890");
        author.setEmail("robert@email.com");

        Publisher publisher = new Publisher();
        publisher.setName("Plata Publishing");
        publisher.setStreet("321 Plata Road");
        publisher.setCity("Publisher");
        publisher.setState("TX");
        publisher.setPostal_code("88888");
        publisher.setPhone("098-765-4321");
        publisher.setEmail("publisher@email.com");

        author = authorDao.addAuthor(author);
        publisher = publisherDao.addPublisher(publisher);


        Book book = new Book();
        book.setIsbn("12345123");
        book.setPublish_date(LocalDate.of(2020, 02, 03));
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("Rich Dad Poor Dad");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("10.99"));

        book = bookDao.addBook(book);


        book = new Book();
        book.setIsbn("98765432");
        book.setPublish_date(LocalDate.of(2000, 01, 05));
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("CashFlow Quadrant");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("13.99"));

        book = bookDao.addBook(book);

        List<Book> bookList =bookDao.getAllBooks();

        assertEquals(bookList.size(),2);

    }

    @Test
    public void updateBook(){

        Author author = new Author();
        author.setFirst_name("Robert");
        author.setLast_name("Kiyosaki");
        author.setStreet("123 Kiyosaki Drive");
        author.setCity("Rich");
        author.setState("TX");
        author.setPostal_code("77777");
        author.setPhone("123-456-7890");
        author.setEmail("robert@email.com");

        Publisher publisher = new Publisher();
        publisher.setName("Plata Publishing");
        publisher.setStreet("321 Plata Road");
        publisher.setCity("Publisher");
        publisher.setState("TX");
        publisher.setPostal_code("88888");
        publisher.setPhone("098-765-4321");
        publisher.setEmail("publisher@email.com");

        author = authorDao.addAuthor(author);
        publisher = publisherDao.addPublisher(publisher);

        Book book = new Book();
        book.setIsbn("12345123");
        book.setPublish_date(LocalDate.of(2020, 02, 03));
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("Rich Dad Poor Dad");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("10.99"));

        book = bookDao.addBook(book);

        book.setIsbn("24686420");
        book.setTitle("Rich Dad Poor Dad UPDATED");
        book.setPrice(new BigDecimal("12.99"));
        book.setPublish_date(LocalDate.of(2021,01,01));

        bookDao.updateBook(book);

        Book book2 =bookDao.getBook(book.getBook_id());

        assertEquals(book2,book);

    }
    @Test
    public void getBookByAuthor(){
        Publisher publisher = new Publisher();
        publisher.setName("Plata Publishing");
        publisher.setStreet("321 Plata Road");
        publisher.setCity("Publisher");
        publisher.setState("TX");
        publisher.setPostal_code("88888");
        publisher.setPhone("098-765-4321");
        publisher.setEmail("publisher@email.com");

        publisher = publisherDao.addPublisher(publisher);

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

        Author author2 = new Author();
        author2.setFirst_name("Robert 2");
        author2.setLast_name("Kiyosaki 2");
        author2.setStreet("123 Kiyosaki Drive 2");
        author2.setCity("Rich 2");
        author2.setState("TX");
        author2.setPostal_code("77777");
        author2.setPhone("123-456-7890");
        author2.setEmail("robert2@email.com");

        author2 = authorDao.addAuthor(author2);

        Author author3 = new Author();
        author3.setFirst_name("Robert 3");
        author3.setLast_name("Kiyosaki 3");
        author3.setStreet("123 Kiyosaki Drive 3");
        author3.setCity("Rich 3");
        author3.setState("TX");
        author3.setPostal_code("77777");
        author3.setPhone("123-456-7890");
        author3.setEmail("robert3@email.com");

        author3 = authorDao.addAuthor(author3);

        Book book = new Book();
        book.setIsbn("12345123");
        book.setPublish_date(LocalDate.of(2020, 02, 03));
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("Rich Dad Poor Dad");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("10.99"));

        bookDao.addBook(book);

        book = new Book();
        book.setIsbn("12345123");
        book.setPublish_date(LocalDate.of(2020, 02, 03));
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("2Rich Dad 2Poor Dad");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("10.99"));

        bookDao.addBook(book);

        book = new Book();
        book.setIsbn("12345123");
        book.setPublish_date(LocalDate.of(2020, 02, 03));
        book.setAuthor_id(author2.getAuthor_id());
        book.setTitle("Rich Dad 3 Poor Dad 3");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("10.99"));

        bookDao.addBook(book);

        List<Book> bookList = bookDao.getBooksByAuthor(author.getAuthor_id());
        assertEquals(2,bookList.size());

        List<Book> bookList1 = bookDao.getBooksByAuthor(author2.getAuthor_id());
        assertEquals(1,bookList1.size());

        List<Book> bookList2 = bookDao.getBooksByAuthor(author3.getAuthor_id());
        assertEquals(0,bookList2.size());
    }
}