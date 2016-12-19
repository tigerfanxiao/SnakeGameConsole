package com.xiao.snake.entities;

import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.LinkedList;

import com.xiao.snake.view.console.Panel;


public class SnakeGraphic {
	private Panel mPanel;
	public SnakeGraphic (Panel panel) {
		mPanel = panel;
	}
	
	int lengthOfSnake = 4; // the length of snake
	// the position of head of the snake
	// initiate an instance of snake, the position of snake is stored in a Linkedlist
	LinkedList<Point> snake = new LinkedList<>();
	
	/**
	 * store the position of head and body of snake in the Linkedlist
	 */
	public void initiateSnake() {
		Point head = new Point(mPanel.getHeight() / 2, mPanel.getWidth() / 2);
		snake.addLast(head);
		for (int i = 1; i < lengthOfSnake; i++) {
			snake.addLast(new Point(head.getY(), head.getX() - i));
		}
	}

	/**
	 * store the mark of head and body of the snake on the panel
	 */
	public void drawSnake() {
		Iterator<Point> snakeIterator = snake.iterator();
		while (snakeIterator.hasNext()) {
			mPanel.markPoint(snakeIterator.next(), '#');
		}
		mPanel.markPoint(snake.getFirst(), '$'); // store the mark of head with char $
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
	char direction;
	public void snakeMove(KeyEvent e) {
		// nextHeadCurrentDirction store the next position of head of snake, if the
		// snake keep the current of direction
		Point nextHeadCurrentDirection = snakeDirection();
		// nextHeadChangeDirection store the next position of head of snake, if receive a
		// command of changing direction from keyboard
		Point nextHeadChangeDirection = snakeDirection();
		
		int direction = e.getKeyCode(); 
		switch (direction) {
		case KeyEvent.VK_UP:
			nextHeadChangeDirection = new Point(snake.getFirst().getY() - 1, snake.getFirst().getX());
			break;
		case KeyEvent.VK_DOWN:
			nextHeadChangeDirection = new Point(snake.getFirst().getY() + 1, snake.getFirst().getX());
			break;
		case KeyEvent.VK_LEFT:
			nextHeadChangeDirection = new Point(snake.getFirst().getY(), snake.getFirst().getX() - 1);
			break;
		case KeyEvent.VK_RIGHT:
			nextHeadChangeDirection = new Point(snake.getFirst().getY(), snake.getFirst().getX() + 1);
			break;
		default:
			break;
		}
		// If receive the command of changing direction, the snake will change direction, otherwise will keep 
		// the current direction
		if (Math.abs(nextHeadCurrentDirection.getX() - nextHeadChangeDirection.getX()) <= 1
				&& Math.abs(nextHeadCurrentDirection.getY() - nextHeadChangeDirection.getY()) <= 1) {
			snake.addFirst(nextHeadChangeDirection);
		} else {
			snake.addFirst(nextHeadCurrentDirection);
		}
		// if the snake eat the food, the length of its body will enlarge with one unit. 
		if (mPanel.getMark(snake.getFirst()) != '@') {
			mPanel.markPoint(snake.removeLast(), ' ');
		}
		// If the snake touch the boarder or eat its own body, Game Over, the thread exits JVM
		if (mPanel.getMark(snake.getFirst()) == '*' || mPanel.getMark(snake.getFirst()) == '#') {
			drawSnake();
			mPanel.printPanel();
			System.out.println("Game Over!");
			System.exit(0);
		}
	}

	/**
	 * @return the next point where the head of snake would show if no command
	 *         of changing direction
	 */
	public Point snakeDirection() {
		Point nextPoint;
		if (snake.get(0).getY() == snake.get(1).getY()) {
			nextPoint = new Point(snake.get(0).getY(), 2 * snake.get(0).getX() - snake.get(1).getX());
		} else {
			nextPoint = new Point(2 * snake.get(0).getY() - snake.get(1).getY(), snake.get(0).getX());
		}
		return nextPoint;
	}
	
}
