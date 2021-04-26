package com.trilogyed.stwitter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.stwitter.controller.StwitterController;
import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.service.ServiceLayer;
import com.trilogyed.stwitter.viewmodel.PostViewModel;
import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javafx.beans.binding.Bindings.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StwitterController.class)
public class StwitterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceLayer serviceLayer;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldCreatePost() throws Exception {
        Comment comment1 = new Comment();
        comment1.setComment("this is a comment");
        Comment comment2 = new Comment();
        comment2.setComment("this is another comment");
        List<Comment> comments = new ArrayList<>();
        comments.add(comment1);
        comments.add(comment2);

        PostViewModel input = new PostViewModel();
        input.setPostDate(LocalDate.of(2021, 5, 07));
        input.setPosterName("bob smith");
        input.setPost("this is a post");
        input.setCommentList(comments);

        String inputJson = mapper.writeValueAsString(input);

        PostViewModel outputPvm = new PostViewModel();
        outputPvm.setPostDate(LocalDate.of(2021, 5, 8));
        outputPvm.setPosterName("smith bob");
        outputPvm.setPost("this is another post");
        outputPvm.setPostId(2);
        outputPvm.setCommentList(comments);

        String outputJson = mapper.writeValueAsString(outputPvm);

        when(serviceLayer.createPost(serviceLayer.createPost(input))).thenReturn(outputPvm);


        mockMvc.perform(
                post("/stwitter")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldGetPvmBy() throws Exception {
        Comment comment1 = new Comment();
        comment1.setComment("this is a comment");
        Comment comment2 = new Comment();
        comment2.setComment("this is another comment");
        List<Comment> comments = new ArrayList<>();
        comments.add(comment1);
        comments.add(comment2);

        PostViewModel outputPvm = new PostViewModel();
        outputPvm.setPostDate(LocalDate.of(2021, 5, 21));
        outputPvm.setPosterName("john jacob");
        outputPvm.setPost("jacobs wrote this comment");
        outputPvm.setPostId(2);
        outputPvm.setCommentList(comments);

        String outputJson = mapper.writeValueAsString(outputPvm);

        when(serviceLayer.getPost(2)).thenReturn(outputPvm);

        mockMvc.perform(get("/sTwitter/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));

    }

    @Test
    public void shoulGetAllPvmPosts() throws Exception {

        Comment comment1 = new Comment();
        comment1.setComment("this is a comment");
        Comment comment2 = new Comment();
        comment2.setComment("this is another comment");
        List<Comment> comments = new ArrayList<>();
        comments.add(comment1);
        comments.add(comment2);

        PostViewModel outputPvm = new PostViewModel();
        outputPvm.setPostDate(LocalDate.of(2021, 4, 21));
        outputPvm.setPosterName("john jacob");
        outputPvm.setPost("jacobs wrote this comment");
        outputPvm.setPostId(2);
        outputPvm.setCommentList(comments);

        List<PostViewModel> expectedList = new ArrayList<>();

        expectedList.add(outputPvm);

        when(serviceLayer.getAllPosts()).thenReturn(expectedList);
        List<PostViewModel> pvmListChecker = new ArrayList<>();
        pvmListChecker.addAll(expectedList);

        String outputJson = mapper.writeValueAsString(pvmListChecker);

        mockMvc.perform(get("/stwitter/"))
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));

    }

    @Test
    public void shouldGetPostByPoster() throws Exception {

        Comment comment1 = new Comment();
        comment1.setComment("this is a comment");
        Comment comment2 = new Comment();
        comment2.setComment("this is another comment");
        List<Comment> comments = new ArrayList<>();
        comments.add(comment1);
        comments.add(comment2);

        PostViewModel outputPvm = new PostViewModel();
        outputPvm.setPostDate(LocalDate.of(2021, 4, 21));
        outputPvm.setPosterName("john jacob");
        outputPvm.setPost("jacobs wrote this comment");
        outputPvm.setPostId(2);
        outputPvm.setCommentList(comments);

        List<PostViewModel> expectedPvmList = new ArrayList<>();

        expectedPvmList.add(outputPvm);

        when(serviceLayer.getPostByPoster("john jacob")).thenReturn(expectedPvmList);
        List<PostViewModel> pvmListChecker = new ArrayList<>();
        pvmListChecker.addAll(expectedPvmList);

        String outputJson = mapper.writeValueAsString(pvmListChecker);


        mockMvc.perform(get("/stwitter/user/johnjacob"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }
}