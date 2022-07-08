package com.edu.xaufe;

import com.edu.xaufe.enity.Score;
import com.edu.xaufe.enity.Student;
import com.edu.xaufe.repository.ScoreMapper;
import com.edu.xaufe.repository.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentSystemApplicationTests {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ScoreMapper scoreMapper;
    @Test
    void contextLoads() {
        Score score = new Score();
        score.setScore(98);
        score.setName("算法设计与分析");
        score.setId(1003);
        scoreMapper.updataById(score);
    }

}
