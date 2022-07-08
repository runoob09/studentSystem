package com.edu.xaufe.repository;

import com.edu.xaufe.enity.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
    @Select("select id, name, age, grade, object, ethnic, address from xx")
    List<Student> selectAll();
    @Delete("delete from xx where id=#{id}")
    void deleteById(@Param("id") String id);
    @Update("update xx set name=#{student.name},age=#{student.age},grade=#{student.grade},object=#{student.object},ethnic=#{student.ethnic},address=#{student.address} where id=#{student.id}")
    void updateById(@Param("student") Student student);
    @Insert("insert into xx (name, age, grade, object, ethnic, address) value (#{student.name},#{student.age},#{student.grade},#{student.object},#{student.ethnic},#{student.address})")
    void insertStudent(@Param("student") Student student);
}
