package com.xiao.snake;

import com.xiao.snake.entities.Food;
import com.xiao.snake.entities.Snake;
import com.xiao.snake.view.console.Frame;
import com.xiao.snake.view.console.Panel;

public class Main {
	public static void main(String[] args) throws InterruptedException  {
		Panel panel = new Panel();

//		�����߽�
		Frame.makeBorder(panel);
		
//		�������ʳ��
		Food food = new Food(panel);

		food.showFood(food.foodGenerate());
//		����
		Snake snake00 = new Snake();
//		���ڳ�ʼλ��
		snake00.initiateSnake();
		
		panel.changePoint(5, 18, '@');
		panel.changePoint(5, 20, '@');
		
		for(int i = 0; i < 5; i++) {
			snake00.snakeMove('R');
			snake00.drawSnake();
			Thread.sleep(500);
			panel.printPanel();
		}
		
		for(int i = 0; i < 3; i++) {
			snake00.snakeMove('U');
			snake00.drawSnake();
			Thread.sleep(500);
			panel.printPanel();
		}
		
		for(int i = 0; i < 3; i++) {
			snake00.snakeMove('L');
			snake00.drawSnake();
			Thread.sleep(500);
			panel.printPanel();
		}
		
		for(int i = 0; i < 4; i++) {
			snake00.snakeMove('D');
			snake00.drawSnake();
			Thread.sleep(500);
			panel.printPanel();
		}
		
	}
}
