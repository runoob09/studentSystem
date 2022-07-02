package com.edu.xaufe.service;

import com.alibaba.fastjson.JSONObject;
import com.edu.xaufe.common.Message;
import com.edu.xaufe.enity.User;
import com.edu.xaufe.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private HttpServletRequest httpServletRequest;
    public Message getUser(JSONObject jsonObject){
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        String code = jsonObject.getString("code");
        HttpSession session = httpServletRequest.getSession();
        String myCode = (String) session.getAttribute("code");
        if (code.equalsIgnoreCase(myCode)){
            User user = userMapper.selectByUsernameAndPassword(username, password);
            if(user==null){
                return new Message(404,"该用户不存在",null);
            }
            session.setAttribute("user",user);
            return new Message(200,"成功",null);
        }
        return new Message(404,"验证码错误",null);
    }
}
