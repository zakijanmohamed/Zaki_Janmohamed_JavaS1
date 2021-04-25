package com.trilogyed.comment.controller;

import com.trilogyed.comment.dao.CommentDao;
import com.trilogyed.comment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RefreshScope
@RequestMapping("/comment")
public class CommentController {

    CommentDao dao;

    @Autowired
    public CommentController(CommentDao dao) {
        this.dao = dao;
    }

    //add
    @CachePut(key = ("#comment.getId()"))
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Comment addComment(@RequestBody @Valid Comment comment) {
        return dao.addComment(comment);
    }

    //getById
    @Cacheable
    @GetMapping("/{commentId}")
    @ResponseStatus(value = HttpStatus.OK)
    public Comment getComment(@PathVariable int commentId) {
        if (commentId < 1) {
            throw new IllegalArgumentException("Comment I.D. must be greater than 0.");
        }
        Comment returnVal = dao.getComment(commentId);
        if (returnVal == null) {
            throw new IllegalArgumentException("No comments with id " + commentId);
        }
        return returnVal;
    }

    //getByPostId
    @Cacheable
    @GetMapping("/post/{postId}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Comment> getByPostId(@PathVariable Integer postId){
        if (postId < 1) {
            throw new IllegalArgumentException("Post I.D. must be greater than 0.");
        }
        List<Comment> returnVal = dao.getCommentsByPostId(postId);
        if (returnVal == null) {
            throw new IllegalArgumentException("No posts with id " + postId);
        }
        return returnVal;

    }

    //getAll
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> getAllComments() {
        List<Comment> commentList = dao.getAllComments();
        return commentList;
    }

    //update
    @CacheEvict(key = ("#comment.getId()"))
    @PutMapping("/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateComment(@PathVariable("commentId") Integer commentId, @RequestBody @Valid Comment comment) {
        if (commentId != comment.getCommentId()) {
            throw new IllegalArgumentException("Comment I.D. must match I.D. in the Comment object.");
        }
        dao.updateComment(comment);
    }

    //delete
    @CacheEvict
    @DeleteMapping(value = "/{commentId}")
    public void deleteComment(@PathVariable Integer commentId) {
        dao.deleteComment(commentId);
    }
}
