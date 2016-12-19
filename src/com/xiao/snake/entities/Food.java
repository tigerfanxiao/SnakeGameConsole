package com.xiao.snake.entities;

import java.util.Random;

import com.xiao.snake.view.console.Panel;

// TODO: create food with the char '@' on the panel for snake to eat
public class Food {
	private Panel mPanel;
	private int mX;
	private int mY;
	
	public Food (Panel panel) {
		mPanel = panel;
	}
	
	/**
	 * Obtain the coordinate of point where food is generated on the grid of panel.
	 * the food could not be generated on the boarder of panel
	 * @return coordinate of point of food with (height, width)
	 */
	public Point foodGenerate() {
		Random random = new Random();
		mX = random.nextInt(mPanel.getWidth() - 2) + 1;//food can not be on the boarder: width - 2, the range from 1: so plus 1
		mY = random.nextInt(mPanel.getHeight() - 2) + 1;
		return new Point(mY, mX);
	}
	
//	这个函数有问题, 需要一个类用来传递两个坐标, 只要在坐标上没有字符, 就放食物, 如果坐标上有字符就重新生成一个食物
	
	/**
	 * show food as char '@' on the coordinate of point on the panel, if there is no other mark on this point either.
	 * @param point where it is intended to generate food there
	 */
	public void showFood(Point p) {
		while(mPanel.getPanel()[p.getY()][p.getX()] == ' ') {
			mPanel.markPoint(p, '@');
			break;
		}
		
	}
}
