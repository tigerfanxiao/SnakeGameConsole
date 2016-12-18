package com.xiao.snake;

import com.xiao.snake.entities.Food;
import com.xiao.snake.entities.Snake;
import com.xiao.snake.view.console.Frame;
import com.xiao.snake.view.console.Panel;

public class Main {
	public static void main(String[] args) throws InterruptedException  {
		Panel panel = new Panel();

//		画出边界
		Frame.makeBorder(panel);
		
//		随机生成食物
		Food food = new Food(panel);

		food.showFood(food.foodGenerate());
//		创蛇
		Snake snake00 = new Snake();
//		蛇在初始位置
		snake00.initiateSnake();
		
		panel.changePoint(5, 18, '@');
		panel.changePoint(5, 20, '@');
		
		for(int i = 0; i < 5; i++) {
			snake00.snakeMove('R');
			snake00.drawSnake();
			Thread.sleep(500);
			panel.printPanel();
		}
		
		for(int i = 0; i < 3; i++) {
			snake00.snakeMove('U');
			snake00.drawSnake();
			Thread.sleep(500);
			panel.printPanel();
		}
		
		for(int i = 0; i < 3; i++) {
			snake00.snakeMove('L');
			snake00.drawSnake();
			Thread.sleep(500);
			panel.printPanel();
		}
		
		for(int i = 0; i < 4; i++) {
			snake00.snakeMove('D');
			snake00.drawSnake();
			Thread.sleep(500);
			panel.printPanel();
		}
//		
		
	
		
		
//		我的问题是什么?
//		现在静态保存的那个数组的走位是对的, 当蛇运动的时候, 数组中每一个点的符号都是对的, 问题是怎么打印这个数组的问题
//		需要用线程来控制蛇的运动, 比如每过1秒行动一步.
//		但是边框只能打印一次, 而不是蛇每移动一步就打印一次边框, 这样会生成多个边框
//		蛇的走位要打印多次, 这样才能有动画的效果, 
//		
//		现在的情况是,肯定需要打印多次, 但是怎样把蛇的走位每一次都那样在同一个边框里,
		
		
	}
}
