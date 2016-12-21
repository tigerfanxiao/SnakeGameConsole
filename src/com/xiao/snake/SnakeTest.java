package com.xiao.snake;

import com.xiao.snake.entities.MapElement;
import com.xiao.snake.entities.Mapp;
import com.xiao.snake.entities.Snake;
import com.xiao.snake.view.console.Frame;

public class SnakeTest {
	public static void main(String[] args) {
		Mapp mapp = new Mapp(10, 30);
		// �����߽�
		Frame.makeBorder(mapp);
		// �������ʳ��
		mapp.setMark(mapp.getEmptyRandomInnerPoint(), MapElement.FOOD);

		mapp.print();

		Snake snake = new Snake(mapp.getMiddle());

		snake.drawSnake(mapp);
		mapp.print();

	}
}
