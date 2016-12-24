package com.xiao.snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Iterator;

import javax.swing.JFrame;

import com.xiao.snake.entities.EndGameException;
import com.xiao.snake.entities.Frame;
import com.xiao.snake.entities.Mapp;
import com.xiao.snake.entities.Mapp.MappElement;
import com.xiao.snake.entities.Point;
import com.xiao.snake.entities.Snake;
import com.xiao.snake.entities.Snake.Direction;
import com.xiao.snake.view.gui.MappPanel;

public class Game {
	private Mapp mMapp;
	private MappPanel mMappPanel;

	private Snake mSnake;
	private GameKeyListener mGameKeyListener;

	public Game(Mapp mapp) {
		if (mapp == null) {
			mapp = new Mapp();
			// TODO Xiao Log: Default values used
		}

		mMapp = mapp;

		this.initialize(mMapp);
	}

	public Game(int width, int height) {
		this(new Mapp(width, height));

		mMappPanel = new MappPanel(mMapp);
	}

	public Mapp getMapp() {
		return mMapp;
	}

	public Snake getSnake() {
		return mSnake;
	}

	public void start() {
		/**
		 * use keyboard to control the move of snake
		 */
		JFrame frame = mMappPanel.getFrame();

		mGameKeyListener = new GameKeyListener();
		frame.addKeyListener(mGameKeyListener);

		while (true) {
			try {
				move(getSnake(), getSnake().getDirection(), 1);
				mMappPanel.getFrame().repaint();
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (EndGameException exception) {
				mMappPanel.getFrame().removeKeyListener(mGameKeyListener);
				break;
			}
		}
	}

	public void move(Snake snake, Direction direction, int steps) throws EndGameException {
		// snake move downward 4 point
		for (int i = 0; i < steps; i++) {
			snake.move(direction);

			// If the snake touch the BORDER or eat its own body, Game Over.
			if (mMapp.getMark(snake.getHead()) == MappElement.WALL
					|| mMapp.getMark(snake.getHead()) == MappElement.SNAKE_BODY) {
				throw new EndGameException();
			}

			// If the head of the snake is in an empty space, remove last element within the snake's tail
			if (mMapp.getMark(snake.getHead()) == MappElement.EMPTY) {
				mMapp.setMark(snake.getBody().removeLast(), MappElement.EMPTY);
			}

			draw(snake);
		}
	}

	/**
	 * @param mapp
	 */
	private void initialize(Mapp mapp) {
		// mark wall on the panel
		Frame.makeBorder(mapp);

		// mark food on the panel
		mapp.setMark(mapp.getEmptyRandomInnerPoint(), MappElement.FOOD);

		//
		mSnake = new Snake(mapp.getMiddle());
	}

	/**
	 * mark of head and body of the snake on the panel
	 * 
	 * @param snake
	 */
	private void draw(Snake snake) {
		Iterator<Point> snakeIterator = snake.getBody().iterator();
		while (snakeIterator.hasNext()) {
			mMapp.setMark(snakeIterator.next(), MappElement.SNAKE_BODY);
		}

		// store the mark of head
		mMapp.setMark(snake.getHead(), MappElement.SNAKE_HEAD);
	}

	private class GameKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {

			int direction = e.getKeyCode();
			switch (direction) {
			case KeyEvent.VK_UP:
				getSnake().move(Direction.UP);
				break;
			case KeyEvent.VK_DOWN:
				getSnake().move(Direction.DOWN);
				break;
			case KeyEvent.VK_LEFT:
				getSnake().move(Direction.LEFT);
				break;
			case KeyEvent.VK_RIGHT:
				getSnake().move(Direction.RIGHT);
				break;
			default:
				break;
			}
			mMappPanel.getFrame().repaint();

		}
	}
}
