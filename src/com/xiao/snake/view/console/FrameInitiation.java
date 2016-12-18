package com.xiao.snake.view.console;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
/*
 * 这里建立的工具类, 用一个静态的方法, 注意工具类的使用, 注意自己建立的工具类和java建立的工具类不同, 
 * java建立的工具类, 方法很多, 自己建立的工具类,只是为了实现特定方法, 特定的命令组合
 * 
 */
public class FrameInitiation {
	
	public static void FrameInit(JFrame jframe, int height, int width){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension d = toolkit.getScreenSize();
		double x = d.getWidth();
		double y = d.getHeight();
		
		jframe.setBounds((int)(x - width) / 2, (int)(y - height) / 2, width, height);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jframe.setVisible(true);
	}
	
}
