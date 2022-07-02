package com.edu.xaufe.service;

import com.alibaba.fastjson.JSONObject;
import com.edu.xaufe.common.Message;
import com.edu.xaufe.enity.Score;
import com.edu.xaufe.repository.ScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;
    public Message getScore(){
        List<Score> scores = scoreMapper.selectAll();
        return new Message(200,"查询成功",scores);
    }
    public Message deleteScore(JSONObject jsonObject){
        String id = jsonObject.getString("id");
        try{
            scoreMapper.deleteById(id);
            return new Message(200,"删除成功",null);
        }catch(Exception e){
            return new Message(404,"删除失败",null);
        }
    }
    public Message insert(Score score){
        try{
            scoreMapper.insertById(score);
            return new Message(200,"插入成功",null);
        }catch(Exception e){
            return new Message(404,"该学号不存在",null);
        }
    }
    public Message update(Score score){
        try{
            scoreMapper.updataById(score);
            return new Message(200,"修改成功",null);
        }catch(Exception e){
            return new Message(404,"修改失败",null);
        }
    }
}
