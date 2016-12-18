package com.xiao.snake.view.console;

public class Frame extends Panel {
	public static void makeBorder(Panel panel) {
		for (int i = 0; i < panel.getPanel().length; i++) {
			for (int j = 0; j < panel.getPanel()[i].length; j++) {
				if ((i == 0 || i == panel.getPanel().length - 1) || 
						(j == 0 || j == panel.getPanel()[i].length - 1)) {
					panel.changePoint(i, j, '*');
				} else {
					panel.changePoint(i, j, ' ');
				}
			}
		}
	}

}
