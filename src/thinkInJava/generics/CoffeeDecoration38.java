/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年7月17日 下午2:07:57
* 创建作者：伍恰
* 文件名称：BasicCoffee.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.generics;

class BasicCoffee {
    private static long counter = 0;
    private final long id = counter++;
    private String value;
    public void set(String val) {
        value = val;
    }
    
    public String get() {
        return value;
    }
    public String toString() {
        return getClass().getSimpleName()+" " + id;
    }
}

class DecoratorCoffee extends BasicCoffee {
    protected BasicCoffee basicCoffee;
    public DecoratorCoffee(BasicCoffee basicCoffee){
        this.basicCoffee = basicCoffee;
    }
    public void set(String val) {
        basicCoffee.set(val);
    }
    public String get() {
        return basicCoffee.get();
    }
}

class StreamMilk extends DecoratorCoffee {
    private final String streamedMilk = "streamedMilk";
    public StreamMilk(BasicCoffee basicCoffee) {
        super(basicCoffee);
        // TODO Auto-generated constructor stub
    }
    public String getStreamedMilk() {
        return streamedMilk;
    }
}

class Foam extends DecoratorCoffee {
    private final String foam = "foam";
    public Foam(BasicCoffee basicCoffee) {
        super(basicCoffee);
        // TODO Auto-generated constructor stub
    }
    public String getFoam() {
        return foam;
    }
}

class Chocolate extends DecoratorCoffee {

    private final String chocolate = "chocolate";
    public Chocolate(BasicCoffee basicCoffee) {
        super(basicCoffee);
        // TODO Auto-generated constructor stub
    }
    public String getChocolate() {
        return chocolate;
    }
}

class Caramel extends DecoratorCoffee {
    
    private final String caramel = "caramel";

    public Caramel(BasicCoffee basicCoffee) {
        super(basicCoffee);
        // TODO Auto-generated constructor stub
    }

    public String getCaramel() {
        return caramel;
    }
}

class WhippedCream extends DecoratorCoffee {

    private final String whippedCream = "whippedCream";
    
    public WhippedCream(BasicCoffee basicCoffee) {
        super(basicCoffee);
        // TODO Auto-generated constructor stub
    }
    
    public String getWhippedCream() {
        return whippedCream;
    }
}

public class CoffeeDecoration38 {
    public static void main(String[] args) {
        StreamMilk sm = new StreamMilk(new BasicCoffee());
        StreamMilk sm1 = new StreamMilk(new Foam(new BasicCoffee()));
        System.out.println(sm.getStreamedMilk());
        System.out.println(sm1.getStreamedMilk());
        
        Chocolate c = new Chocolate(new BasicCoffee());
        System.out.println(c.getChocolate());
        
    }
}
