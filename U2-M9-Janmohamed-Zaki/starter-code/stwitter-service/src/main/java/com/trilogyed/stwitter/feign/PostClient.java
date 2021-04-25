package com.trilogyed.stwitter.feign;

import com.trilogyed.stwitter.model.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@FeignClient(name = "post-service")
public interface PostClient {

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public Post getPost(@PathVariable Integer id);

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public Post addPost(@RequestBody @Valid Post post);

    @RequestMapping(value = "posts/user/{poster_name}", method = RequestMethod.GET)
    public List<Post> getPostByPoster(@PathVariable String posterName);

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public List<Post> getAllPosts();

}
