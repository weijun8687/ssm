package com.laowei.service.Impl;

import com.laowei.mapper.StudentMapper;
import com.laowei.po.Student;
import com.laowei.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper mapper;

    @Override
    public List<Student> selectAllStudent() {
        return mapper.queryStudent();
    }
}
