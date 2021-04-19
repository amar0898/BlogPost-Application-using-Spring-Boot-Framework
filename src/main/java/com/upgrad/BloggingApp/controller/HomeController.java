package com.upgrad.BloggingApp.controller;

import com.upgrad.BloggingApp.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.ArrayList;
import java.util.Date;

@Controller
public class HomeController {

    @RequestMapping("/getAllPosts")
    public String getAllPost(Model model){

        ArrayList<Post> posts=new ArrayList<>();

        Post post1=new Post();
        post1.setTitle("Muscle Building");
        post1.setBody("Gain muscle mass by drinking shake");
        post1.setDate(new Date());

        Post post2=new Post();
        post2.setTitle("Muscle Building");
        post2.setBody("Gain muscle mass by drinking shake");
        post2.setDate(new Date());

        Post post3=new Post();
        post3.setTitle("Muscle Building");
        post3.setBody("Gain muscle mass by drinking shake");
        post3.setDate(new Date());

        posts.add(post1);
        posts.add(post2);
        posts.add(post3);

        model.addAttribute("posts",posts);

        return "index";

    }
}
