/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月29日 下午5:19:25
* 创建作者：伍恰
* 文件名称：ClassAsFactory.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.generics;

class ClassAsFactory<T> {
    T x;
    public ClassAsFactory(Class<T> kind){
        try {
            x = kind.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

class Employee {
    
}

public class InstantiateGenericType {
    public static void main(String[] args) {
        ClassAsFactory<Employee> fe = new ClassAsFactory<Employee>(Employee.class);
        //java.lang.InstantiationException: java.lang.Integer
        ClassAsFactory<Integer> fe1 = new ClassAsFactory<Integer>(Integer.class);
    }
    
}
