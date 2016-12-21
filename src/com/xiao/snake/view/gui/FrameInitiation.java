package com.xiao.snake.view.gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class FrameInitiation {
	/**
	 * show window at the center of Screen
	 * 
	 * @param jframe
	 * @param height
	 * @param width
	 */
	public static void FrameInit(JFrame jframe, int height, int width) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension d = toolkit.getScreenSize();
		double widthOfScreen = d.getWidth();
		double heightOfScreen = d.getHeight();

		jframe.setBounds((int) (widthOfScreen - width) / 2, (int) (heightOfScreen - height) / 2, width, height);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// jframe.setVisible(true);
	}

}
