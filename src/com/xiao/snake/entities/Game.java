package com.xiao.snake.entities;

import com.xiao.snake.view.console.Frame;
import com.xiao.snake.view.console.Panel;

public class Game {
	private Panel mPanel;
	private Food mFood;
	private Snake mSnake;
	
	public Game() {
		this(new Panel());
	}
	
	public Game (Panel panel) {
		if (panel == null) {
			panel = new Panel();
			// TODO: LOG that it has been initialized with default values
		} 
		
		mPanel = panel;
		
		this.initialize(mPanel);

	}
	
	public Snake getSnake() {
		return mSnake;
	}
		
	private void initialize(Panel panel) {
		// 画出边界
		Frame.makeBorder(panel);

		// 随机生成食物
		mFood = new Food(panel);
		mFood.showFood();
		
		// 创蛇
		mSnake = new Snake(panel);
	}
}
