package com.xiao.snake;

import java.util.logging.Logger;

public class Main {
	// TODO Xiao Being able to read logging configuration from file
	private final static Logger logger = Logger.getLogger(Main.class.getName());

	public static void main(String args[]) {
		logger.info("Prueba");

		Game game = new Game(40, 20);

		game.start();
	}
}
