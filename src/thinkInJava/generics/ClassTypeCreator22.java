/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月30日 上午9:48:08
* 创建作者：伍恰
* 文件名称：ClassTypeCreator22.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.generics;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Building {}

class House extends Building {
    private String location;
    private Integer area;
    public House() {
        location = null;
    }
    
    public House(Integer area ){
        this.area = area;
    }
    
    public House(String location, Integer area){
        this.location = location;
        this.area = area;
    }
    public String toString() {
        return "House" + ((location == null) ? "" :  " in " + location) +
            ((area != null) ? (", "+ area + " sqft") : "");
    }
}
public class ClassTypeCreator22 <T>{
    Class<?> kind;
    public ClassTypeCreator22(Class<?> kind){
        this.kind = kind;
    }
    
    public Object createNew(String typename) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
        return Class.forName(typename).newInstance();
    }
    
    public Object createNew(String typeName, Object... args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException{
        switch(args.length){
            case 1 : return Class.forName(typeName).getConstructor(args[0].getClass()).newInstance(args[0]);
            case 2 : return Class.forName(typeName).getConstructor(args[0].getClass(),args[1].getClass()).newInstance(args[0],args[1]);
            default :
                return null ;
        }
    }
    
    public static void main(String[] args) {
        ClassTypeCreator22<Building> ctcb = new ClassTypeCreator22<>(Building.class);
        ClassTypeCreator22<House> ctch = new ClassTypeCreator22<House>(House.class);
        try {
            Building b = (Building) ctcb.createNew("thinkInJava.generics.Building");
            Constructor[] ctors = House.class.getConstructors();
            for(Constructor ctor : ctors){
                System.out.println(ctor);
            }
            House h = (House) ctch.createNew("thinkInJava.generics.House");
            House h1 = (House) ctch.createNew("thinkInJava.generics.House", 300);
            House h2 = (House) ctch.createNew("thinkInJava.generics.House", 400);
            System.out.println(h);
            System.out.println(h1);
            System.out.println(h2);
        } catch (InstantiationException | IllegalAccessException
                | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
