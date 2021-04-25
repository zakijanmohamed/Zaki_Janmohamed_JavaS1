package com.trilogyed.stwitter.controller;

import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.service.ServiceLayer;
import com.trilogyed.stwitter.viewmodel.PostViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
@RequestMapping("/stwitter")
public class StwitterController {

    @Autowired
    private ServiceLayer serviceLayer;


    //create
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Post createPost(@RequestBody @Valid PostViewModel postViewModel) {
        return serviceLayer.createPost(postViewModel);
    }

    //getById
    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public PostViewModel getPost(@PathVariable int id) {
        return serviceLayer.getPost(id);

    }

    //getAll
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PostViewModel> getAllPosts() {
        return serviceLayer.getAllPosts();
    }

    //getByPoster
    @GetMapping("/user/{posterName}")
    @ResponseStatus(value = HttpStatus.OK)
    public PostViewModel getPostByPoster(@PathVariable String posterName) {
        return (PostViewModel) serviceLayer.getPostByPoster(posterName);

    }

}
