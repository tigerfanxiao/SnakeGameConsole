package com.xiao.snake.entities;

public class Frame extends Panel {
	
	public static void makeBoarder() {
		for(int i = 0; i < Panel.panel.length; i++) {
			for(int j = 0; j < Panel.panel[i].length; j++) {
				if((i == 0 || i == Panel.panel.length - 1) || (j == 0 || j == Panel.panel[i].length - 1)) {
					Panel.changePoint(i, j, '*');
				}else {
					Panel.changePoint(i, j, ' ');
				}
			}
		}
	}

}
