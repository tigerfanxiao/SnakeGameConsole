package com.xiao.snake;

import com.xiao.snake.entities.Game;
import com.xiao.snake.entities.Snake;
import com.xiao.snake.entities.Snake.Direction;
import com.xiao.snake.view.console.Panel;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Game game = new Game(new Panel(40,20));
		
		
		Snake snake = game.getSnake();
		
		// snake move right 5 steps
		snake.move(Direction.RIGHT, 5);

		// snake move upward 3 steps
		snake.move(Direction.UP, 3);

		// snake move left 3 steps
		snake.move(Direction.LEFT, 3);
	}
}
