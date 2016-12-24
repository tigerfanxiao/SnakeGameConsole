package com.xiao.snake.view.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.xiao.snake.entities.Mapp;

public class MappPanel extends JPanel {
	private Mapp mMapp;
	private JFrame mJFrame;

	public MappPanel(Mapp mapp) {
		super();
		mMapp = mapp;

		// TODO Xiao i18n Move title to strings.xml
		mJFrame = new JFrame("Snake");

		mJFrame.add(this);

		frameInit(mJFrame, mMapp.getWidth() * 20, (mMapp.getHeight() + 1) * 20);
		this.setVisible(true);
		mJFrame.setVisible(true);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// @Override
	public void paint(Graphics g) {
		// Graphics g = mJPanel.getGraphics();
		for (int j = 0; j < mMapp.getHeight(); j++) {
			for (int i = 0; i < mMapp.getWidth(); i++) {
				switch (mMapp.getPanel()[i][j]) {
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
	};

	/**
	 * show window at the center of Screen
	 * 
	 * @param jframe
	 * @param height
	 * @param width
	 */
	private static void frameInit(JFrame jframe, int width, int height) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension d = toolkit.getScreenSize();
		double screenWidth = d.getWidth();
		double screenHeight = d.getHeight();

		jframe.setBounds((int) (screenWidth - width) / 2, (int) (screenHeight - height) / 2, width, height);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JFrame getFrame() {
		return mJFrame;

	}

	public Mapp getMapp() {
		return mMapp;
	}
}
