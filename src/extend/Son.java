/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年12月20日 上午10:34:46
* 创建作者：伍恰
* 文件名称：Son.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package extend;

public class Son extends Father {
    
    private int age = 18;
    
    Son() {
        super(1);
        show();
    }

    @Override
    void show() {
        System.out.println("son show "+age);
    }
    
    public static void main(String[] args) {
        Son son = new Son();
        ((Father)son).show();
        //new Father(1).show();
        Father father = new Son();
        System.out.println(father.getClass().getSimpleName());
    }
}
