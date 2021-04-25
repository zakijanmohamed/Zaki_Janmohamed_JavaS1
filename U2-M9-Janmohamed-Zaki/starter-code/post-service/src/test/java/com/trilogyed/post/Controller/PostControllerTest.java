package com.trilogyed.post.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.post.controller.PostController;
import com.trilogyed.post.dao.PostDao;
import com.trilogyed.post.model.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PostController.class)
@ImportAutoConfiguration(RefreshAutoConfiguration.class)
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PostDao repo;

    private ObjectMapper mapper = new ObjectMapper();

    @Test//add
    public void shouldCreateNewPost() throws Exception {

        Post inputPost = new Post();
        inputPost.setPostDate(LocalDate.of(2021, 05, 19));
        inputPost.setPosterName("Tom Smith");
        inputPost.setPost("this is a post.");

        String inputJson = mapper.writeValueAsString(inputPost);

        Post outputPost = new Post();
        outputPost.setPostId(2);
        outputPost.setPostDate(LocalDate.of(2021, 05, 19));
        outputPost.setPosterName("Tom Smith");
        outputPost.setPost("this is a post.");

        doReturn(outputPost).when(repo).addPost(inputPost);
        String outputJson = mapper.writeValueAsString(outputPost);

        this.mockMvc.perform(post("/posts")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test//getById
    public void shouldGetPost() throws Exception {
        Post post = new Post();
        post.setPostDate(LocalDate.of(2021, 05, 19));
        post.setPosterName("Tom Smith");
        post.setPost("this is a post.");
        post.setPostId(2);


        String outputJson = mapper.writeValueAsString(post);

        doReturn(post).when(repo).getPost(2);

        this.mockMvc.perform(get("/posts/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test//getAll
    public void shouldGetAllPosts() throws Exception {
        Post post = new Post();
        post.setPostDate(LocalDate.of(2021, 05, 19));
        post.setPosterName("Tom Smith");
        post.setPost("this is a post.");
        post.setPostId(2);

        Post post2 = new Post();
        post2.setPostDate(LocalDate.of(2021, 05, 19));
        post2.setPosterName("Bob Smith");
        post2.setPost("this is another post.");
        post2.setPostId(3);

        List<Post> postList = new ArrayList<>();
        postList.add(post);
        postList.add(post2);

        when(repo.getAllPosts()).thenReturn(postList);

        List<Post> postChecker = new ArrayList<>();
        postChecker.addAll(postList);

        String outputJson = mapper.writeValueAsString(postList);

        this.mockMvc.perform(get("/posts"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test//getByPoster
    public void shouldGetPostByPoster() throws Exception{

        Post post = new Post();
        post.setPostDate(LocalDate.of(2021, 05, 19));
        post.setPosterName("Bob Smith");
        post.setPost("this is a post.");
        post.setPostId(2);

        Post post2 = new Post();
        post2.setPostDate(LocalDate.of(2021, 05, 19));
        post2.setPosterName("Bob Smith");
        post2.setPost("this is another post.");
        post2.setPostId(3);

        List<Post> postList = new ArrayList<>();
        postList.add(post);
        postList.add(post2);

        when(repo.getPostByPoster("Bob")).thenReturn(postList);

        List<Post> postChecker = new ArrayList<>();
        postChecker.addAll(postList);

        String outputJson = mapper.writeValueAsString(postList);

        this.mockMvc.perform(get("/posts/user/Bob" ))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));


    }

    @Test//update
    public void shouldUpdatePost()throws Exception{

        Post post = new Post();
        post.setPostDate(LocalDate.of(2021, 05, 19));
        post.setPosterName("Tom Smith");
        post.setPost("this is a post.");
        post.setPostId(2);

        String inputJson = mapper.writeValueAsString(post);


        this.mockMvc.perform(put("/posts/" + post.getPostId())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isNoContent());
    }

    @Test//delete
    public void shouldDeletePost() throws Exception{

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/posts/2"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(""));
    }
}
