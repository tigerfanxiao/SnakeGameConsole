package com.xiao.snake.view.console;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

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
	}
}
