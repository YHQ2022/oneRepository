package com.example.controller;

import com.example.dao.ClaDao;
import com.example.dao.StuDao;
import com.example.entity.Cla;
import com.example.entity.Stu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class StuController {

    @Resource
    private StuDao stuDao;

    @Resource
    private ClaDao claDao;

    @RequestMapping("/stuquery")
    public ModelAndView query() {
        ModelAndView mv = new ModelAndView("stuquery");
        List<Stu> list = stuDao.findAll();
        mv.addObject("list", list);
        List<Cla> clist = claDao.findAll();
        mv.addObject("clist", clist);
        return mv;
    }

    @RequestMapping("/stumod")
    public ModelAndView mod(Stu s) {
        ModelAndView mv = new ModelAndView(new InternalResourceView("/stuquery"));
        stuDao.save(s);
        mv.addObject("msg", "修改成功！");
        return mv;
    }

    @RequestMapping("/studel")
    public ModelAndView del(Integer sid) {
        ModelAndView mv = new ModelAndView(new InternalResourceView("/stuquery"));
        stuDao.deleteById(sid);
        mv.addObject("msg", "刪除成功！");
        return mv;
    }

    @RequestMapping("/stuadd")
    public ModelAndView add(Stu s) {
        ModelAndView mv = new ModelAndView(new InternalResourceView("/claquery"));
        stuDao.save(s);
        mv.addObject("msg", "添加成功！");
        return mv;
    }
    @RequestMapping("/stufind")//班级搜索框
    public ModelAndView find(Integer sid){
        ModelAndView mv = new ModelAndView(new InternalResourceView("/stuquery"));
        Stu stu = stuDao.findById(sid).get();
        mv.addObject("stu",stu);
        return mv;
    }
}
