package com.xiao.snake.view.console;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
/*
 * ���ｨ���Ĺ�����, ��һ����̬�ķ���, ע�⹤�����ʹ��, ע���Լ������Ĺ������java�����Ĺ����಻ͬ, 
 * java�����Ĺ�����, �����ܶ�, �Լ������Ĺ�����,ֻ��Ϊ��ʵ���ض�����, �ض����������
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
