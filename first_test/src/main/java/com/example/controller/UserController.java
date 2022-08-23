package com.example.controller;

import com.example.dao.UserDao;
import com.example.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;

@Controller
public class UserController {
    @Resource
    private UserDao userDao;

    @RequestMapping("/tologin")
    public String tologin(){
        return "login";
    }
    @RequestMapping("/userlogin")
    public ModelAndView login(String uname, String password){
        ModelAndView mv = new ModelAndView(new RedirectView("/stuquery"));
        if(uname == null || "".equals(uname) || password == null || "".equals(password)){
            mv.addObject("msg", "用户名密码不能为空");
            mv.setViewName("login");
            return mv;
        }
        User u = userDao.findByUnameAndPassword(uname, password);
        if(u == null){
            mv.addObject("msg","用户名或密码错误");
            mv.setViewName("login");
            return mv;
        }
        return mv;
    }
}
