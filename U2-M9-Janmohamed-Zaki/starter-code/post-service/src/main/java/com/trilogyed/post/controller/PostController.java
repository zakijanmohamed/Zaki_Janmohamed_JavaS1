package com.trilogyed.post.controller;

import com.trilogyed.post.dao.PostDao;
import com.trilogyed.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
@RequestMapping("/posts")
public class PostController {

    PostDao dao;

    @Autowired
    public PostController(PostDao dao) {
        this.dao = dao;
    }

    //add
    @CachePut(key = ("#post.getId()"))
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Post createPost(@RequestBody @Valid Post post) {
        return dao.addPost(post);
    }

    //getById
    @Cacheable
    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Post getPost(@PathVariable int id) {
        if (id < 1) {
            throw new IllegalArgumentException("Post I.D. must be greater than 0.");
        }
        Post returnVal = dao.getPost(id);
        if (returnVal == null) {
            throw new IllegalArgumentException("No Post with id " + id);
        }
        return returnVal;
    }

    //getAll
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Post> getAllPosts() {
        List<Post> postList = dao.getAllPosts();
        return postList;
    }

    //getByPoster
    @GetMapping(value = "/user/{posterName}")
    @ResponseStatus(HttpStatus.OK)
    public List<Post> getAllPostsByPoster(@PathVariable String posterName) {
        List<Post> postList = dao.getPostByPoster(posterName);
        return postList;
    }

    //update
    @CacheEvict(key = ("#post.getId()"))
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePost(@PathVariable("id") Integer id, @RequestBody @Valid Post post) {
        if (id != post.getPostId()) {
            throw new IllegalArgumentException("Post I.D. must match I.D. in the Post object.");
        }
        dao.updatePost(post);
    }

    //delete
    @CacheEvict
    @DeleteMapping(value = "/{id}")
    public void deletePost(@PathVariable Integer id) {
        dao.deletePost(id);

    }
}
