package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CommentDaoJdbcImplementationTest {

    @Autowired
    CommentDao commentDao;

    private Comment comment;

    @Before
    public void setUp() throws Exception {

        clearDatabase();
        setUpTestObjects();
    }

    public void clearDatabase(){
        List<Comment>commentList = commentDao.getAllComments();
        for (Comment comment : commentList){
            commentDao.deleteComment(comment.getCommentId());
        }
    }

    public void setUpTestObjects(){
        comment = new Comment();
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2021,05,15));
        comment.setCommenterName("John Bob");
        comment.setComment("This is the comment.");
    }


    @Test
    public void addGetDeleteComment() {

        comment = commentDao.addComment(comment);

        Comment comment1 = commentDao.getComment(comment.getCommentId());
        assertEquals(comment1,comment);

        commentDao.deleteComment(comment.getCommentId());
    }

    @Test
    public void getAllComments() {

        comment = commentDao.addComment(comment);

        comment = new Comment();
        comment.setPostId(2);
        comment.setCreateDate(LocalDate.of(2021,04,19));
        comment.setCommenterName("John Smith");
        comment.setComment("This is the other comment.");
        commentDao.addComment(comment);

        List<Comment>commentList = commentDao.getAllComments();
        assertEquals(2,commentList.size());
    }

    @Test
    public void getCommentByPostId(){
        comment = commentDao.addComment(comment);

        comment = new Comment();
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2021,04,19));
        comment.setCommenterName("John Smith");
        comment.setComment("This is the other comment.");
        commentDao.addComment(comment);

        List<Comment>commentList = commentDao.getCommentsByPostId(1);
        assertEquals(2,commentList.size());
    }

    @Test
    public void updateComment() {

        comment = commentDao.addComment(comment);

        comment.setCommenterName("John Smith");
        comment.setComment("This is the other comment.");
        commentDao.updateComment(comment);

        Comment comment1 =commentDao.getComment(comment.getCommentId());
        assertEquals(comment1,comment);
    }


}