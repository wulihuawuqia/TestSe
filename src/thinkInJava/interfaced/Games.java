package thinkInJava.interfaced;

import java.io.PrintWriter;

import sun.net.www.content.text.plain;

/**
 * 
* @ClassName: Games
* @Description: 工厂模式
* @author wuqia
* @date 2017年6月2日 下午8:11:33
*
 */
//定义接口
	interface Game{
		boolean move();
	}
	//定义工厂
	interface GameFactory{
		//获取对应的游戏
		Game getGame();
	}
	//创建国际象棋实现类
	class Checkers implements Game{
		private int moves=0;
		private static final int MOVES=3;
		@Override
		public boolean move() {
			// TODO Auto-generated method stub
			System.out.println(" Checkers move"+moves);
			return ++moves != MOVES;
		}
	}
	//创建国际象棋实现工厂
	class CheckersFactory implements GameFactory{
		@Override
		public Game getGame() {
			// TODO Auto-generated method stub
			return new Checkers();
		}
	}
	//创建象棋实现类
	class Chess implements Game{
		private int moves=0;
		private static final int MOVES=5;
		@Override
		public boolean move() {
			// TODO Auto-generated method stub
			System.out.println("Chess move"+moves);
			return ++moves != MOVES;
		}
	}
	//创建象棋工厂实现类
	class ChessFactory implements GameFactory{

		@Override
		public Game getGame() {
			// TODO Auto-generated method stub
			return new Chess();
		}
		
	}
public class Games {
	//定义玩游戏的方法
	public static void playGame(GameFactory factory){
		Game game=factory.getGame();
		while(game.move());
	}
	public static void main(String[] args) {
		//开始不同的游戏
		playGame(new CheckersFactory());
		playGame(new ChessFactory());
	}
}
