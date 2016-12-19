package com.xiao.snake.debug;

import com.xiao.snake.view.console.Panel;
import java.io.PrintStream;

public class PanelDebug {
	public static void print(Panel panel) {
		PanelDebug.print(System.out, panel);
	}
	
	public static void print(PrintStream printStream, Panel panel) {
		if (printStream == null || panel == null) {
			// TODO log unexpected situation
			return;
		}
		
		printStream.println("Panel [width=" + panel.getWidth() + ", height=" + panel.getHeight() + "]");
	}
}
