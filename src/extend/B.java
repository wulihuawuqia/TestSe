/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年12月20日 上午11:13:48
* 创建作者：伍恰
* 文件名称：B.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package extend;

public class B extends A {

    private String b = "b";

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String show(B obj) {
        return "B and B";
    }
    
    public String show(A obj) {
        return "B and A";
    }

    public static void main(String[] args) {
        A b = new B();
        System.out.println(((B) b).getB());
		A a = (A) b;
        System.out.println(((B) a).getB());
    }
}
