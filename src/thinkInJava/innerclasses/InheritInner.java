package thinkInJava.innerclasses;
class WithInner{
	class Inner{
		
	}
}
public class InheritInner extends WithInner.Inner{
	//No enclosing instance of type WithInner is available due to some intermediate constructor invocation
	/*public InheritInner() {
		// TODO Auto-generated constructor stub
	}*/
	public InheritInner(WithInner wi) {
		// TODO Auto-generated constructor stub
		wi.super();
	}
	public static void main(String[] args) {
		WithInner wi = new WithInner();
		InheritInner ii = new InheritInner(wi);
		
	}
}
