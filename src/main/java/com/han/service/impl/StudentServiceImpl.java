package com.han.service.impl;

import com.han.entity.Student;
import com.han.service.StudentService;
import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentServiceImpl extends BaseServiceImpl<Student> implements StudentService {
}
