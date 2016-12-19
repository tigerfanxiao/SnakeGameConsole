package com.xiao.snake.view.console;

public class Frame extends Panel {
	public static void makeBorder(Panel panel) {
		for (int i = 0; i < panel.getWidth(); i++) {
			panel.markPoint(i, 0, '*');
		}
	
		for (int j = 1; j < panel.getHeight() - 1; j++) {
			for (int i = 0; i < panel.getWidth(); i++) {
				if (i == 0 || i == panel.getWidth() -1) {
					panel.markPoint(i, j, '*');
				} else {
					panel.markPoint(i, j, ' ');
				}
			}
		}
		
		for (int i = 0; i < panel.getWidth(); i++) {
			panel.markPoint(i, panel.getHeight() - 1, '*');
		}
	}
}
