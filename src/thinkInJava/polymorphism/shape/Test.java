package thinkInJava.polymorphism.shape;

public class Test {
	public static void main(String[] args) {
		Shape circl=new Circle();
		Shape square=new Square();
		Shape triangle=new Triangle();
		Shape shape=new Shape();
		circl.draw();
		square.draw();
		((Square)square).eraseOther();
		//((Square)circl).eraseOther(); java.lang.ClassCastException: 
		triangle.draw();
		shape.draw();
	}
	@org.junit.Test
	public void suiji(){
		//创建随机选择
		RandomShapeGenerator rand=new RandomShapeGenerator();
		//数组
		Shape [] shapes=new Shape [9];
		//数组初始化
		for(int i=0;i<9;i++){
			shapes[i]=rand.next();
		}
		//显示
		for(int i=0;i<9;i++){
			shapes[i].draw();
		}
	}
}
