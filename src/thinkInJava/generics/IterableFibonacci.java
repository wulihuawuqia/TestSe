/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月22日 下午7:59:24
* 创建作者：伍恰
* 文件名称：IterableFibonacci.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.generics;

import java.util.Iterator;

public class IterableFibonacci extends Fibonacci implements Iterable<Integer>{
    private int n = 0;
    public IterableFibonacci(int count){
        n = count;
    }
    @Override
    public Iterator<Integer> iterator() {
        // TODO Auto-generated method stub
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                // TODO Auto-generated method stub
                return n > 0;
            }
            @Override
            public Integer next() {
                // TODO Auto-generated method stub
                n--;
                return IterableFibonacci.this.next();
            }
        };
    }
    public static void main(String[] args) {
        for(int i : new IterableFibonacci(18)){
            System.out.println(i);
        }
    }
}
