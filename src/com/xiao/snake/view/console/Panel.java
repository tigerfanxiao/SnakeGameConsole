package com.xiao.snake.view.console;

import com.xiao.snake.entities.Point;

public class Panel {
	public static int DEFAULT_HEIGHT = 10;
	public static int DEFAULT_WIDTH = 30;
	
	private int mWidth;// the width of panel
	private int mHeight;// the height of panel
	private char[][] mPanel;// initiate the instance of panel
	
	public Panel() {
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	public Panel(int width, int height) {
		if (width <= 0) {
			width = DEFAULT_WIDTH;
		}
		
		
		if (height <= 0) {
			height = DEFAULT_HEIGHT;
		}
		
		mWidth = width;
		mHeight = height;
		
		mPanel = new char[mWidth][mHeight];
	}

	/**
	 * Store the char mark on the point with coordinate (y, x) if there is a
	 * square of boarder, mark '*' if there is a food, mark Food.SYMBOL if there is a
	 * head of snake, mark '$' if there is a body of snake, mark '#'
	 * 
	 * @param y
	 *            is the height of coordinate
	 * @param x
	 *            is the width of coordinate
	 * @param mark
	 *            used to show on the panel
	 */
	public void markPoint(int x, int y, char mark) {
		mPanel[x][y] = mark;
	}

	/**
	 * overloaded method of changePoint(), with coordinate of Point
	 * 
	 * @param Point
	 *            p
	 * @param char
	 *            mark
	 */
	public void markPoint(Point p, char mark) {
		mPanel[p.getX()][p.getY()] = mark;
	}

	/**
	 * show the panel with all the marks on it
	 */
	public void printPanel() {
		for (int j = 0; j < mHeight; j++) {
			for (int i = 0; i < mWidth; i++) {
				System.out.print(mPanel[i][j]);
			}
			System.out.print("\r\n");
		}
	}

	/**
	 * get the mark on the position
	 * @param Point
	 * @return the mark stored on the point p
	 */
	public char getMark(Point p) {
		return mPanel[p.getX()][p.getY()];
	}
	public char getMark(int width, int height) {
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
	public char[][] getPanel() {
		return mPanel;
	}
}
