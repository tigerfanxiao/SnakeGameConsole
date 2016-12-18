package com.xiao.snake.view.console;

import com.xiao.snake.entities.Point;

public class Panel {
	//
	private final int width = 30;
	private final int height = 10;
	private char[][] mPanel = new char[height][width];
	
	
	// TODO: 
	/**
	 * method changePoint
	 * to store the char mark on the point with coordinate (y, x)
	 * if there is a square of boarder, mark '*'
	 * if there is a food, mark '@'
	 * if there is a head of snake, mark '$'
	 * if there is a body of snake, mark '#'
	 * @param y is the height of coordinate
	 * @param x is the width of coordinate
	 * @param mark
	 */
	public void changePoint(int y, int x, char mark) {
		mPanel[y][x] = mark;
	}
	
	// TODO: Please document this properly
	/**
	 * overloaded method of changePoint(), with coordinate of Point 
	 * @param Point p
	 * @param char mark
	 */
	public void changePoint(Point p, char mark) {
		mPanel[p.getY()][p.getX()] = mark;
	}
	
	// TODO: Please document this properly
	/**
	 * show the panel with all the marks on it
	 */
	public void printPanel() {
		for(int i = 0; i < mPanel.length; i++) {
			for(int j = 0; j< mPanel[i].length; j++) {
				System.out.print(mPanel[i][j]);
			}
			System.out.print("\r\n");
		}
	}
	
	//get the mark of the position
	// TODO: Please document this properly
	/**
	 * 
	 * @param Point
	 * @return the mark stored on the point p
	 */
	public  char getMark(Point p) {
		return mPanel[p.getY()][p.getX()];
	}
	/**
	 * 
	 * @return width of panel
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * 
	 * @return height of panel
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * @return an instance of panel
	 */
	public char[][] getPanel() {
		return mPanel;
	}
}
