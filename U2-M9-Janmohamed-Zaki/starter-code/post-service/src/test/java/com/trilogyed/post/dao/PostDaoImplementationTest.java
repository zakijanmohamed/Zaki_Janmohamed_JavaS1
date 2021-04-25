package com.trilogyed.post.dao;

import com.trilogyed.post.model.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PostDaoImplementationTest {

    @Autowired
    PostDao postDao;

    private Post post;

    @Before
    public void setUp() throws Exception{

        clearDatabase();
        setUpTestObjects();
    }

    public void clearDatabase() {
        List<Post> postList = postDao.getAllPosts();
        for (Post post : postList) {
            postDao.deletePost(post.getPostId());
        }
    }

    public void setUpTestObjects(){
        post = new Post();
        post.setPostDate(LocalDate.of(2021,05,19));
        post.setPosterName("Bob Smith");
        post.setPost("this is a post.");
    }

    @Test
    public void addGetDeletePost(){

        post = postDao.addPost(post);

        Post post1 = postDao.getPost(post.getPostId());
        assertEquals(post1,post);

        postDao.deletePost(post.getPostId());
    }

    @Test
    public void getAllPosts(){

        post = postDao.addPost(post);

        post = new Post();
        post.setPostDate(LocalDate.of(2021,05,19));
        post.setPosterName("Tom Smith");
        post.setPost("this is another post.");
        postDao.addPost(post);

        List<Post>postList = postDao.getAllPosts();
        assertEquals(2,postList.size());
    }

    @Test
    public void updatePost(){

        post = postDao.addPost(post);
        post.setPosterName("Tom Smith");
        post.setPost("this is another post.");
        postDao.updatePost(post);

        Post post1 =postDao.getPost(post.getPostId());
        assertEquals(post1,post);
    }

    @Test
    public void getPostByPoster(){

        post = postDao.addPost(post);

        post = new Post();
        post.setPostDate(LocalDate.of(2021,05,19));
        post.setPosterName("Tom Smith");
        post.setPost("this is another post.");
        postDao.addPost(post);

        List<Post>postList = postDao.getPostByPoster("Tom Smith");
        assertEquals(1,postList.size());

        postList = postDao.getPostByPoster("Bob Smith");
        assertEquals(1,postList.size());
    }
}
