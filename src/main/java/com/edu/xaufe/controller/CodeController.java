package com.edu.xaufe.controller;

import com.edu.xaufe.untils.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
public class CodeController {
    @Autowired
    private Code code;
    @Autowired
    private HttpServletResponse response;
    @GetMapping("/code")
    public void get() throws IOException {
        BufferedImage codeImg = code.getCodeImg();
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(codeImg,"jpg",outputStream);
    }
}
