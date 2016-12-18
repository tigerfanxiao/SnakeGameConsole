package com.xiao.snake.entities;

import java.util.Iterator;
import java.util.LinkedList;

import com.xiao.snake.view.console.Panel;

public class Snake extends Panel {
	//the coordinate where initiate a snake on panel
	int beginWidth = getWidth() / 2;
	int beginHeight = getHeight() / 2;
	int lengthOfSnake = 4; //the length of snake
	char direction;
	Point head = new Point(beginHeight, beginWidth);
	//the coordinate of the position of snake is stored in a linkedlist
	LinkedList<Point> snake = new LinkedList<>();

	/**
	 * initiate the instance of snake and show it on the panel with coordinate
	 */
	public void initiateSnake() {
		//画出蛇的初始位置
		snake.addLast(head);
		for(int i = 1; i < lengthOfSnake; i++) {
			snake.addLast(new Point(head.getY(), head.getX() - i));
		}
	}
	/**
	 * store the mark of head and body of the snake with the coordinate list of snake
	 */
	public void drawSnake() {
		Iterator<Point> snakeIterator = snake.iterator();
		while(snakeIterator.hasNext()) {
			changePoint(snakeIterator.next(), '#');
		}
		changePoint(snake.getFirst(), '$'); //最后画头, 把第一个覆盖为$
	}
	
/*
 * 蛇向上下左右四个方向移动
 * 遇到食物@, 蛇身边长
 * 
 * 问题: 这个方法内部定义了2个方向, 一个是无干扰下的下一个节点位置, 一个是键盘给出的下一个节点位置
 * 其实, 可以在snake类中设置两个成员变量, 保存当前蛇的方向状态, 和键盘要改变的状态, 分别用 +1 -1, +2, -2 表示4个方向
 */
/**
 * 
 * @param char direction
 */
	public void snakeMove(char direction) {
		//nextHeadOrinigal 指在无外界干扰的情况下, 蛇头出现的下一个结点的位置
		Point nextHeadOriginal = snakeDirection();
		//nextHeadFromKey 指在键盘接收到的指定下一个结点的位置
		Point nextHeadFromKey = snakeDirection();
		switch(direction) {
		case 'U':
			nextHeadFromKey = new Point(snake.getFirst().getY() - 1, snake.getFirst().getX());
			break;
		case 'D':
			nextHeadFromKey = new Point(snake.getFirst().getY() + 1, snake.getFirst().getX());
			break;
		case 'L':
			nextHeadFromKey = new Point(snake.getFirst().getY(), snake.getFirst().getX() - 1);
			break;
		case 'R':
			nextHeadFromKey = new Point(snake.getFirst().getY(), snake.getFirst().getX() + 1);
			break;
		default:
			break;
		}
//		如果键盘接收到的方向和无干扰的方向相反, 则会出现 (x+1, y), (x-1, y) 或 (x, y-1), (x, y + 1)的情况, 两点之间的距离会大于等于2, 这种情况下忽略键盘的方向
		if(Math.abs(nextHeadOriginal.getX()-nextHeadFromKey.getX()) <= 1 && Math.abs(nextHeadOriginal.getY() - nextHeadFromKey.getY()) <= 1) {
			snake.addFirst(nextHeadFromKey);			
		}else {
			snake.addFirst(nextHeadOriginal);			
		}
//		默认情况下, 新增一个头结点就要抹去最后一个尾巴结点, 但是如果遇到食物@, 就不抹去最后一个结点, 使得蛇的身体增长
		if(getMark(snake.getFirst()) != '@') {
			changePoint(snake.removeLast(), ' ');
		}
		//如果遇到石头,就弹出Game over 退出虚拟机
		if(getMark(snake.getFirst()) == '*' || getMark(snake.getFirst()) == '#') {
			drawSnake();
			printPanel();
			System.out.println("Game Over!");
			System.exit(0);
		}
		
//		出现了问题: 在没有外力控制下的下一个节点怎么算, 蛇应该有一个初始的运动方向, 这个运动方向应该由第一个节点和第二个节点的关系决定
//		如果第一个节点和第二个节点在同一个水平面上(y坐标相等), 则根据x坐标相减, 如果为正则蛇向右方前进,否则向左前进
//		同理如果第一个节点和第二个节点在同一个垂直面上, 则根据y坐标相减, 如果为正则蛇向下方前进, 否则向上方前进
		
	}
//	判断蛇的前进方向, 将自然情况下, 蛇头的下一个节点保存在nextPoint中
	/**
	 * 
	 * @return the next point where the head of snake would show if no command of changing direction 
	 */
	public Point snakeDirection() {
		Point nextPoint;
		if(snake.get(0).getY() == snake.get(1).getY()) {
			nextPoint = new Point(snake.get(0).getY(), 2 * snake.get(0).getX() - snake.get(1).getX());
		}else {
			nextPoint = new Point(2 * snake.get(0).getY() - snake.get(1).getY(), snake.get(0).getX());
		}
		return nextPoint;
	}
}