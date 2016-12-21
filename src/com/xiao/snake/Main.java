package com.xiao.snake;

import java.util.logging.Logger;

import com.xiao.snake.entities.Game;
import com.xiao.snake.entities.Mapp;
import com.xiao.snake.entities.Snake;
import com.xiao.snake.entities.Snake.Direction;

public class Main {
	private final static Logger logger = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) throws InterruptedException {
		// TODO: Being able to read logging configuration from file
		logger.info("Prueba");
		Game game = new Game(new Mapp(40, 20));

		Snake snake = game.getSnake();

		// snake move right 5 steps
		snake.move(game.getMapp(), Direction.RIGHT, 5);

		// snake move upward 3 steps
		snake.move(game.getMapp(), Direction.UP, 3);

		// snake move left 3 steps
		snake.move(game.getMapp(), Direction.LEFT, 3);
	}
}
