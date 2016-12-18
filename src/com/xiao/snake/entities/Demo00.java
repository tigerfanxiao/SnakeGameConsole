package com.xiao.snake.entities;
/*
 * 这个项目有几个问题:
 * 1. 没有做蛇碰到边界退出的功能
 * 2. 没有写文档
 * 3. 没有用Junit对方法进行测试, 对不同的方法, 不同的情况进行测试
 * 4. 蛇的运动不允许向当前方向相反的方向走 
 * 5. 怎样写下一个任务next task?
 * 6. 总结整个设计过程
 * 7. 写英文的开发文档
 * 8. 写出那些开发难点
 * 9. 用Project来管理这个项目的开发
 * 10. 没有做蛇吃到自己尾巴的判断
 * 11.注意开发过程中架构师的作用, 设计多少个类, 类与类之间的关系, 方法之间的耦合
 * 类中有多少个成员, 多少个方法, 少一个成员可能很难实现方法, 如果把这些东西事先都设计好,
 * 将大大减少开发的难度和时间
 * 12. 使用什么工具来思考这些框架的东西, 用什么软件来画图, 建立这些类和方法之间的结构
 * 13. 怎样使自己的代码看上去像是工业化的代码
 * 14. 怎样用git工具来保存不同的开发版本, 比如对同一个方法的不同实现
 * 15. 这个项目还没有用Swing组件来实现, 也没有使用各种控件
 * 16. 以后的开发, 必然会用到各种前人已经定义好的方法, 我的工作可能是需要熟悉这些方法来创造自己的东西
 * 造一幢楼, 不可能自己建造砖头和水管
 * 17. 可以写一个接受键盘输入, 然后决定蛇往哪里走?
 * 18. 可以写一个配置文件, 将蛇的长度, 边框的大小, 边框用个符号, 舌头用的符号, 都放在配置文件中, 用IO来读取
 * 19. 可以用IO来输出蛇行走的路线的log文件, 用左边的方式打印出来, 又是否可以到处excel文件cvs格式呢?
 * 通过读取这个文件, 我又能不能绘制出蛇行走的路线呢?
 * 20. 必须要用图形化界面, 才能写监听器
 * 21. 如何用JavaScript来实现这个贪吃蛇的游戏, 在网页上又是如何实现监听器这个功能的?
 * 22. 如何用Android实现这个贪吃蛇的游戏
 * 23. 如何用Python来实现这个游戏
 * 24. 怎样在sublime中写java程序, 再把代码复制到word
 * 25. 
 * 
 * 
 * 
 * 测试代码1
 * 蛇的行走
 * 蛇的转向
 * 蛇不会向相反的方向转向
 * 蛇吃食物, 变长
 * 蛇碰到墙, 停止游戏
 * 蛇吃到自己的尾巴, 停止游戏
 * 在地图上随机生成食物, 但是不会出现在蛇的身上, 也不会出现在边框上
 * 
 */



public class Demo00 {
	public static void main(String[] args) throws InterruptedException {
//		Boarder00 boarder00 = new Boarder00();
		Food00 food00 = new Food00();
//		画出边界
		Boarder00.makeBoarder();
//		随机生成食物
		food00.showFood(food00.foodGenerate());
//		创蛇
		Snake00 snake00 = new Snake00();
//		蛇在初始位置
		snake00.initiateSnake();
		Panel.changePoint(5, 18, '@');
		Panel.changePoint(5, 20, '@');
		
		for(int i = 0; i < 5; i++) {
			snake00.snakeMove('R');
			snake00.drawSnake();
			Thread.sleep(500);
			Panel.printPanel();
		}
		
		for(int i = 0; i < 3; i++) {
			snake00.snakeMove('U');
			snake00.drawSnake();
			Thread.sleep(500);
			Panel.printPanel();
		}
		
		for(int i = 0; i < 3; i++) {
			snake00.snakeMove('L');
			snake00.drawSnake();
			Thread.sleep(500);
			Panel.printPanel();
		}
		
		for(int i = 0; i < 4; i++) {
			snake00.snakeMove('D');
			snake00.drawSnake();
			Thread.sleep(500);
			Panel.printPanel();
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
