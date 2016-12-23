package com.xiao.snake.entities;

import java.util.Iterator;

import com.xiao.snake.entities.Snake.Direction;
import com.xiao.snake.view.console.MappConsole;

public class Game {
	private Mapp mMapp;
	private Snake mSnake;

	public Game() {
		this(new MappConsole());
	}

	public Game(Mapp mapp) {
		if (mapp == null) {
			mapp = new MappConsole();
			// TODO Xiao Log: Default values used
		}

		mMapp = mapp;

		this.initialize(mMapp);

	}

	public Mapp getMapp() {
		return mMapp;
	}

	public Snake getSnake() {
		return mSnake;
	}

	public void move(Snake snake, Direction direction, int steps) throws EndGameException {
		// snake move downward 4 point
		for (int i = 0; i < steps; i++) {
			snake.move(direction);

			// If the snake touch the BORDER or eat its own body, Game Over.
			if (mMapp.getMark(snake.getHead()) == MapElement.WALL
					|| mMapp.getMark(snake.getHead()) == MapElement.SNAKE_BODY) {
				throw new EndGameException();
			}

			// If the head of the snake is in an empty space, remove last element within the snake's tail
			if (mMapp.getMark(snake.getHead()) == MapElement.EMPTY) {
				mMapp.setMark(snake.getBody().removeLast(), MapElement.EMPTY);
			}

			draw(snake);
			mMapp.print();

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * @param mapp
	 */
	private void initialize(Mapp mapp) {
		// mark wall on the panel
		Frame.makeBorder(mapp);

		// mark food on the panel
		mapp.setMark(mapp.getEmptyRandomInnerPoint(), MapElement.FOOD);

		//
		mSnake = new Snake(mapp.getMiddle());
	}

	/**
	 * mark of head and body of the snake on the panel
	 * 
	 * @param snake
	 */
	private void draw(Snake snake) {
		Iterator<Point> snakeIterator = snake.getBody().iterator();
		while (snakeIterator.hasNext()) {
			mMapp.setMark(snakeIterator.next(), MapElement.SNAKE_BODY);
		}

		// store the mark of head
		mMapp.setMark(snake.getHead(), MapElement.SNAKE_HEAD);
	}
}
