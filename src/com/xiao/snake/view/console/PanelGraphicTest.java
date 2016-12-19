package com.xiao.snake.view.console;

import javax.swing.JFrame;

import com.xiao.snake.entities.Food;
import com.xiao.snake.entities.Snake;

public class PanelGraphicTest {

	public static void main(String args[]) throws InterruptedException {
		JFrame frame = new JFrame("Snake");
		Panel myPanel = new Panel(20, 30);
		Frame.makeBorder(myPanel);
		Food food = new Food(myPanel);
		food.showFood(food.foodGenerate());
		Snake snake = new Snake(myPanel);
		snake.initiateSnake();
		snake.drawSnake();
		
		PanelGraphic mPanelGraphic = new PanelGraphic(myPanel);
		frame.add(mPanelGraphic);
		
		FrameInitiation.FrameInit(frame, 20 * (myPanel.getHeight() + 1), 20 * myPanel.getWidth());	
		mPanelGraphic.setVisible(true);
		frame.setVisible(true);
		
		for (int i = 0; i < 5; i++) {
			snake.snakeMove('R');
			snake.drawSnake();
			Thread.sleep(500);
			mPanelGraphic.repaint();//repaint the snake
		}
		
//snake move upward 3 points
		for (int i = 0; i < 3; i++) {
			snake.snakeMove('U');
			snake.drawSnake();
			Thread.sleep(500);
			mPanelGraphic.repaint();
		}
		//snake move left 3 points
		for (int i = 0; i < 3; i++) {
			snake.snakeMove('L');
			snake.drawSnake();
			Thread.sleep(500);
			mPanelGraphic.repaint();
		}
		//snake move downward 4 point
		for (int i = 0; i < 4; i++) {
			snake.snakeMove('D');
			snake.drawSnake();
			Thread.sleep(500);
			mPanelGraphic.repaint();				
		}
		
	}

}
