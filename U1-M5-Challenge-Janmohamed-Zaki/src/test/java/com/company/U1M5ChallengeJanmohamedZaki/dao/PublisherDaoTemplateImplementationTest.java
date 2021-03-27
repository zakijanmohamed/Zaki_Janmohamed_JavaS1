package com.company.U1M5ChallengeJanmohamedZaki.dao;

import com.company.U1M5ChallengeJanmohamedZaki.model.Publisher;
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
public class PublisherDaoTemplateImplementationTest {

    @Autowired
    protected PublisherDao publisherDao;

    @Before
    public void setUp() throws Exception{
        List<Publisher> pList = publisherDao.getAllPublishers();

        pList.stream()
                .forEach(publisher -> publisherDao.deletePublisher(publisher.getPublisher_id()));
    }

    @After
    public void tearDown() throws Exception{
    }

    @Test
    public void addGetDeletePublisher(){

        Publisher publisher = new Publisher();
        publisher.setName("Plata Publishing");
        publisher.setStreet("321 Plata Road");
        publisher.setCity("Publisher");
        publisher.setState("TX");
        publisher.setPostal_code("88888");
        publisher.setPhone("098-765-4321");
        publisher.setEmail("publisher@email.com");

        Publisher publisher2 = publisherDao.addPublisher(publisher);

        publisher = publisherDao.getPublisher(publisher.getPublisher_id());

        assertEquals(publisher,publisher2);

        publisherDao.deletePublisher(publisher.getPublisher_id());

    }

    @Test
    public void getAllPublishers(){

        Publisher publisher = new Publisher();
        publisher.setName("Plata Publishing");
        publisher.setStreet("321 Plata Road");
        publisher.setCity("Publisher");
        publisher.setState("TX");
        publisher.setPostal_code("88888");
        publisher.setPhone("098-765-4321");
        publisher.setEmail("publisher@email.com");

        publisher = publisherDao.addPublisher(publisher);

        publisher = new Publisher();
        publisher.setName("Plata Publishing 1");
        publisher.setStreet("321 Plata Road");
        publisher.setCity("Publisher");
        publisher.setState("TX");
        publisher.setPostal_code("88888");
        publisher.setPhone("098-765-4321");
        publisher.setEmail("publisher@email.com");

        publisher = publisherDao.addPublisher(publisher);

        publisher = new Publisher();
        publisher.setName("Plata Publishing 2");
        publisher.setStreet("321 Plata Road");
        publisher.setCity("Publisher");
        publisher.setState("TX");
        publisher.setPostal_code("88888");
        publisher.setPhone("098-765-4321");
        publisher.setEmail("publisher@email.com");

        publisher = publisherDao.addPublisher(publisher);

        List<Publisher> publisherList = publisherDao.getAllPublishers();

        assertEquals(publisherList.size(), 3);

    }

    @Test
    public void updatePublisher(){

        Publisher publisher = new Publisher();
        publisher.setName("Plata Publishing");
        publisher.setStreet("321 Plata Road");
        publisher.setCity("Publisher");
        publisher.setState("TX");
        publisher.setPostal_code("88888");
        publisher.setPhone("098-765-4321");
        publisher.setEmail("publisher@email.com");

        publisher = publisherDao.addPublisher(publisher);

        publisher.setStreet("321 We've Moved Roads");
        publisher.setCity("Publishing");
        publisher.setState("NY");
        publisher.setPostal_code("12345");

        publisherDao.updatePublisher(publisher);

        Publisher publisher2 = publisherDao.getPublisher(publisher.getPublisher_id());

        assertEquals(publisher2,publisher);
        
    }

}