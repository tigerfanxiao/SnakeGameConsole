package com.xiao.snake;

import com.xiao.snake.entities.Food;
import com.xiao.snake.entities.Snake;
import com.xiao.snake.view.console.Frame;
import com.xiao.snake.view.console.Panel;

public class Main {
	public static void main(String[] args) throws InterruptedException  {
		Panel panel = new Panel();

//		画出边界
		Frame.makeBorder(panel);
		
//		随机生成食物
		Food food = new Food(panel);

		food.showFood(food.foodGenerate());
//		创蛇
		Snake snake00 = new Snake();
//		蛇在初始位置
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
