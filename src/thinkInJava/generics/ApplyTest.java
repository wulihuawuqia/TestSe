/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年7月17日 下午5:11:55
* 创建作者：伍恰
* 文件名称：Apply.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.generics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

class Shape {
    public void rotate() {
        System.out.println(this + " rotate");
    }
    public void resize(int newSize) {
        System.out.println(this + "resize" + newSize);
    }
}

class FilledList<T> extends ArrayList<T> {
    public FilledList(Class<? extends T> type, int size) {
        for(int i = 0; i < size; i++){
            try {
                add(type.newInstance());
            } catch (InstantiationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

public class ApplyTest {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        
        for(int i = 0; i < 5; i++){
            shapes.add(new Shape());
        }
        try {
            Apply.apply(shapes, Shape.class.getMethod("rotate"));
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class Apply {
    public static <T, S extends Iterable<? extends T>>
    void apply(S seq, Method f, Object... args){
        for(T t: seq) {
            try {
                f.invoke(t, args);
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
