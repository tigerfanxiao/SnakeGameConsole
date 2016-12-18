package com.xiao.snake.entities;

public class Panel {
	static final int PANEL_WIDTH = 30;
	static final int PANEL_HEIGHT = 10;
	static char[][] panel = new char[PANEL_HEIGHT][PANEL_WIDTH];
	
	public Panel(){
	}
	//constructor with x and y
	public static void changePoint(int y, int x, char mark) {
		Panel.panel[y][x] = mark;
	}
	//constructor with point
	public static void changePoint(Point p, char mark) {
		Panel.panel[p.getY()][p.getX()] = mark;
	}
	
	public static void printPanel() {
		for(int i = 0; i < panel.length; i++) {
			for(int j = 0; j< panel[i].length; j++) {
				System.out.print(panel[i][j]);
			}
			System.out.print("\r\n");
		}
	}
	
	//get the mark of the position
	public static char getMark(Point p) {
		return Panel.panel[p.getY()][p.getX()];
	}
}
