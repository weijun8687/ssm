package com.laowei.controller;


import com.laowei.po.Student;
import com.laowei.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @RequestMapping("/queryStudent")
    public String selectAllStudent(Model model){

        List<Student> list = service.selectAllStudent();
        model.addAttribute("list", list);

        return "queryStudent";
    }


}
