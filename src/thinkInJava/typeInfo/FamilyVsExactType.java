/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月19日 下午2:37:04
* 创建作者：伍恰
* 文件名称：FamilyVsExactType.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.typeInfo;
class Base{
    
}
class Derived extends Base {
    
}
public class FamilyVsExactType {
    static void test(Object x){
        System.out.println(" Testubg x of type "+x.getClass());
        System.out.println(" x instanceof Base "+(x instanceof Base));
        System.out.println(" x instanceof Derived "+ (x instanceof Derived));
        
        System.out.println("-------------");
        System.out.println("Base.isInstance(x) " + (Base.class.isInstance(x)));
        System.err.println("Derived.isInstance(x) " + (Derived.class.isInstance(x)));
        
        System.out.println("-------------");
        System.out.println("x.getClass() == Base.class " 
        + x.getClass().equals(Base.class));
        System.out.println("x.getClass() == Derived.class " +x.getClass().equals(Derived.class));
        
    }
    public static void main(String[] args) {
        test(new Base());
        test(new Derived());
    }
}
