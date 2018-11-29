/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月15日 下午2:40:28
* 创建作者：伍恰
* 文件名称：Turtle.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.string;

import java.io.PrintStream;
import java.util.Formatter;

public class Turtle {
    private String name;
    private Formatter f;
    public Turtle(String name,Formatter f){
        this.name = name;
        this.f = f;
    }
    public void move(int x , int y){
        f.format("%s The Turtle is at (%d,%d)\n", name,x,y);
    }
    public static void main(String[] args) {
        PrintStream outAlias = System.err;
        Turtle tommy = new Turtle("Tommy",
          new Formatter(System.out));
        Turtle terry = new Turtle("Terry",
          new Formatter(outAlias));
        tommy.move(0,0);
        terry.move(4,8);
        tommy.move(3,4);
        terry.move(2,5);
        tommy.move(3,3);
        terry.move(3,3);
    }
}
