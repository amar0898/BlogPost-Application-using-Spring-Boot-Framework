package com.upgrad.BloggingApp.controller;


import com.upgrad.BloggingApp.model.User;
import com.upgrad.BloggingApp.model.UserProfile;
import com.upgrad.BloggingApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET,value="/users/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "users/login";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/login")
    public String loginUser(User user, HttpSession httpSession) {
        User existingUser = userService.login(user);
        if(existingUser == null) {
            return "users/login";
        } else {

            httpSession.setAttribute("LoggedUser",existingUser);
            return "redirect:/posts";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/registration")
    public String registerUser(Model model) {

        User user = new User();
        UserProfile userProfile = new UserProfile();
        user.setUserProfile(userProfile);
        model.addAttribute("user", user);


        return "users/registration";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/registration")
    public String userRegistration(User user) {

        userService.registerUser(user);
        return "redirect:/users/login";
    }

    @RequestMapping("/users/logout")
    public String userLogout(HttpSession httpSession) {

        httpSession.invalidate();
        return "redirect:/";
    }
}
