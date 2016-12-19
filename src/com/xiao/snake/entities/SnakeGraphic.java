package com.xiao.snake.entities;

import java.awt.event.KeyEvent;

import com.xiao.snake.view.console.Panel;


public class SnakeGraphic extends Snake{
	public SnakeGraphic (Panel panel) {
		super(panel);
	}

	/**
	 * Snake will change the moving direction if it is received the command of directions.
	 * If there is no command of changing direction or the direction
	 * is reverse the current direction, the snake will keep the current direction. 
	 * Snake will have four moving direction: U for upward, D for downward, L for left, R for right. 
	 * If the snake eat the food, its body will enlarge itself with one unit. If the snake touch the boarder, Game over,
	 * the thread exits JVM.
	 * @param char for direction
	 */
	public void snakeMove(KeyEvent e) {
		int direction = e.getKeyCode();
		
		switch (direction) {
		case KeyEvent.VK_UP:
			snakeMove(Direction.UP);
			break;
		case KeyEvent.VK_DOWN:
			snakeMove(Direction.DOWN);
			break;
		case KeyEvent.VK_LEFT:
			snakeMove(Direction.LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			snakeMove(Direction.RIGHT);
			break;
		default:
			break;
		}
	}	
}
