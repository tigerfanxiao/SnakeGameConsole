package com.xiao.snake.view.console;

import javax.swing.JFrame;

import com.xiao.snake.entities.Food;
import com.xiao.snake.entities.Snake;
import com.xiao.snake.entities.Snake.Direction;

public class PanelGraphicTest {

	public static void main(String args[]) throws InterruptedException {
		JFrame frame = new JFrame("Snake");
		Panel myPanel = new Panel(20, 30);
		Frame.makeBorder(myPanel);
		Food food = new Food(myPanel);
		food.showFood();
		Snake snake = new Snake(myPanel);
		snake.drawSnake();
		
		PanelGraphic mPanelGraphic = new PanelGraphic(myPanel);
		frame.add(mPanelGraphic);
		
		FrameInitiation.FrameInit(frame, 20 * (myPanel.getHeight() + 1), 20 * myPanel.getWidth());	
		mPanelGraphic.setVisible(true);
		frame.setVisible(true);
		
		snake.move(Direction.RIGHT, 5);
		snake.move(Direction.UP, 3);
		snake.move(Direction.LEFT, 3);
		snake.move(Direction.DOWN, 4);		
	}

}
