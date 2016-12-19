package com.xiao.snake.entities;

import java.util.concurrent.ThreadLocalRandom;

import com.xiao.snake.view.console.Panel;

/**
 * create food with the char SYMBOL on the panel for snake to eat
 * 
 * @author Xiao
 *
 */
public class Food {
	public static char SYMBOL = '@';
	public static char EMPTY_SPACE = ' ';
	private Panel mPanel;

	public Food(Panel panel) {
		mPanel = panel;
	}

	/**
	 * Obtain the coordinate of point where food is generated on the grid of
	 * panel. the food could not be generated on the boarder of panel
	 * 
	 * @return coordinate of point of food with (height, width)
	 */
	private Point generateRandomly() {
		int x = ThreadLocalRandom.current().nextInt(1, mPanel.getWidth() - 2);// food
																				// can
																				// not
																				// be
																				// on
																				// the
																				// boarder:
																				// width
																				// -
																				// 2,
																				// the
																				// range
																				// from
																				// 1:
																				// so
																				// plus
																				// 1
		int y = ThreadLocalRandom.current().nextInt(1, mPanel.getHeight() - 2);

		return new Point(x, y);
	}

	// 这个函数有问题, 需要一个类用来传递两个坐标, 只要在坐标上没有字符, 就放食物, 如果坐标上有字符就重新生成一个食物

	/**
	 * show food as char SYMBOL on the coordinate of point on the panel, if
	 * there is no other mark on this point either.
	 * 
	 * @param point
	 *            where it is intended to generate food there
	 */
	public void showFood() {
		boolean emptySpaceFound = false;
		Point p;
		do {
			p = generateRandomly();
			if (mPanel.getPanel()[p.getX()][p.getY()] == EMPTY_SPACE) {
				mPanel.markPoint(p, SYMBOL);
				emptySpaceFound = true;
			}
		} while (!emptySpaceFound);
	}
}
