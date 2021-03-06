package com.xiao.snake.entities;

import com.xiao.snake.entities.Mapp.MappElement;

public class Frame {
	/**
	 * show the boarder on the panel
	 * 
	 * @param panel
	 */
	public static void makeBorder(Mapp panel) {
		// mark the top line of boarder
		for (int i = 0; i < panel.getWidth(); i++) {
			panel.markPoint(i, 0, MappElement.WALL);
		}
		// mark the left and right column of the boarder
		for (int j = 1; j < panel.getHeight() - 1; j++) {
			for (int i = 0; i < panel.getWidth(); i++) {
				if (i == 0 || i == panel.getWidth() - 1) {
					panel.markPoint(i, j, MappElement.WALL);
				} else {
					panel.markPoint(i, j, MappElement.EMPTY);
				}
			}
		}
		// mark the bottom line of boarder
		for (int i = 0; i < panel.getWidth(); i++) {
			panel.markPoint(i, panel.getHeight() - 1, MappElement.WALL);
		}
	}

}
