package com.xiao.snake.entities;

import java.util.Random;

public class Food extends Panel {
	
	int x;
	int y;
	
	public Point foodGenerate() {
		Random random = new Random();
		x = random.nextInt(Panel.PANEL_WIDTH - 2) + 1;//food can not be on the boarder: width - 2, the range from 1: so plus 1
		y = random.nextInt(Panel.PANEL_HEIGHT - 2) + 1;
		return new Point(y, x);
	}
	
//	�������������, ��Ҫһ��������������������, ֻҪ��������û���ַ�, �ͷ�ʳ��, ������������ַ�����������һ��ʳ��
	public void showFood(Point p) {
		while(Panel.panel[p.getY()][p.getX()] == ' ') {
			Panel.changePoint(p, '@');
			break;
		}
		
	}
}
