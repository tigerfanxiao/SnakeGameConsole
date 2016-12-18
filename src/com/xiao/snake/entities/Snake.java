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
		//�����ߵĳ�ʼλ��
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
		changePoint(snake.getFirst(), '$'); //���ͷ, �ѵ�һ������Ϊ$
	}
	
/*
 * �������������ĸ������ƶ�
 * ����ʳ��@, ����߳�
 * 
 * ����: ��������ڲ�������2������, һ�����޸����µ���һ���ڵ�λ��, һ���Ǽ��̸�������һ���ڵ�λ��
 * ��ʵ, ������snake��������������Ա����, ���浱ǰ�ߵķ���״̬, �ͼ���Ҫ�ı��״̬, �ֱ��� +1 -1, +2, -2 ��ʾ4������
 */
/**
 * 
 * @param char direction
 */
	public void snakeMove(char direction) {
		//nextHeadOrinigal ָ���������ŵ������, ��ͷ���ֵ���һ������λ��
		Point nextHeadOriginal = snakeDirection();
		//nextHeadFromKey ָ�ڼ��̽��յ���ָ����һ������λ��
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
//		������̽��յ��ķ�����޸��ŵķ����෴, ������ (x+1, y), (x-1, y) �� (x, y-1), (x, y + 1)�����, ����֮��ľ������ڵ���2, ��������º��Լ��̵ķ���
		if(Math.abs(nextHeadOriginal.getX()-nextHeadFromKey.getX()) <= 1 && Math.abs(nextHeadOriginal.getY() - nextHeadFromKey.getY()) <= 1) {
			snake.addFirst(nextHeadFromKey);			
		}else {
			snake.addFirst(nextHeadOriginal);			
		}
//		Ĭ�������, ����һ��ͷ����ҪĨȥ���һ��β�ͽ��, �����������ʳ��@, �Ͳ�Ĩȥ���һ�����, ʹ���ߵ���������
		if(getMark(snake.getFirst()) != '@') {
			changePoint(snake.removeLast(), ' ');
		}
		//�������ʯͷ,�͵���Game over �˳������
		if(getMark(snake.getFirst()) == '*' || getMark(snake.getFirst()) == '#') {
			drawSnake();
			printPanel();
			System.out.println("Game Over!");
			System.exit(0);
		}
		
//		����������: ��û�����������µ���һ���ڵ���ô��, ��Ӧ����һ����ʼ���˶�����, ����˶�����Ӧ���ɵ�һ���ڵ�͵ڶ����ڵ�Ĺ�ϵ����
//		�����һ���ڵ�͵ڶ����ڵ���ͬһ��ˮƽ����(y�������), �����x�������, ���Ϊ���������ҷ�ǰ��,��������ǰ��
//		ͬ�������һ���ڵ�͵ڶ����ڵ���ͬһ����ֱ����, �����y�������, ���Ϊ���������·�ǰ��, �������Ϸ�ǰ��
		
	}
//	�ж��ߵ�ǰ������, ����Ȼ�����, ��ͷ����һ���ڵ㱣����nextPoint��
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