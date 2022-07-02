package com.edu.xaufe.controller;

import com.alibaba.fastjson.JSONObject;
import com.edu.xaufe.common.Message;
import com.edu.xaufe.enity.Student;
import com.edu.xaufe.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public Message get() {
        return studentService.getAllStudents();
    }

    @DeleteMapping("/students")
    public Message delete(@RequestBody JSONObject jsonObject) {
        return studentService.delete(jsonObject);
    }

    @PutMapping("/students")
    public Message put(@RequestBody Student student) {
        return studentService.updata(student);
    }
    @PostMapping("/students")
    public Message post(@RequestBody Student student) {
        return studentService.insert(student);
    }
}
