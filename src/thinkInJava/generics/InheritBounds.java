/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月30日 下午2:56:33
* 创建作者：伍恰
* 文件名称：InheritBounds.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.generics;

import java.awt.Color;

class HoldItem<T> {
    T item;
    HoldItem(T item) {
        this.item = item;
    }
    T getItem() {
        return item;
    }
}

class Colored2<T extends HasColor> extends HoldItem<T> {
    Colored2(T item) {
        super(item);
    }
    Color color() {
        return item.getColor();
    }
}

class ColoredDimension2<T extends Dimension & HasColor> extends Colored2<T>{
    public ColoredDimension2(T item) {
        super(item);
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

class Solid2<T extends Dimension & HasColor & Weight> extends ColoredDimension2<T> {
    public Solid2(T item) {
        super(item);
    }
    
    int weight() {
        return item.weight();
    }
}

public class InheritBounds {
    public static void main(String[] args) {
        Solid2<Bounded> solid2 = new Solid2<Bounded>(new Bounded());
        System.out.println(solid2.getX());
        System.out.println(solid2.color());
        System.out.println(solid2.weight());
    }
    
}
