package com.in28minutes.rest.webservices.restfulwebservices.post.controller;

import com.in28minutes.rest.webservices.restfulwebservices.post.dao.PostDaoService;
import com.in28minutes.rest.webservices.restfulwebservices.post.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostDaoService postDaoService;

    // get all posts
    @GetMapping("/posts")
    public List<Post> retrieveAll(){
        return postDaoService.retrieveAllPosts();
    }

    // get single post
    @GetMapping(path= "/posts/{postId}")
    public Post retrieveSinglePost(@PathVariable int postId){
        return postDaoService.retrievePostByPostId(postId);
    }

    // get all posts by user
    @GetMapping(path="/posts/user/{userId}")
    public List<Post> retrievePostsByUserId(@PathVariable int userId){
        return postDaoService.retrievePostsByUserId(userId);
    }

    // save post
    @PostMapping("/posts")
    public Post createPost(@RequestBody Post post){
       return postDaoService.save(post);
    }

    // update post
    @PutMapping(path="/posts/{postId}")
    public Post updatePost(@RequestBody Post post){
        return postDaoService.save(post);
    }

    // delete post
    @DeleteMapping(path="/posts/{postId}")
    public String deletePost(@PathVariable int postId){
        return postDaoService.deletePostById(postId);
    }

}
