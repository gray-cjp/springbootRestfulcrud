package com.cjp.restfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class LoginController {
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(String username, String password, Map<String,Object> map, HttpServletRequest request){
        request.getSession().setAttribute("user",username);
        if ("admin".equals(username)&&"123".equals(password)){
            return "redirect:/dashboard";
        }else {
            map.put("msg","用户名或者密码错误");
            return "index";
        }
    }
}
