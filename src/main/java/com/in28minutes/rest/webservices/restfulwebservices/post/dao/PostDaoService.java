package com.in28minutes.rest.webservices.restfulwebservices.post.dao;

import com.in28minutes.rest.webservices.restfulwebservices.post.entity.Post;
import com.in28minutes.rest.webservices.restfulwebservices.post.exception.PostNotFoundException;
import javafx.geometry.Pos;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class PostDaoService {

    static List<Post> posts = new ArrayList<Post>();
    static int count = 6;

    static{
        posts.add(new Post(1, new Date(), "Winter is Coming!!", 4));
        posts.add(new Post(2, new Date(), "What a beautiful day!", 1));
        posts.add(new Post(3, new Date(), "Did anyone see the game?", 2));
        posts.add(new Post(4, new Date(), "Vote this november!", 3));
        posts.add(new Post(5, new Date(), "It is pre-season time already!", 4));
        posts.add(new Post(6, new Date(), "Working on my next baking project", 5));
    }

    // get all posts
    public List<Post> retrieveAllPosts(){
        return posts;
    }

    // get single post
    public Post retrievePostByPostId(int postId){
        for(Post post: posts){
            if(post.getPostId() == postId){
                return post;
            }
        }
        throw new PostNotFoundException(String.format("[postId:%d] does not exist",postId));
    }

    // get posts by single user
    public List<Post> retrievePostsByUserId(int userId){
        List<Post> userPosts =  new ArrayList();
        for(Post post: posts){
            if(post.getUserId() == userId){
                userPosts.add(post);
            }
        }
        if(userPosts.size()<=0){
            throw new PostNotFoundException(String.format("Could not find posts for [userId:%s]", userId));
        }
        return userPosts;
    }

    // save post
    public Post save(Post post){
        System.out.println("!!! ALERT - > " + post.getPostId() + " post size - > " + posts.size());
//        if(post.getPostId()<=0){
            post.setPostId(posts.size()+1);
//        }
        posts.add(post);
        return post;
    }

    // delete post
    public String deletePostById(int postId){
        Iterator i = posts.iterator();
        boolean deletedPost = false;
        while(i.hasNext()){
            Post toDelete = (Post) i.next();
            if(toDelete.getPostId() == postId){
                i.remove();
                deletedPost = !deletedPost;
            }
        }
        if(!deletedPost) throw new PostNotFoundException(String.format("Post with [postId: %d] not found", postId));
        return "Successfully Deleted post";
    }
}
