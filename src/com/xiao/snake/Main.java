package com.xiao.snake;

import com.xiao.snake.entities.Food;
import com.xiao.snake.entities.Snake;
import com.xiao.snake.view.console.Frame;
import com.xiao.snake.view.console.Panel;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Panel panel = new Panel(10, 30);

		// �����߽�
		Frame.makeBorder(panel);

		// �������ʳ��
		Food food = new Food(panel);
		food.showFood(food.foodGenerate());
		// ����
		Snake snake = new Snake(panel);
		snake.initiateSnake();

		// test if the snake would become longer when it eat food
		// panel.changePoint(5, 18, '@');
		// panel.changePoint(5, 20, '@');

		//snake move right 5 points
		for (int i = 0; i < 5; i++) {
			snake.snakeMove('R');
			snake.drawSnake();
			Thread.sleep(500);
			panel.printPanel();
		}
		//snake move upward 3 points
		for (int i = 0; i < 3; i++) {
			snake.snakeMove('U');
			snake.drawSnake();
			Thread.sleep(500);
			panel.printPanel();
		}
		//snake move left 3 points
		for (int i = 0; i < 3; i++) {
			snake.snakeMove('L');
			snake.drawSnake();
			Thread.sleep(500);
			panel.printPanel();
		}
		//snake move downward 4 point
		for (int i = 0; i < 4; i++) {
			snake.snakeMove('D');
			snake.drawSnake();
			Thread.sleep(500);
			panel.printPanel();
		}

	}
}
