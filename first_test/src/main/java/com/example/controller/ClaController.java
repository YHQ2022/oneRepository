package com.example.controller;

import com.example.dao.ClaDao;
import com.example.entity.Cla;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Controller
public class ClaController {
    @Resource
    private ClaDao claDao;

    @RequestMapping("/claquery")
    public ModelAndView query(){
        ModelAndView mv = new ModelAndView("claquery");
        List<Cla> list = claDao.findAll();
        mv.addObject("list",list);
        return mv;
    }
    @RequestMapping("/cladd")
    public ModelAndView add(Cla c){
        ModelAndView mv = new ModelAndView(new InternalResourceView("/claquery"));
        claDao.save(c);
        mv.addObject("msg","添加成功！");
        return mv;
    }

    @RequestMapping("/clamod")
    public ModelAndView mod(Cla c){
        ModelAndView mv = new ModelAndView(new InternalResourceView("/claquery"));
        claDao.save(c);
        mv.addObject("msg","修改成功！");
        return mv;
    }
    @RequestMapping("/cladel")
    public ModelAndView del(Integer cid){
        ModelAndView mv = new ModelAndView(new InternalResourceView("/claquery"));
        claDao.deleteById(cid);
        mv.addObject("msg","刪除成功！");
        return mv;
    }
    @RequestMapping("/find")//班级搜索框
    public ModelAndView find(Integer cid){
        ModelAndView mv = new ModelAndView(new InternalResourceView("/claquery"));
        Cla cla = claDao.findById(cid).get();
        System.out.println(cla);
        mv.addObject("cla",cla);
        return mv;
    }
}
