package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.CommentAction;
import com.trilogyed.stwitter.feign.CommentClient;
import com.trilogyed.stwitter.feign.PostClient;
import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.viewmodel.PostViewModel;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceLayer {

    public static final String EXCHANGE = "queue-post-comment-exchange";
    public static final String ROUTING_KEY_PREFIX = "comment.create.";
    public static final String ROUTING_KEY_ADD = ROUTING_KEY_PREFIX + "add";
    public static final String ROUTING_KEY_DELETE = ROUTING_KEY_PREFIX + "delete";


    @Autowired
    public CommentClient commentClient;
    @Autowired
    public PostClient postClient;
    @Autowired
    public RabbitTemplate rabbitTemplate;

    @Autowired
    public ServiceLayer(CommentClient commentClient, PostClient postClient, RabbitTemplate rabbitTemplate) {
        this.commentClient = commentClient;
        this.postClient = postClient;
        this.rabbitTemplate = rabbitTemplate;
    }

    private void addComment(List<Comment> comments, final int postId){
        comments.stream().forEach(
                comment -> {
                    comment.setPostId(postId);
                    CommentAction commentAction = new CommentAction();
                    commentAction.setAction("ADD");
                    commentAction.setComment(comment);
                    System.out.println("Sending message...");
                    rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY_ADD, commentAction);
                    System.out.println("Message Sent");
                }
        );
    }

    public Post createPost(PostViewModel postViewModel){
        Post post = new Post();
        post.setPostDate(postViewModel.getPostDate());
        post.setPosterName(postViewModel.getPosterName());
        post.setPost(postViewModel.getPost());

        addComment(postViewModel.getCommentList(),post.getPostId());

        return post;
    }

    public PostViewModel getPost(int id){
        Post post = postClient.getPost(id);
        return buildPVM(post);
    }

    public List<PostViewModel> getAllPosts(){
        List<Post> posts = postClient.getAllPosts();
        List<PostViewModel> returnVal = new ArrayList<>();
        for (Post post : posts){
            returnVal.add(buildPVM(post));
        }
        return returnVal;
    }

    public List<PostViewModel> getPostByPoster(String posterName){
        List<Post> posts = postClient.getPostByPoster(posterName);
        List<PostViewModel> returnVal = new ArrayList<>();
        for (Post post : posts){
            returnVal.add(buildPVM(post));
        }
        return returnVal;
    }


    private PostViewModel buildPVM(Post post){
        PostViewModel returnVal = new PostViewModel();
        returnVal.setPostId(post.getPostId());
        returnVal.setPostDate(post.getPostDate());
        returnVal.setPosterName(post.getPosterName());
        returnVal.setPost(post.getPost());
        returnVal.setCommentList(commentClient.getByPostId(post.getPostId()));

        return returnVal;
    }

}
