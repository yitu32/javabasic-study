package com.yitu32.draw.paint;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

// 画板
public class MyPanel extends JPanel {
    /**
     * 绘图方法
     * @param g -> 理解为画笔
     * 1.组件第一次在屏幕上显示的时候，程序自动调用paint方法
     * 2.窗口最小化再最大化时，会调用
     * 3.窗口大小发生变化
     * 4.repaint 刷新组件外观时
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("paint方法被调用了");
        // 画一个圆
        /*g.drawOval(10, 10, 100, 100);
        // 画直线
        g.drawLine(10, 10, 100, 100);
        // 画矩形
        g.drawRect(15,55,100,150);

        g.setColor(Color.BLUE);
        g.fillRect(22,13,50,60);
        // 从根目录得到一张图片
        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bg.png"));
        // 把图片画在画板上
        g.drawImage(image,20,10,155,166,this);

        g.setColor(Color.red);
        g.setFont(new Font("隶书",Font.BOLD,50));
        // 写字
        g.drawString("你好",350,370);*/

        g.fill3DRect(30,40,500,200,true);



    }
}
