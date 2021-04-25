package com.stwitter.queconsumer;

import com.stwitter.queconsumer.feign.CommentClient;
import com.stwitter.queconsumer.model.Comment;
import com.stwitter.queconsumer.model.CommentAction;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    @Autowired
    CommentClient commentClient;

    @RabbitListener(queues = QueConsumerApplication.QUEUE_NAME)
    public void createComment(CommentAction commentAction) {
        System.out.println("Received a comment " + commentAction);
        commentClient.addComment(commentAction.getComment());
    }
}
