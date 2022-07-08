package com.edu.xaufe.untils;
/**
 * @author 24994
 * @data 2021/12/17
 * @desc 构建可以生成验证码的类
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

@Component
public class Code extends HttpServlet {
    @Autowired
    private HttpServletRequest request;
    //实例化随机模块
    Random random = new Random();

    //获取随机字符串的方法
    private String getRandomString() {
        //初始字符串
        String str = "23456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghgkmnpqrstuvwxyz";
        //构建字符串缓冲区
        StringBuilder sb = new StringBuilder();
        //生成一个长度为4的随机字符串
        for (int i = 0; i < 6; i++) {
            //获取字符
            char letter = str.charAt(random.nextInt(str.length()));
            //追加到字符缓冲区内
            sb.append(letter);
        }
        //返回字符串
        return sb.toString();
    }

    //获取图片背景色
    private Color getBackColor() {
        //获取初始三原色值
        int red = random.nextInt(256);
        int blue = random.nextInt(256);
        int green = random.nextInt(256);
        return new Color(red, blue, green);
    }

    //获取文字颜色
    private Color getFontColor(Color bgcolor) {
        //获取文字三原色值
        int red = 255 - bgcolor.getRed();
        int blue = 255 - bgcolor.getBlue();
        int green = 255 - bgcolor.getGreen();
        return new Color(red, blue, green);
    }

    public BufferedImage getCodeImg() {
        //构建缓冲区图片
        BufferedImage bfImage = new BufferedImage(80, 37, BufferedImage.TYPE_INT_RGB);
        //获取画布对象
        Graphics g = bfImage.getGraphics();
        //设置背景颜色
        Color bgColor = getBackColor();
        g.setColor(bgColor);
        //填充颜色
        g.fillRect(0, 0, 100, 50);
        //设置字体颜色
        Color fontColor = getFontColor(bgColor);
        g.setColor(fontColor);
        //设置字体
        g.setFont(new Font("黑体", Font.BOLD, 26));
        //获取字符串,并保存到session中
        String randomStr = getRandomString();
        HttpSession session = request.getSession();
        session.setAttribute("code", randomStr);
        g.drawString(randomStr, 0, 30);
        //生成噪点
        g.setColor(Color.WHITE);
        for (int i = 0; i < 30; i++) {
            int x = random.nextInt(80);
            int y = random.nextInt(37);
            //向画布上添加噪点
            g.drawRect(x, y, 1, 1);
        }
        //输出到响应流
        return bfImage;
    }
}
