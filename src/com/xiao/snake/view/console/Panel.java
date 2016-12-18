package com.xiao.snake.view.console;

import com.xiao.snake.entities.Point;

public class Panel {
	private final int WIDTH = 30;
	private final int HEIGHT = 10;
	private char[][] mPanel = new char[HEIGHT][WIDTH];
	
	//constructor with x and y
	// TODO: Please document this properly
	public void changePoint(int y, int x, char mark) {
		mPanel[y][x] = mark;
	}
	//constructor with point
	// TODO: Please document this properly
	public void changePoint(Point p, char mark) {
		mPanel[p.getY()][p.getX()] = mark;
	}
	
	// TODO: Please document this properly
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
	public  char getMark(Point p) {
		return mPanel[p.getY()][p.getX()];
	}
	
	public int getWidth() {
		return WIDTH;
	}
	
	public int getHeight() {
		return HEIGHT;
	}
	
	public char[][] getPanel() {
		return mPanel;
	}
}
