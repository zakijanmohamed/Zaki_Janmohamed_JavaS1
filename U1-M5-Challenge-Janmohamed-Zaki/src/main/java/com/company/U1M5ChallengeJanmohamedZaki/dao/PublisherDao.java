package com.company.U1M5ChallengeJanmohamedZaki.dao;

import com.company.U1M5ChallengeJanmohamedZaki.model.Publisher;

import java.util.List;

public interface PublisherDao {

        Publisher addPublisher(Publisher publisher); //create
        Publisher getPublisher(int Publisher_id); //read
        List<Publisher> getAllPublishers();    //read all
        void updatePublisher (Publisher publisher); //update
        void deletePublisher (int Publisher_id); //delete
}
