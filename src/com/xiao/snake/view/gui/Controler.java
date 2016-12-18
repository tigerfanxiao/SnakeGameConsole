package com.xiao.snake.view.gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.xiao.snake.view.console.FrameInitiation;

public class Controler {
	public static void main(String[] args) {
		JFrame controler = new JFrame("control of direction");
		JButton buttonUp = new JButton("up");
		controler.add(buttonUp, BorderLayout.NORTH);
		JButton buttonRight = new JButton("right");
		controler.add(buttonRight, BorderLayout.EAST);
		JButton buttonDown = new JButton("down");
		controler.add(buttonDown, BorderLayout.SOUTH);
		JButton buttonLeft = new JButton("left");
		controler.add(buttonLeft, BorderLayout.WEST);
		JButton buttonCenter = new JButton("center");
		controler.add(buttonCenter, BorderLayout.CENTER);
		
		FrameInitiation.FrameInit(controler, 400, 400);

	}
}
