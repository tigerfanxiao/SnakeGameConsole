package com.xiao.snake.entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelGraphic extends JPanel{


	@Override
	public void paint(Graphics g) {
		g.setColor(Color.GRAY);
		
		
		
		
		
		g.fill3DRect(0, 0, 20, 20, true);
		
		
		
		
		g.setColor(Color.RED);
		g.setFont(new Font("ÀŒÃÂ", Font.BOLD, 20));
		g.drawString("Game Over", 350, 200);
		
	}
	
	public static void main(String args[]) {
		JFrame frame = new JFrame("≤‚ ‘");
		PanelGraphic panel = new PanelGraphic();
		frame.add(panel);
		panel.setVisible(true);
		FrameInitiation.FrameInit(frame, 500, 700);
		
	}
}
