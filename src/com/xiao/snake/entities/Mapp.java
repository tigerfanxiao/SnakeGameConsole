package com.xiao.snake.entities;

import java.util.concurrent.ThreadLocalRandom;

public class Mapp {
	protected int mWidth;// the width of panel
	protected int mHeight;// the height of panel
	protected MappElement[][] mPanel;// initiate the instance of panel

	public static int DEFAULT_HEIGHT = 10;
	public static int DEFAULT_WIDTH = 30;

	public enum MappElement {
		FOOD, WALL, SNAKE_BODY, SNAKE_HEAD, EMPTY
	}

	public Mapp() {
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	public Mapp(int width, int height) {
		if (width <= 0) {
			width = DEFAULT_WIDTH;
		}

		if (height <= 0) {
			height = DEFAULT_HEIGHT;
		}

		mWidth = width;
		mHeight = height;

		mPanel = new MappElement[mWidth][mHeight];
	}

	/**
	 * Store the char mark on the point with coordinate (y, x) if there is a square of boarder, mark '*' if there is a
	 * food, mark Food.SYMBOL if there is a head of snake, mark '$' if there is a body of snake, mark '#'
	 * 
	 * @param y
	 *            is the height of coordinate
	 * @param x
	 *            is the width of coordinate
	 * @param mapElement
	 *            used to show on the panel
	 */
	public void markPoint(int x, int y, MappElement mapElement) {
		mPanel[x][y] = mapElement;
	}

	/**
	 * overloaded method of markPoint(), with coordinate of Point
	 * 
	 * @param Point
	 *            p
	 * @param char
	 *            mark
	 */
	public void setMark(Point p, MappElement mark) {
		mPanel[p.getX()][p.getY()] = mark;
	}

	/**
	 * get the mark on the position
	 * 
	 * @param Point
	 * @return the mark stored on the point p
	 */
	public MappElement getMark(Point p) {
		return mPanel[p.getX()][p.getY()];
	}

	public MappElement getMark(int width, int height) {
		return mPanel[width][height];
	}

	/**
	 * @return width of panel
	 */
	public int getWidth() {
		return mWidth;
	}

	/**
	 * @return height of panel
	 */
	public int getHeight() {
		return mHeight;
	}

	/**
	 * @return an instance of panel
	 */
	public MappElement[][] getPanel() {
		return mPanel;
	}

	/**
	 * Generates a ramdom inner point
	 * 
	 * @return coordinate of point of food with (height, width)
	 */
	public Point getEmptyRandomInnerPoint() {
		Point result = null;

		boolean notEmptyPointFound = true;
		do {
			// empty spaces can not be on the border: width - 2,
			// the range from 1: so plus 1

			int x = ThreadLocalRandom.current().nextInt(1, getWidth() - 2);
			int y = ThreadLocalRandom.current().nextInt(1, getHeight() - 2);

			if (getMark(x, y) == MappElement.EMPTY) {
				result = new Point(x, y);
				notEmptyPointFound = false;
			}
		} while (notEmptyPointFound);

		return result;
	}

	/**
	 * return the middle point of the panel
	 * 
	 * @return
	 */
	public Point getMiddle() {
		return new Point(getWidth() / 2, getHeight() / 2);
	}
}
