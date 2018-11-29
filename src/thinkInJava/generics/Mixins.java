/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年7月17日 上午10:55:35
* 创建作者：伍恰
* 文件名称：Mixins.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.generics;

import java.util.Date;

interface TimeStamped {
    long getStamp();
}

interface SerialNumbered {
    long getSerialNumber();
}

class SerialNumberedImp implements SerialNumbered {
    private static long counter = 1;
    private final long serialNumber = counter++;
    @Override
    public long getSerialNumber() {
        // TODO Auto-generated method stub
        return serialNumber;
    }
}

interface Basic {
    public void set(String val);
    public String get();
}

class BasicImp implements Basic {
    private String value;
    public void set(String val) {
        value = val;
    }
    public String get() {
        return value;
    }
}

class TimeStampedImp implements TimeStamped {
    private long timeStamp = 0;
    
    public TimeStampedImp() {
        timeStamp = System.currentTimeMillis();
    }
    
    @Override
    public long getStamp() {
        // TODO Auto-generated method stub
        return timeStamp;
    }
    
}

class Mixin extends BasicImp
implements TimeStamped, SerialNumbered {
    private TimeStamped TimeStamped = new TimeStampedImp();
    private SerialNumbered serialNumber = new SerialNumberedImp();
    
    @Override
    public long getSerialNumber() {
        // TODO Auto-generated method stub
        return serialNumber.getSerialNumber();
    }

    @Override
    public long getStamp() {
        // TODO Auto-generated method stub
        return TimeStamped.getStamp();
    }
    
}

public class Mixins {
    public static void main(String[] args) {
        Mixin mixin1 = new Mixin(), mixin2 = new Mixin();
        
        mixin1.set("test String 1");
        mixin2.set("test String 2");
        
        System.out.println(mixin1.get() +" " +mixin1.getSerialNumber()
        +" "+mixin1.getStamp());
        
        System.out.println(mixin2.get() +" " +mixin2.getSerialNumber()
        +" "+mixin2.getStamp());
    }
}
