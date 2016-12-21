package com.xiao.snake.entities;

import java.util.Iterator;
import java.util.LinkedList;

public class Snake {
	// TODO: Add proper comments
	private static int DEFAULT_LENGTH = 4;
	private int mLength;
	private LinkedList<Point> mBody = new LinkedList<>(); // the body of the
															// snake

	// TODO: Add proper comments
	public enum Direction {
		LEFT, RIGHT, UP, DOWN;
	}

	// TODO: Add proper comments
	public Snake(Point position) {
		this(position, DEFAULT_LENGTH);
	}

	// TODO: Add proper comments
	public Snake(Point position, int length) {
		// TODO: Check the length correctly. This is just an example
		if (length <= 0) {
			mLength = DEFAULT_LENGTH;
			// TODO: Add a log to indicate that the length passed is incorrect
		} else {
			mLength = length;
		}

		// TODO: Review where the width and height are located
		this.initialize(mBody, mLength, position.getX(), position.getY());
	}

	/**
	 * store the mark of head and body of the snake on the panel
	 */
	public void drawSnake(Mapp mapp) {
		Iterator<Point> snakeIterator = mBody.iterator();
		while (snakeIterator.hasNext()) {
			mapp.setMark(snakeIterator.next(), MapElement.SNAKE_BODY);
		}

		// store the mark of head
		mapp.setMark(mBody.getFirst(), MapElement.SNAKE_HEAD);
	}

	/**
	 * Snake will change the moving direction if it is received the command of
	 * directions. If there is no command of changing direction or the direction
	 * is reverse the current direction, the snake will keep the current
	 * direction. Snake will have four moving direction: U for upward, D for
	 * downward, L for left, R for right. If the snake eat the food, its body
	 * will enlarge itself with one unit. If the snake touch the boarder, Game
	 * over, the thread exits JVM.
	 * 
	 * @param char
	 *            for direction
	 */
	public void snakeMove(Mapp mapp, Direction direction) {
		// nextHeadCurrentDirction store the next position of head of snake, if
		// the
		// snake keep the current of direction
		Point nextHeadCurrentDirection = snakeDirection();
		// nextHeadChangeDirection store the next position of head of snake, if
		// receive a
		// command of changing direction from keyboard
		Point nextHeadChangeDirection = snakeDirection();
		switch (direction) {
		case UP:
			nextHeadChangeDirection = new Point(mBody.getFirst().getX(), mBody.getFirst().getY() - 1);
			break;
		case DOWN:
			nextHeadChangeDirection = new Point(mBody.getFirst().getX(), mBody.getFirst().getY() + 1);
			break;
		case LEFT:
			nextHeadChangeDirection = new Point(mBody.getFirst().getX() - 1, mBody.getFirst().getY());
			break;
		case RIGHT:
			nextHeadChangeDirection = new Point(mBody.getFirst().getX() + 1, mBody.getFirst().getY());
			break;
		default:
			break;
		}

		// If receive the command of changing direction, the snake will change
		// direction, otherwise will keep
		// the current direction
		if (Math.abs(nextHeadCurrentDirection.getX() - nextHeadChangeDirection.getX()) <= 1
				&& Math.abs(nextHeadCurrentDirection.getY() - nextHeadChangeDirection.getY()) <= 1) {
			mBody.addFirst(nextHeadChangeDirection);
		} else {
			mBody.addFirst(nextHeadCurrentDirection);
		}
		// if the snake eat the food, the length of its body will enlarge with
		// one unit.
		if (mapp.getMark(mBody.getFirst()) != MapElement.FOOD) {
			mapp.setMark(mBody.removeLast(), MapElement.EMPTY);
		}
		// If the snake touch the boarder or eat its own body, Game Over, the
		// thread exits JVM
		if (mapp.getMark(mBody.getFirst()) == MapElement.WALL
				|| mapp.getMark(mBody.getFirst()) == MapElement.SNAKE_BODY) {
			drawSnake(mapp);
			mapp.print();
			System.out.println("Game Over!");
			System.exit(0);
		}
	}

	/**
	 * @return the next point where the head of snake would show if no command
	 *         of changing direction
	 */
	public Point snakeDirection() {
		Point nextPoint;
		if (mBody.get(0).getY() == mBody.get(1).getY()) {
			// The snake is moving horizontally
			nextPoint = new Point(2 * mBody.get(0).getX() - mBody.get(1).getX(), mBody.get(0).getY());
		} else {
			nextPoint = new Point(mBody.get(0).getX(), 2 * mBody.get(0).getY() - mBody.get(1).getY());
		}
		return nextPoint;
	}

	public void move(Mapp mapp, Direction direction, int steps) {
		// snake move downward 4 point
		for (int i = 0; i < steps; i++) {
			snakeMove(mapp, direction);
			drawSnake(mapp);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			mapp.print();
		}
	}

	/**
	 * store the position of head and body of snake in the Linkedlist
	 */
	private void initialize(LinkedList<Point> body, int length, int x, int y) {
		// ToDo: Check if the length is bigger than width and height.
		// Initialize by a default value if not.

		Point head = new Point(x, y);
		body.addLast(head);
		for (int i = 1; i < length; i++) {
			body.addLast(new Point(head.getX() - i, head.getY()));
		}
	}

}