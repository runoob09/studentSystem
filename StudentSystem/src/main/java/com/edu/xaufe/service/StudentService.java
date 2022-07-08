package com.edu.xaufe.service;

import com.alibaba.fastjson.JSONObject;
import com.edu.xaufe.common.Message;
import com.edu.xaufe.enity.Student;
import com.edu.xaufe.repository.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public Message getAllStudents(){
        List<Student> students = studentMapper.selectAll();
        return new Message(200,"查询成功",students);
    }
    public Message delete(JSONObject jsonObject){
        String id = jsonObject.getString("id");
        try{
            studentMapper.deleteById(id);
            return new Message(200,"删除成功",null);
        }catch (Exception e){
            return new Message(404,"删除失败",null);
        }
    }
    public Message updata(Student student){
        try{
            studentMapper.updateById(student);
            return new Message(200,"修改成功",null);
        }catch (Exception e){
            return new Message(404,"修改失败",null);
        }
    }
    public Message insert(Student student){
        try{
            studentMapper.insertStudent(student);
            return new Message(200,"插入成功",null);
        }catch (Exception e){
            return new Message(404,"插入失败",null);
        }
    }
}
