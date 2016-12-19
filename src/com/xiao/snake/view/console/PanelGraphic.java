package com.xiao.snake.view.console;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.xiao.snake.entities.Food;
import com.xiao.snake.entities.Snake;

public class PanelGraphic extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4802952222127167572L;
	private Panel mPanel;
	public PanelGraphic(Panel panel) {
		mPanel = panel;
	}
	@Override
	public void paint(Graphics g) {
		for (int j = 0; j < mPanel.getHeight(); j++ ) {
			for (int i = 0; i < mPanel.getWidth(); i++) {				
				switch (mPanel.getMark(j, i)) {
				case '*':
					g.setColor(Color.GRAY);
					g.fill3DRect(20 * i, 20 * j, 20, 20, true);
					break;
				case '@':
					g.setColor(Color.GREEN);
					g.fill3DRect(20 * i, 20 * j, 20, 20, true);
					break;
				case '$':
					g.setColor(Color.RED);
					g.fill3DRect(20 * i, 20 * j, 20, 20, true);
					break;
				case '#':
					g.setColor(Color.BLUE);
					g.fill3DRect(20 * i, 20 * j, 20, 20, true);
					break;
				default:
					break;
				}
			}
		}
		g.setColor(Color.RED);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("Game Over", 250, 200);
		
	}
	
	public static void main(String args[]) throws InterruptedException {
		JFrame frame = new JFrame("Snake");
		Panel myPanel = new Panel(20, 30);
		Frame.makeBorder(myPanel);
		Food food = new Food(myPanel);
		food.showFood(food.foodGenerate());
		Snake snake = new Snake(myPanel);
		snake.initiateSnake();
		snake.drawSnake();
		
		PanelGraphic mPanelGraphic = new PanelGraphic(myPanel);
		frame.add(mPanelGraphic);
		
		FrameInitiation.FrameInit(frame, 20 * (myPanel.getHeight() + 1), 20 * myPanel.getWidth());	
		mPanelGraphic.setVisible(true);
		frame.setVisible(true);
		
		for (int i = 0; i < 5; i++) {
			snake.snakeMove('R');
			snake.drawSnake();
			Thread.sleep(500);
			mPanelGraphic.repaint();//repaint the snake
		}
		
//snake move upward 3 points
		for (int i = 0; i < 3; i++) {
			snake.snakeMove('U');
			snake.drawSnake();
			Thread.sleep(500);
			mPanelGraphic.repaint();
		}
		//snake move left 3 points
		for (int i = 0; i < 3; i++) {
			snake.snakeMove('L');
			snake.drawSnake();
			Thread.sleep(500);
			mPanelGraphic.repaint();
		}
		//snake move downward 4 point
		for (int i = 0; i < 4; i++) {
			snake.snakeMove('D');
			snake.drawSnake();
			Thread.sleep(500);
			mPanelGraphic.repaint();				
		}
		
	}
}
