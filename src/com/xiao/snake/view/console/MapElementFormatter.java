package com.xiao.snake.view.console;

import com.xiao.snake.entities.MapElement;

public class MapElementFormatter {
	public static char toChar(MapElement mapElement) {
		switch (mapElement) {
		case WALL:
			return '*';
		case FOOD:
			return '@';
		case SNAKE_BODY:
			return '#';
		case SNAKE_HEAD:
			return '$';
		default:
			// TODO: Add log. Unexpected error.
			return ' ';
		}
	}

}
