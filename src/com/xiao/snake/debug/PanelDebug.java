package com.xiao.snake.debug;

import java.io.PrintStream;
import java.util.logging.Logger;

import com.xiao.snake.entities.Mapp;

public class PanelDebug {
	private final static Logger logger = Logger.getLogger(PanelDebug.class.getName());

	public static void print(Mapp panel) {
		PanelDebug.print(System.out, panel);
	}

	public static void print(PrintStream printStream, Mapp panel) {
		// Checks if input parameters are valid. Exiting if not
		if (printStream == null) {
			logger.severe("'printStream' must not be null.");
			return;
		}

		if (panel == null) {
			logger.severe("'panel' must not be null.");
		}

		// Prints panel values out
		printStream.println("Panel [width=" + panel.getWidth() + ", height=" + panel.getHeight() + "]");
	}
}
