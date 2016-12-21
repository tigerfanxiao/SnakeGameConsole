package com.xiao.snake.entities;

import com.xiao.snake.view.console.Frame;

public class Game {
	private Mapp mMapp;
	private Snake mSnake;

	public Game() {
		this(new Mapp());
	}

	public Game(Mapp panel) {
		if (panel == null) {
			panel = new Mapp();
			// TODO: LOG that it has been initialized with default values
		}

		mMapp = panel;

		this.initialize(mMapp);

	}

	public Mapp getMapp() {
		return mMapp;
	}

	public Snake getSnake() {
		return mSnake;
	}

	private void initialize(Mapp mapp) {
		// �����߽�
		Frame.makeBorder(mapp);

		// �������ʳ��
		mapp.setMark(mapp.getEmptyRandomInnerPoint(), MapElement.FOOD);

		// ����
		mSnake = new Snake(mapp.getMiddle());
	}
}
