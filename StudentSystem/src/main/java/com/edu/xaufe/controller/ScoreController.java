package com.edu.xaufe.controller;

import com.alibaba.fastjson.JSONObject;
import com.edu.xaufe.common.Message;
import com.edu.xaufe.enity.Score;
import com.edu.xaufe.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @GetMapping("/score")
    public Message get() {
        return scoreService.getScore();
    }

    @DeleteMapping("/score")
    public Message delete(@RequestBody JSONObject jsonObject) {
        return scoreService.deleteScore(jsonObject);
    }
    @PutMapping ("/score")
    public Message put(@RequestBody Score score) {
        return scoreService.update(score);
    }
    @PostMapping ("/score")
    public Message post(@RequestBody Score score) {
        return scoreService.insert(score);
    }
}
