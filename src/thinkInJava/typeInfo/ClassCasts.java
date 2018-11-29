/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月19日 上午10:03:17
* 创建作者：伍恰
* 文件名称：ClassCasts.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.typeInfo;

class Building{
    
}
class House extends Building{
    
}
public class ClassCasts {
    public static void main(String[] args) {
        Building b = new House();
        Class<House> houseType = House.class;
        House h = houseType.cast(b);
        h = (House)b;
    }
}
