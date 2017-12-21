package com.laowei.mapper;


import com.laowei.po.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {

	List<Student> queryStudent();

	List<Student> queryStudentByName(String name);
   
}