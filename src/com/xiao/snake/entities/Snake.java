package com.xiao.snake.entities;

import java.util.Iterator;
import java.util.LinkedList;

import com.xiao.snake.view.console.Panel;

public class Snake {
	// TODO: Add proper comments
	private static int DEFAULT_LENGTH = 4;
	private int mLength;
	private Panel mPanel;
	private LinkedList<Point> mBody = new LinkedList<>(); // the body of the
															// snake

	// TODO: Add proper comments
	public enum Direction {
		LEFT, RIGHT, UP, DOWN
	}

	// TODO: Add proper comments
	public Snake(Panel panel) {
		this(panel, DEFAULT_LENGTH);
	}

	// TODO: Add proper comments
	public Snake(Panel panel, int length) {
		mPanel = panel;

		// TODO: Check the length correctly. This is just an example
		if (length <= 0) {
			mLength = DEFAULT_LENGTH;
			// TODO: Add a log to indicate that the length passed is incorrect
		} else {
			mLength = length;
		}

		this.initialize(mBody, mLength, panel.getWidth() / 2, panel.getHeight() / 2);
	}

	/**
	 * store the mark of head and body of the snake on the panel
	 */
	public void drawSnake() {
		Iterator<Point> snakeIterator = mBody.iterator();
		while (snakeIterator.hasNext()) {
			mPanel.markPoint(snakeIterator.next(), '#');
		}
		mPanel.markPoint(mBody.getFirst(), '$'); // store the mark of head with
													// char $
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
	public void snakeMove(Direction direction) {
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
		if (mPanel.getMark(mBody.getFirst()) != Food.SYMBOL) {
			mPanel.markPoint(mBody.removeLast(), ' ');
		}
		// If the snake touch the boarder or eat its own body, Game Over, the
		// thread exits JVM
		if (mPanel.getMark(mBody.getFirst()) == '*' || mPanel.getMark(mBody.getFirst()) == '#') {
			drawSnake();
			mPanel.printPanel();
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

	public void move(Direction direction, int steps) {
		// snake move downward 4 point
		for (int i = 0; i < steps; i++) {
			snakeMove(direction);
			drawSnake();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mPanel.printPanel();
		}
	}

	/**
	 * store the position of head and body of snake in the Linkedlist
	 */
	private void initialize(LinkedList<Point> body, int length, int posX, int posY) {
		// ToDo: Check if the length is bigger than width and height.
		// Initialize by a default value if not.

		Point head = new Point(posX, posY);
		body.addLast(head);
		for (int i = 1; i < length; i++) {
			body.addLast(new Point(head.getX() - i, head.getY()));
		}
	}

}