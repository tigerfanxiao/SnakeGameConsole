package com.xiao.snake.entities;

import java.util.Iterator;
import java.util.LinkedList;


import com.xiao.snake.view.console.Frame;
import com.xiao.snake.view.console.Panel;

public class SnakeTest {
	public static void main(String[] args) {
		Panel panel = new Panel(10, 30);
		// �����߽�
		Frame.makeBorder(panel);
		// �������ʳ��
		Food food = new Food(panel);
		food.showFood(food.foodGenerate());
		panel.printPanel();
		
		Snake snake = new Snake(panel);
		snake.initiateSnake();

		snake.drawSnake();
		panel.printPanel();
		
	}
}
