package com.xiao.snake.entities;
/**
 * class of coordinate of each point on he panel
 * @author Xiao
 *
 */
public class Point {
	private int height;
	private int width;
	
	public Point() {};
	public Point(int height, int width) {
		this.height = height;
		this.width = width;
	}
	public int getX() {
		return width;
	}
	public void setX(int width) {
		this.width = width;
	}
	public int getY() {
		return height;
	}
	public void setY(int height) {
		this.height = height;
	}
	@Override
	public String toString() {
		return "Point [height=" + height + ", width=" + width + "]";
	}
	
}
