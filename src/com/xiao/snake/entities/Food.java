package com.xiao.snake.entities;

import java.util.Random;

import com.xiao.snake.view.console.Panel;

// TODO: Please document this properly
public class Food extends Panel {
	private Panel mPanel;
	private int mX;
	private int mY;
	
	public Food (Panel panel) {
		mPanel = panel;
	}
	
	public Point foodGenerate() {
		Random random = new Random();
		mX = random.nextInt(mPanel.getWidth() - 2) + 1;//food can not be on the boarder: width - 2, the range from 1: so plus 1
		mY = random.nextInt(mPanel.getHeight() - 2) + 1;
		return new Point(mY, mX);
	}
	
//	�������������, ��Ҫһ��������������������, ֻҪ��������û���ַ�, �ͷ�ʳ��, ������������ַ�����������һ��ʳ��
	public void showFood(Point p) {
		while(mPanel.getPanel()[p.getY()][p.getX()] == ' ') {
			mPanel.changePoint(p, '@');
			break;
		}
		
	}
}
