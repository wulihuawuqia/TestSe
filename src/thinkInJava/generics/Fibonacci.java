/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月22日 下午7:59:46
* 创建作者：伍恰
* 文件名称：Fibonacci.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.generics;

public class Fibonacci {
    private int count = 0;
    public Integer next(){
        return fib(count++);
    }
    public int fib(int n){
        if(n<2){
            return 1;
        }
        return fib(n-1)+fib(n-2); 
    }
    public static void main(String[] args) {
        Fibonacci gen = new Fibonacci();
        for(int i = 0; i < 18; i++){
            System.out.println(gen.next()+",");
        }
    }
}
