package com.xiao.snake.view.gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import com.xiao.snake.entities.MapElement;
import com.xiao.snake.entities.Mapp;
import com.xiao.snake.view.console.Frame;

public class DemoKeyAcction {

	public static void main(String args[]) throws InterruptedException {
		JFrame frame = new JFrame("Snake");
		Mapp mapp = new Mapp(30, 20);
		Frame.makeBorder(mapp);

		mapp.setMark(mapp.getEmptyRandomInnerPoint(), MapElement.FOOD);

		SnakeGraphic snake = new SnakeGraphic(mapp, mapp.getMiddle());
		snake.drawSnake(mapp);

		PanelGraphic mPanelGraphic = new PanelGraphic(mapp);
		frame.add(mPanelGraphic);

		FrameInitiation.FrameInit(frame, 20 * (mapp.getHeight() + 1), 20 * mapp.getWidth());
		mPanelGraphic.setVisible(true);
		frame.setVisible(true);
		/**
		 * use keyboard to control the move of snake
		 */
		frame.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				snake.snakeMove(e);
				snake.drawSnake(mapp);
				frame.repaint();
			}
		});
	}
}
