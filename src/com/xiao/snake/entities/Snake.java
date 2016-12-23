package com.xiao.snake.entities;

import java.util.LinkedList;

public class Snake {
	// TODO Xiao Add proper comments
	private static int DEFAULT_LENGTH = 4;
	private int mLength;
	private LinkedList<Point> mBody = new LinkedList<>(); // the body of the snake

	// TODO Xiao Add proper comments
	public enum Direction {
		LEFT, RIGHT, UP, DOWN;
	}

	// TODO Xiao Add proper comments
	public Snake(Point position) {
		this(position, DEFAULT_LENGTH);
	}

	// TODO Xiao Add proper comments
	public Snake(Point position, int length) {
		// TODO Xiao Check the length correctly. This is just an example
		if (length <= 0) {
			mLength = DEFAULT_LENGTH;
			// TODO Xiao Add a log to indicate that the length passed is incorrect
		} else {
			mLength = length;
		}

		this.initialize(mBody, mLength, position.getX(), position.getY());
	}

	/**
	 * Snake will change the moving direction if it is received the command of directions. If there is no command of
	 * changing direction or the direction is reverse the current direction, the snake will keep the current direction.
	 * Snake will have four moving direction: U for upward, D for downward, L for left, R for right. If the snake eat
	 * the food, its body will enlarge itself with one unit. If the snake touch the boarder, Game over, the thread exits
	 * JVM.
	 * 
	 * @param char
	 *            for direction
	 */
	public void move(Direction direction) {
		Point nextStep;
		switch (direction) {
		case UP:
			nextStep = new Point(getHead().getX(), getHead().getY() - 1);
			break;
		case DOWN:
			nextStep = new Point(getHead().getX(), getHead().getY() + 1);
			break;
		case LEFT:
			nextStep = new Point(getHead().getX() - 1, getHead().getY());
			break;
		case RIGHT:
			nextStep = new Point(getHead().getX() + 1, getHead().getY());
			break;
		default:
			// TODO Xiao: Unexpected situation. Log Error. This should not happen never.
			return;
		}

		mBody.addFirst(nextStep);
	}

	// TODO Xiao Add comments
	public Point getHead() {
		return mBody.getFirst();
	}

	// TODO Xiao Add comments
	public LinkedList<Point> getBody() {
		return mBody;
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

	/**
	 * @return the next point where the head of snake would show if no command of changing direction
	 */
	private Point calculateNextStepNoInteraction() {
		Point nextPoint;
		if (mBody.get(0).getY() == mBody.get(1).getY()) {
			// The snake is moving horizontally
			nextPoint = new Point(2 * mBody.get(0).getX() - mBody.get(1).getX(), mBody.get(0).getY());
		} else {
			nextPoint = new Point(mBody.get(0).getX(), 2 * mBody.get(0).getY() - mBody.get(1).getY());
		}

		return nextPoint;
	}

}