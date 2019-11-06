package api;

public class FinallyTest {
    public static String test(){
        try {
            System.out.println("try block");
            System.out.println(1/0);
            return test1();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            //return "Exception";
            throw e;
        } finally {
            System.out.println("finally block");
            return test1();
        }
    }
    public static String test1(){
        System.out.println("return statement");
        return "after return";
    }
	public static void main(String[] args) {
		try {
		    System.out.println(test());
			System.out.println(1/0);
			System.out.println(2);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally {
			System.out.println("finally");
			//return ;
		}
	}
}
