package com.xiao.snake.view.console;

import com.xiao.snake.entities.Point;

public class Panel {

	private int mWidth;// the width of panel
	private int mHeight;// the height of panel
	private char[][] mPanel;// initiate the instance of panel
	
	public Panel() {
		super();
	}

	public Panel(int height, int width) {
		mWidth = width;
		mHeight = height;
		mPanel = new char[mHeight][mWidth];
	}

	/**
	 * Store the char mark on the point with coordinate (y, x) if there is a
	 * square of boarder, mark '*' if there is a food, mark '@' if there is a
	 * head of snake, mark '$' if there is a body of snake, mark '#'
	 * 
	 * @param y
	 *            is the height of coordinate
	 * @param x
	 *            is the width of coordinate
	 * @param mark
	 *            used to show on the panel
	 */
	public void markPoint(int y, int x, char mark) {
		mPanel[y][x] = mark;
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
		mPanel[p.getY()][p.getX()] = mark;
	}

	/**
	 * show the panel with all the marks on it
	 */
	public void printPanel() {
		for (int i = 0; i < mPanel.length; i++) {
			for (int j = 0; j < mPanel[i].length; j++) {
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
		return mPanel[p.getY()][p.getX()];
	}
	public char getMark(int height, int width) {
		return mPanel[height][width];
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
