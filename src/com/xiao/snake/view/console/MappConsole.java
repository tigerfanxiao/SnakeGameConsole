package com.xiao.snake.view.console;

import com.xiao.snake.entities.Mapp;

public class MappConsole extends Mapp {
	public MappConsole() {
		super();
	}

	public MappConsole(int width, int height) {
		super(width, height);
	}

	/**
	 * show the panel with all the marks on it
	 */
	public void print() {
		for (int j = 0; j < mHeight; j++) {
			for (int i = 0; i < mWidth; i++) {
				System.out.print(MapElementFormatter.toChar((mPanel[i][j])));
			}
			System.out.print("\r\n");
		}
	}
}
