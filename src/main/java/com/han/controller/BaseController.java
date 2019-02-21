package com.han.controller;

import com.han.service.StudentService;
import com.han.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BaseController {

    @Autowired
    StudentService studentService;

    /*跳转到主页*/
    @RequestMapping("/")
    public String toIndex(){
        System.out.println("***********************************");
        return "index";
    }

    /*查询详细内容*/
    @RequestMapping("/findOne")
    @ResponseBody
    public String findOne(Long id){
        StringUtil stringUtil=StringUtil.getStringUtil();
        return stringUtil.toJSON(studentService.findById(id));
    }

    /*跳转到student页面*/
    @RequestMapping("/toStudent")
    public String toStudent(){
        return "studentList";
    }

    /*获取学生列表*/
    @RequestMapping("/studentList")
    @ResponseBody
    public String studentList(){
        System.out.println("123");
        return "student";
    }
}
