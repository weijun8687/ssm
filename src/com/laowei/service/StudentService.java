package com.laowei.service;

import com.laowei.po.Student;

import java.util.List;

public interface StudentService {


    List<Student> selectAllStudent();

    List<Student> selectStudentByName(String name);

}
