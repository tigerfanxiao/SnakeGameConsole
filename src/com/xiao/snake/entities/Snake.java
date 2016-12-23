package com.xiao.snake.entities;

import java.util.LinkedList;

public class Snake {

	private static int DEFAULT_LENGTH = 4;// the default length of snake
	private int mLength;// the current length of snake
	private LinkedList<Point> mBody = new LinkedList<>(); // the body of the snake

	/**
	 * four direction snake moves in the mapp
	 * 
	 * @author Xiao
	 */
	public enum Direction {
		LEFT, RIGHT, UP, DOWN;
	}

	/**
	 * Constructor of snake with parameter of position of the head of the snake, at the beginning of the game
	 * 
	 * @param position
	 */
	public Snake(Point position) {
		this(position, DEFAULT_LENGTH);
	}

	/**
	 * Constructor of snake with two parameters: position of the head of snake and the length of snake
	 * 
	 * @param position
	 * @param length
	 */
	public Snake(Point position, int length) {
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

	/**
	 * @return the point of head
	 */
	public Point getHead() {
		return mBody.getFirst();
	}

	/**
	 * @return the list of points of body
	 */
	public LinkedList<Point> getBody() {
		return mBody;
	}

	/**
	 * Initialize the list of points of body of snake.
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