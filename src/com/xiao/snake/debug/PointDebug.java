package com.xiao.snake.debug;

import java.io.PrintStream;

import com.xiao.snake.entities.Point;

public class PointDebug {
	public static void print(Point point) {
		PointDebug.toString(System.out, point);
	}
	
	public static void toString(PrintStream printStream, Point point) {
		if (printStream == null || point == null) {
			// TODO log unexpected situation
			return;
		}
		
		printStream.println("Point [x=" + point.getX() + ", y=" + point.getY() + "]");
	}	
}
