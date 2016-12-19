package com.xiao.snake.view.console;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import com.xiao.snake.entities.Food;
import com.xiao.snake.entities.SnakeGraphic;

public class DemoKeyAcction {

	public static void main(String args[]) throws InterruptedException {
		JFrame frame = new JFrame("Snake");
		Panel myPanel = new Panel(20, 30);
		Frame.makeBorder(myPanel);
		Food food = new Food(myPanel);
		food.showFood(food.foodGenerate());
		SnakeGraphic snake = new SnakeGraphic(myPanel);
		snake.initiateSnake();
		snake.drawSnake();
		
		PanelGraphic mPanelGraphic = new PanelGraphic(myPanel);
		frame.add(mPanelGraphic);
		
		FrameInitiation.FrameInit(frame, 20 * (myPanel.getHeight() + 1), 20 * myPanel.getWidth());	
		mPanelGraphic.setVisible(true);
		frame.setVisible(true);
		/**
		 * use keyboard to control the move of snake
		 */
		frame.addKeyListener(new KeyAdapter(){

			@Override
			public void keyPressed(KeyEvent e) {
				snake.snakeMove(e);
				snake.drawSnake();
				frame.repaint();
			}
		});
	}
}
