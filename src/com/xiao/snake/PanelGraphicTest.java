package com.xiao.snake;

import javax.swing.JFrame;

import com.xiao.snake.entities.MapElement;
import com.xiao.snake.entities.Mapp;
import com.xiao.snake.entities.Snake;
import com.xiao.snake.view.console.FrameConsole;
import com.xiao.snake.view.console.MappConsole;
import com.xiao.snake.view.gui.FrameInitiation;
import com.xiao.snake.view.gui.PanelGraphic;

public class PanelGraphicTest {

	public static void main(String args[]) throws InterruptedException {
		JFrame frame = new JFrame("Snake");
		Mapp mapp = new MappConsole(20, 30);
		FrameConsole.makeBorder(mapp);

		mapp.setMark(mapp.getEmptyRandomInnerPoint(), MapElement.FOOD);

		Snake snake = new Snake(mapp.getMiddle());
		// TODO MMZ2 See usage and remove
		// snake.drawSnake(mapp);

		PanelGraphic mPanelGraphic = new PanelGraphic(mapp);
		frame.add(mPanelGraphic);

		FrameInitiation.FrameInit(frame, 20 * (mapp.getHeight() + 1), 20 * mapp.getWidth());
		mPanelGraphic.setVisible(true);
		frame.setVisible(true);

		// TODO MMZ2 DO NOT FORGET.FIX IT
		// snake.move(mapp, Direction.RIGHT, 5);
		// snake.move(mapp, Direction.UP, 3);
		// snake.move(mapp, Direction.LEFT, 3);
		// snake.move(mapp, Direction.DOWN, 4);
	}

}
