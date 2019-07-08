package com.han.controller;

import com.han.entity.Student;
import com.han.service.StudentService;
import com.han.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BaseController {

    @Autowired
    private StudentService studentService;

    /*注入Redis*/
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    /*跳转到主页  ？？？？？？？？？？？？？？？？？？？？？？*/
    @RequestMapping("/")
    public String toIndex(){
        System.out.println("***********************************");
        return "index";
    }

    /*查询详细内容*/
    @RequestMapping("/findOne")
    @ResponseBody
    public String findOne(Long id){

        /*key序列号字符串 增加可读性*/
        RedisSerializer redisSerializer=new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);

        StringUtil stringUtil=StringUtil.getStringUtil();
//      redisTemplate.boundValueOps("student").get();
        Student student;
        /*查询缓存*/
        student = (Student) redisTemplate.opsForValue().get("student");

        if(null == student){
            synchronized (this){
                student = (Student) redisTemplate.opsForValue().get("student");

                if(null == student){
                    /*查询数据库操作*/
                    student=studentService.findById(id);
                    /*更新缓存*/
                    redisTemplate.opsForValue().set("student",student);
                }
            }
        }
        return stringUtil.toJSON(student);
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
