/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月30日 下午2:30:01
* 创建作者：伍恰
* 文件名称：BasicBounds.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.generics;

import java.awt.Color;

interface HasColor {
    Color getColor();
}

class Colored<T extends HasColor> {
    T item;
    Colored(T item) {
        this.item = item;
    }
    T getItem() {
        return item;
    }
    Color color() {
        return item.getColor();
    }
}

class Dimension {
    public int x, y, z;
}

/* class 必须 为第一个
 * class ColoredDimension<T extends HasColor & Dimension> {}*/
class ColoredDimension<T extends  Dimension & HasColor> {
    T item;
    ColoredDimension(T item) {
        this.item = item;
    }
    T getItem() {
        return item;
    }
    Color color() {
        return item.getColor();
    }
    
    int getX() {
        return item.x;
    }
    
    int getY() {
        return item.y;
    }
    
    int getZ() {
        return item.z;
    }
}

interface Weight {
    int weight();
}

class Solid<T extends Dimension & HasColor & Weight> {
    T item;
    public Solid(T item) {
        this.item = item;
    }
    T getItem() {
        return item;
    }
    
    Color color() {
        return item.getColor();
    }
    
    int getX() {
        return item.x;
    }
    
    int getY() {
        return item.y;
    }
    
    int getZ() {
        return item.z;
    }
    
    int weight() {
        return item.weight();
    }
}

class Bounded extends Dimension implements HasColor,Weight {
    public Color getColor() {
        return null;
    }

    @Override
    public int weight() {
        return 0;
    }
}
public class BasicBounds {
    public static void main(String[] args) {
        Solid<Bounded> solid = new Solid<Bounded>(new Bounded());
        System.out.println(solid.getX());
        System.out.println(solid.color());
        System.out.println(solid.weight());
    }
}
