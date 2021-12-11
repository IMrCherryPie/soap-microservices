package com.soapclient.controller;

import com.soap.gen.User;
import com.soap.gen.UserResponse;
import com.soapclient.RequestExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    RequestExecutor requestExecutor;

    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    @RequestMapping("/login")
    public String doLogin(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("result", "");
        return "login";
    }

    @RequestMapping("/users")
    public String getUsers(Model model) {
        User userForRequest = new User();
        userForRequest.setName("");
        UserResponse response = requestExecutor.getUser(userForRequest);
        List<User> users =  response.getUsers();
        model.addAttribute("users", users);
        return "views/users";
    }

    @PostMapping("/checkUser")
    public String confirmUser(@ModelAttribute("user") User user, Model model) {
        UserResponse response = requestExecutor.getUser(user);
        List<User> users = response.getUsers();
        if(users.size() == 0){
            model.addAttribute("result", "2");
            model.addAttribute("user", new User());
            return "login";
        }else {
            model.addAttribute("result", "1");
            return "login";
        }
    }
}
