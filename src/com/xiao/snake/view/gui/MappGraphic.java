package com.xiao.snake.view.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.xiao.snake.view.console.MappConsole;

public class MappGraphic extends MappConsole {
	private JPanel mJPanel = new JPanel() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		// @Override
		public void paint(Graphics g) {
			// Graphics g = mJPanel.getGraphics();
			for (int j = 0; j < mHeight; j++) {
				for (int i = 0; i < mWidth; i++) {
					switch (mPanel[i][j]) {
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
	};
	private JFrame mJFrame;

	public MappGraphic() {
		super();
	}

	public MappGraphic(int width, int height) {
		super(width, height);

		// TODO MMZ2 i18n Move title to strings.xml
		mJFrame = new JFrame("Snake");

		mJFrame.add(mJPanel);

		frameInit(mJFrame, width * 20, (height + 1) * 20);
		mJPanel.setVisible(true);
		mJFrame.setVisible(true);

	}

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
}
