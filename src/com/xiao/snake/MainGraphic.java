package com.xiao.snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Logger;

import javax.swing.JFrame;

import com.xiao.snake.entities.EndGameException;
import com.xiao.snake.entities.Game;
import com.xiao.snake.entities.Snake;
import com.xiao.snake.entities.Snake.Direction;
import com.xiao.snake.view.gui.MappGraphic;

public class MainGraphic {
	// TODO MMZ2 Being able to read logging configuration from file
	private final static Logger logger = Logger.getLogger(MainGraphic.class.getName());

	public static void main(String args[]) {
		logger.info("Prueba");

		MappGraphic mapp = new MappGraphic(40, 20);
		Game game = new Game(mapp);

		Snake snake = game.getSnake();

		// Move the snake around the screen
		// try {
		// game.move(snake, Direction.UP, 1);
		// game.move(snake, Direction.LEFT, 5);
		// game.move(snake, Direction.DOWN, 1);
		// game.move(snake, Direction.LEFT, 3);
		// } catch (EndGameException e) {
		// // TODO MMZ2 i18n
		// System.out.println("Game Over!");
		// }

		/**
		 * use keyboard to control the move of snake
		 */
		// TODO MMZ See how to include in our current approach
		// TODO: Eliminar getFrame y buscar otro enfoque
		JFrame frame = mapp.getFrame();
		frame.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

				int direction = e.getKeyCode();

				try {
					switch (direction) {
					case KeyEvent.VK_UP:
						game.move(snake, Direction.UP, 1);
						break;
					case KeyEvent.VK_DOWN:
						game.move(snake, Direction.DOWN, 1);
						break;
					case KeyEvent.VK_LEFT:
						game.move(snake, Direction.LEFT, 1);
						break;
					case KeyEvent.VK_RIGHT:
						game.move(snake, Direction.RIGHT, 1);
						break;
					default:
						break;
					}
				} catch (EndGameException exception) {
					// TODO: Send Game over event
				}

				// TODO MMZ2 See usage and remove
				// snake.drawSnake(mapp);
				frame.repaint();
			}
		});
	}
}
