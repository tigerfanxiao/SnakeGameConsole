package com.xiao.snake.debug;

import java.io.PrintStream;

import com.xiao.snake.entities.Snake;

public class SnakeDebug {
	public static void print(Snake snake) {
		SnakeDebug.print(System.out, snake);
	}
	
	public static void print(PrintStream printStream, Snake snake) {
		if (printStream == null || snake == null) {
			// TODO log unexpected situation
			return;
		}
		
		//printStream.println("Point [x=" + point.getX() + ", y=" + point.getY() + "]");
	}	

}
