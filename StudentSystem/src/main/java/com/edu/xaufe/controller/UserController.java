package com.edu.xaufe.controller;

import com.alibaba.fastjson.JSONObject;
import com.edu.xaufe.common.Message;
import com.edu.xaufe.enity.User;
import com.edu.xaufe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest request;

    @GetMapping("/user")
    public Message get() {
        User user = (User) request.getSession().getAttribute("user");
        if (user==null){
            return new Message(404,null,null);
        }
        return new Message(200,null,null);
    }

    @PostMapping("/user")
    public Message login(@RequestBody JSONObject jsonObject) {
        return userService.getUser(jsonObject);
    }
}
