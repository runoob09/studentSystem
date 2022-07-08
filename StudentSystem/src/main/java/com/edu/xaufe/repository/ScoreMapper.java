package com.edu.xaufe.repository;

import com.edu.xaufe.enity.Score;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ScoreMapper {
    @Select("select * from xc")
    List<Score> selectAll();
    @Delete("delete from xc where id = #{id}")
    void deleteById(@Param("id") String id);
    @Insert("insert into xc (name, score) value (#{score.name},#{score.score})")
    void insertById(@Param("score") Score score);
    @Update("update xc set name=#{score.name},score=#{score.score} where id = #{score.id}")
    void updataById(@Param("score") Score score);
}
