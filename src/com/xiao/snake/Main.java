package com.xiao.snake;

import java.util.logging.Logger;

import com.xiao.snake.entities.EndGameException;
import com.xiao.snake.entities.Game;
import com.xiao.snake.entities.Snake;
import com.xiao.snake.entities.Snake.Direction;
import com.xiao.snake.view.console.MappConsole;

public class Main {
	// TODO MMZ2 Being able to read logging configuration from file
	private final static Logger logger = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) throws InterruptedException {
		logger.info("Prueba");
		Game game = new Game(new MappConsole(40, 20));

		Snake snake = game.getSnake();

		// Move the snake around the screen
		try {
			game.move(snake, Direction.UP, 1);
			game.move(snake, Direction.LEFT, 5);
			game.move(snake, Direction.DOWN, 1);
			game.move(snake, Direction.LEFT, 3);
		} catch (EndGameException e) {
			System.out.println("Game Over!");
		}
	}
}
