package com.xiao.snake.view.gui;

import java.awt.event.KeyEvent;

import com.xiao.snake.entities.Mapp;
import com.xiao.snake.entities.Point;
import com.xiao.snake.entities.Snake;

public class SnakeGraphic extends Snake {
	private Mapp mMapp;

	public SnakeGraphic(Mapp mapp, Point position) {
		super(position);

		// TODO MMZ2 Rethink . Mapp should not be passed as a parameter
		// This is a consecuence of the design.
		mMapp = mapp;
	}

	/**
	 * Snake will change the moving direction if it is received the command of directions. If there is no command of
	 * changing direction or the direction is reverse the current direction, the snake will keep the current direction.
	 * Snake will have four moving direction: U for upward, D for downward, L for left, R for right. If the snake eat
	 * the food, its body will enlarge itself with one unit. If the snake touch the boarder, Game over, the thread exits
	 * JVM.
	 * 
	 * @param char
	 *            for direction
	 */
	public void snakeMove(KeyEvent e) {
		// TODO: MMZ DO NOT FORGET. FIX IT.
		//
		// int direction = e.getKeyCode();
		//
		// switch (direction) {
		// case KeyEvent.VK_UP:
		// snakeMove(mMapp, Direction.UP);
		// break;
		// case KeyEvent.VK_DOWN:
		// snakeMove(mMapp, Direction.DOWN);
		// break;
		// case KeyEvent.VK_LEFT:
		// snakeMove(mMapp, Direction.LEFT);
		// break;
		// case KeyEvent.VK_RIGHT:
		// snakeMove(mMapp, Direction.RIGHT);
		// break;
		// default:
		// break;
		// }
	}
}
