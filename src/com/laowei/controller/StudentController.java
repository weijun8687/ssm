package com.laowei.controller;


import com.laowei.po.Student;
import com.laowei.service.StudentService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @RequestMapping("/queryStudent")
    public String selectAllStudent(Model model){

        List<Student> list = service.selectAllStudent();
        model.addAttribute("list", list);

        // 重定向到指定页面, 在 springmvc 中配置
        return "queryStudent";
    }


    @RequestMapping("/queryStudent1")
    public @ResponseBody JSONObject selectcountStudent(){
        List<Student> list = service.selectAllStudent();
        JSONObject result = new JSONObject();
        result.put("countt", list.size());
        result.put("list", list);
        return result;
    }

    @RequestMapping("/requestByName")
    @ResponseBody
    public JSONObject selectStudentByName(@RequestBody JSONObject json){

        List<Student> list = service.selectStudentByName(json.getString("name"));
        JSONObject result = new JSONObject();
        result.put("list", list);

        list.size();

        return result;
    }

}
