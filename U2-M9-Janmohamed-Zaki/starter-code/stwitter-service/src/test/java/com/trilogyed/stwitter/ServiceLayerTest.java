package com.trilogyed.stwitter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.stwitter.controller.StwitterController;
import com.trilogyed.stwitter.feign.CommentClient;
import com.trilogyed.stwitter.feign.PostClient;
import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.service.ServiceLayer;
import com.trilogyed.stwitter.viewmodel.PostViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StwitterController.class)
@ImportAutoConfiguration(RefreshAutoConfiguration.class)
public class ServiceLayerTest {

    private CommentClient commentClient;
    private PostClient postClient;
    private RabbitTemplate rabbitTemplate;
    private ServiceLayer service;

    private static final int POST_ID_FOR_TEST = 7;

    @Before
    public void setUp() throws Exception{
        commentClientMock();
        rabbitTemplateMock();
        service = new ServiceLayer(commentClient,postClient,rabbitTemplate);
    }


    @Test
    public void createPost() throws Exception {
        PostViewModel input = new PostViewModel();
        input.setPostDate(LocalDate.of(2021,07,07));
        input.setPosterName("jack johnson");
        input.setPost("this is a post");

        Comment comment1 = new Comment();
        comment1.setComment("this is a comment");
        Comment comment2 = new Comment();
        comment2.setComment("this is another comment");
        List<Comment>comments = Arrays.asList(comment1,comment2);
        input.setCommentList(comments);

        Post whatIExpect = new Post();
        whatIExpect.setPostId(POST_ID_FOR_TEST);
        whatIExpect.setPostDate(LocalDate.of(2021,07,07));
        whatIExpect.setPosterName("jack johnson");
        whatIExpect.setPost("this is a post");

        Post whatIGot = service.createPost(input);

        assertEquals(whatIExpect,whatIGot);
    }


    @Test
    public void getPost() {

        PostViewModel whatIExpect = new PostViewModel();
        whatIExpect.setPostId(POST_ID_FOR_TEST);
        whatIExpect.setPostDate(LocalDate.of(2021,07,07));
        whatIExpect.setPosterName("jack johnson");
        whatIExpect.setPost("this is a post");

        Comment comment1 = new Comment();
        comment1.setCommentId(3);
        comment1.setPostId(POST_ID_FOR_TEST);
        comment1.setCreateDate(LocalDate.of(2021,05,12));
        comment1.setCommenterName("Smith Bob");
        comment1.setComment("this is a comment");

        Comment comment2 = new Comment();
        comment2.setCommentId(4);
        comment2.setPostId(POST_ID_FOR_TEST);
        comment2.setCreateDate(LocalDate.of(2021,07,12));
        comment2.setCommenterName("Smith Bob");
        comment2.setComment("this is another comment");

        whatIExpect.setCommentList(Arrays.asList(comment1,comment2));

        PostViewModel whatIGot = service.getPost(POST_ID_FOR_TEST);

        assertEquals(whatIExpect,whatIGot);


    }


    @Test
    public void getAllPosts() {
        PostViewModel whatIExpect = new PostViewModel();
        whatIExpect.setPostId(POST_ID_FOR_TEST);
        whatIExpect.setPostDate(LocalDate.of(2021,07,07));
        whatIExpect.setPosterName("jack johnson");
        whatIExpect.setPost("this is a post");

        Comment comment1 = new Comment();
        comment1.setCommentId(3);
        comment1.setPostId(POST_ID_FOR_TEST);
        comment1.setCreateDate(LocalDate.of(2021,05,12));
        comment1.setCommenterName("Smith Bob");
        comment1.setComment("this is a comment");

        Comment comment2 = new Comment();
        comment2.setCommentId(4);
        comment2.setPostId(POST_ID_FOR_TEST);
        comment2.setCreateDate(LocalDate.of(2021,07,12));
        comment2.setCommenterName("Smith Bob");
        comment2.setComment("this is another comment");

        whatIExpect.setCommentList(Arrays.asList(comment1,comment2));

        List<PostViewModel> whatIGot = service.getAllPosts();

        assertEquals(whatIExpect,whatIGot);
    }

    @Test
    public void getPostByPoster(){
        PostViewModel whatIExpect = new PostViewModel();
        whatIExpect.setPostId(POST_ID_FOR_TEST);
        whatIExpect.setPostDate(LocalDate.of(2021,07,07));
        whatIExpect.setPosterName("jack johnson");
        whatIExpect.setPost("this is a post");

        PostViewModel whatIExpect1 = new PostViewModel();
        whatIExpect1.setPostId(8);
        whatIExpect1.setPostDate(LocalDate.of(2021,07,07));
        whatIExpect1.setPosterName("jack johnson");
        whatIExpect1.setPost("this is a post");

        Comment comment1 = new Comment();
        comment1.setCommentId(3);
        comment1.setPostId(POST_ID_FOR_TEST);
        comment1.setCreateDate(LocalDate.of(2021,05,12));
        comment1.setCommenterName("Smith Bob");
        comment1.setComment("this is a comment");

        Comment comment2 = new Comment();
        comment2.setCommentId(4);
        comment2.setPostId(POST_ID_FOR_TEST);
        comment2.setCreateDate(LocalDate.of(2021,07,12));
        comment2.setCommenterName("Smith Bob");
        comment2.setComment("this is another comment");

        Comment comment3 = new Comment();
        comment3.setCommentId(3);
        comment3.setPostId(8);
        comment3.setCreateDate(LocalDate.of(2021,05,12));
        comment3.setCommenterName("Smith Bob");
        comment3.setComment("this is a comment");

        Comment comment4 = new Comment();
        comment4.setCommentId(4);
        comment4.setPostId(8);
        comment4.setCreateDate(LocalDate.of(2021,07,12));
        comment4.setCommenterName("Smith Bob");
        comment4.setComment("this is another comment");

        whatIExpect.setCommentList(Arrays.asList(comment1,comment2));
        whatIExpect1.setCommentList(Arrays.asList(comment3,comment4));

        List<PostViewModel> whatIGot = service.getPostByPoster("jack johnson");

        assertEquals(whatIExpect,whatIGot);


    }


    private void rabbitTemplateMock(){
        rabbitTemplate = mock(RabbitTemplate.class);
    }

    private void commentClientMock(){
        commentClient = mock(CommentClient.class);
        Comment comment1 = new Comment();
        comment1.setCommentId(3);
        comment1.setPostId(POST_ID_FOR_TEST);
        comment1.setCreateDate(LocalDate.of(2021,05,12));
        comment1.setCommenterName("Smith Bob");
        comment1.setComment("this is a comment");

        Comment comment2 = new Comment();
        comment2.setCommentId(4);
        comment2.setPostId(POST_ID_FOR_TEST);
        comment2.setCreateDate(LocalDate.of(2021,07,12));
        comment2.setCommenterName("Smith Bob");
        comment2.setComment("this is another comment");

        List<Comment> comments = Arrays.asList(comment1,comment2);
        doReturn(comments).when(commentClient).getByPostId(7);

    }
}