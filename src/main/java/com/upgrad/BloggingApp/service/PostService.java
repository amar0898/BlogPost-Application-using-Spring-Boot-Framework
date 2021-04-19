package com.upgrad.BloggingApp.service;

import com.upgrad.BloggingApp.model.Post;
import com.upgrad.BloggingApp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.Metamodel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class PostService {

    @Autowired
   private PostRepository postRepository;

    public List<Post> getAllPosts(Integer userId) {

    return postRepository.getAllPosts(userId);
    }

    public void createPost(Post newPost) {
        postRepository.createPost(newPost);

    }

    public Post getPost(Integer postId) {
        return postRepository.getPost(postId);
    }

    public void updatePost(Post updatedPost) {
        postRepository.updatePost(updatedPost);
    }

    public void deletePost(Integer postId){
        postRepository.deletePost(postId);
    }

}
