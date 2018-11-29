/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年7月17日 上午11:20:02
* 创建作者：伍恰
* 文件名称：Decoration.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.generics;

import java.util.Date;

class BasicD {
    private String value;
    public void set(String val) {
        value = val;
    }
    public String get() {
        return value;
    }
}

class Decorator extends BasicD {
    protected BasicD basic;
    public Decorator(BasicD basic) {
        this.basic = basic;
    }
    public void set(String val) {
        basic.set(val);
    }
    public String get(){
        return basic.get();
    }
}

class TimeStampedD extends Decorator {
    private final long timeStamp;
    public TimeStampedD(BasicD basic) {
        super(basic);
        timeStamp = new Date().getTime();
    }
    public long getStamp() {
        return timeStamp;
    }
}

class SerialNumberedD extends Decorator {
    private static long counter = 1;
    private final long serialNumber = counter++;
    public SerialNumberedD(BasicD basic) {
        super(basic);
        // TODO Auto-generated constructor stub
    }
    public long getSerialNumber() {
        return serialNumber;
    }
}

public class Decoration {
    public static void main(String[] args) {
        TimeStampedD t = new TimeStampedD(new BasicD());
        TimeStampedD t1 = new TimeStampedD(new SerialNumberedD(new BasicD()));
        System.out.println(t.getStamp());
        System.out.println(t1.getStamp());
        
        SerialNumberedD s = new SerialNumberedD(new BasicD());
        System.out.println(s.getSerialNumber());
    }
}
