package com.trilogyed.comment.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.comment.controller.CommentController;
import com.trilogyed.comment.dao.CommentDao;
import com.trilogyed.comment.model.Comment;
import org.junit.Before;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CommentController.class)
@ImportAutoConfiguration(RefreshAutoConfiguration.class)
public class CommentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CommentDao repo;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp(){
    }

    @Test//add
    public void shouldCreateNewComment() throws Exception{

        Comment inputComment = new Comment();
        inputComment.setPostId(1);
        inputComment.setCreateDate(LocalDate.of(2021,5,15));
        inputComment.setCommenterName("John Bob");
        inputComment.setComment("This is the comment.");


        String inputJson = mapper.writeValueAsString(inputComment);

        Comment outputComment = new Comment();
        outputComment.setPostId(1);
        outputComment.setCreateDate(LocalDate.of(2021,5,15));
        outputComment.setCommenterName("John Bob");
        outputComment.setComment("This is the comment.");
        outputComment.setCommentId(2);

        doReturn(outputComment).when(repo).addComment(inputComment);

        String outputJson = mapper.writeValueAsString(outputComment);

        this.mockMvc.perform(post("/comment")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test//getById
    public void shouldGetComment() throws Exception{
        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2021,05,15));
        comment.setCommenterName("John Bob");
        comment.setComment("This is the comment.");
        comment.setCommentId(2);



        String outputJson = mapper.writeValueAsString(comment);

        doReturn(comment).when(repo).getComment(2);

        this.mockMvc.perform(get("/comment/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test//getAll
    public void shouldGetAllComments() throws Exception{

        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2021,05,15));
        comment.setCommenterName("John Bob");
        comment.setComment("This is the comment.");
        comment.setCommentId(2);

        Comment comment2 = new Comment();
        comment2.setPostId(2);
        comment2.setCreateDate(LocalDate.of(2021,05,15));
        comment2.setCommenterName("Bob Bob");
        comment2.setComment("This is the other comment.");
        comment2.setCommentId(3);

        List<Comment>commentList = new ArrayList<>();
        commentList.add(comment);
        commentList.add(comment2);

        when(repo.getAllComments()).thenReturn(commentList);

        List<Comment>commentChecker = new ArrayList<>();
        commentChecker.addAll(commentList);

        String outputJson = mapper.writeValueAsString(commentChecker);

        this.mockMvc.perform(get("/comment"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));

    }

    @Test//update
    public void shouldUpdateComment()throws Exception{
        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2021,05,15));
        comment.setCommenterName("John Bob");
        comment.setComment("This is the comment.");
        comment.setCommentId(2);

        String inputJson = mapper.writeValueAsString(comment);


        this.mockMvc.perform(put("/comment/" + comment.getCommentId())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isNoContent());

    }

    @Test//delete
    public void shouldDeleteComment() throws Exception{

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/comment/2"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test//getCommentById
    public void shouldGetCommentByPostId() throws Exception{


        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2021,05,15));
        comment.setCommenterName("John Bob");
        comment.setComment("This is the comment.");
        comment.setCommentId(2);

        Comment comment2 = new Comment();
        comment2.setPostId(1);
        comment2.setCreateDate(LocalDate.of(2021,05,15));
        comment2.setCommenterName("Bob Bob");
        comment2.setComment("This is the other comment.");
        comment2.setCommentId(3);

        List<Comment>commentList = new ArrayList<>();
        commentList.add(comment);
        commentList.add(comment2);

        when(repo.getCommentsByPostId(1)).thenReturn(commentList);

        List<Comment>commentChecker = new ArrayList<>();
        commentChecker.addAll(commentList);

        String outputJson = mapper.writeValueAsString(commentChecker);

        this.mockMvc.perform(get("/comment/post/1" ))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));

    }
}
