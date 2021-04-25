package com.trilogyed.stwitter.feign;

import com.trilogyed.stwitter.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient (name = "comment-service")
public interface CommentClient {

    @GetMapping("/comment/{commentId}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Comment> getComment(@PathVariable int commentId);

    @PostMapping("/comment")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Comment addComment(@RequestBody  Comment comment);

    @GetMapping("comment/post/{postId}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Comment> getByPostId(@PathVariable Integer postId);
}
