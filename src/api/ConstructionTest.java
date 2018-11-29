/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月28日 上午10:04:16
* 创建作者：伍恰
* 文件名称：ConstructionTest.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package api;

public class ConstructionTest {
    public static void main(String[] args) {
        System.out.println(new B().getValue());
    }
    static class A {
        protected int value;
        public A(int v) {
            // TODO Auto-generated constructor stub
            setValue(v);
        }
        public void setValue(int v){
            value = v;
        }
        public int getValue(){
            try {
                value ++;
                return value;
            } finally {
                // TODO: handle finally clause
                this.setValue(value);
                System.out.println(value);
            }
        }
    }
    static class B extends A{
        public B() {
            // TODO Auto-generated constructor stub
            super(5);
            setValue(getValue() - 3);
        }
        public void setValue(int v){
            super.setValue(2 * v);
        }
    }
}
