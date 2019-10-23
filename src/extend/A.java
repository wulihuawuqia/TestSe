/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年12月20日 上午11:12:33
* 创建作者：伍恰
* 文件名称：A.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package extend;

public class A {
    private String a = "a";

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String show(D obj) {
        return "A and D";
    }
    
    public String show(A obj) {
        return "A and A";
    }
}
