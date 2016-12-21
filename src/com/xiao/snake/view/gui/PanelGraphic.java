package com.xiao.snake.view.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.xiao.snake.entities.Mapp;

public class PanelGraphic extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4802952222127167572L;
	private Mapp mPanel;

	public PanelGraphic(Mapp panel) {
		mPanel = panel;
	}

	@Override
	public void paint(Graphics g) {
		for (int j = 0; j < mPanel.getHeight(); j++) {
			for (int i = 0; i < mPanel.getWidth(); i++) {
				switch (mPanel.getMark(i, j)) {
				case WALL:
					g.setColor(Color.GRAY);
					g.fill3DRect(20 * i, 20 * j, 20, 20, true);
					break;
				case FOOD:
					g.setColor(Color.GREEN);
					g.fill3DRect(20 * i, 20 * j, 20, 20, true);
					break;
				case SNAKE_HEAD:
					g.setColor(Color.RED);
					g.fill3DRect(20 * i, 20 * j, 20, 20, true);
					break;
				case SNAKE_BODY:
					g.setColor(Color.BLUE);
					g.fill3DRect(20 * i, 20 * j, 20, 20, true);
					break;
				default:
					break;
				}
			}
		}
	}
}
