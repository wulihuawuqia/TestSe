/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月19日 下午4:56:23
* 创建作者：伍恰
* 文件名称：SnowRemovalRobot.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.typeInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SnowRemovalRobot implements Robot{
    private String name;
    public SnowRemovalRobot(String name) {
        // TODO Auto-generated constructor stub
        this.name = name;
    }
    @Override
    public String name() {
        // TODO Auto-generated method stub
        return this.name;
    }

    @Override
    public String model() {
        // TODO Auto-generated method stub
        return "SnowRemovalRobot 11 ";
    }

    @Override
    public List<Operation> operations() {
        // TODO Auto-generated method stub
        return Arrays.asList(
                new Operation() {
                    public String description() {
                      return name + " can shovel snow";
                    }
                    public void command() {
                      System.out.println(name + " shoveling snow");
                    }
                  },    
                  new Operation() {
                    public String description() {
                      return name + " can chip ice";
                    }
                    public void command() {
                      System.out.println(name + " chipping ice");
                    }
                  },
                  new Operation() {
                    public String description() {
                      return name + " can clear the roof";
                    }
                    public void command() {
                      System.out.println(name + " clearing roof");
                    }
                  }
                );
    }
    public static void main(String[] args) {
        Robot.Test.test(new SnowRemovalRobot("OL"));
    }
}
