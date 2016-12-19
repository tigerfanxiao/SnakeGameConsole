package com.xiao.snake.entities;
/**
 * class of coordinate of each point on the panel
 * @author Xiao
 *
 */
public class Point {
	private int mY;
	private int mX;
	
	public Point(int width, int height) {
		this.mX = width;
		this.mY = height;
	}
	
	public int getX() {
		return mX;
	}
	
	
	public int getY() {
		return mY;
	}
}
