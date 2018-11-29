/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月19日 上午9:51:54
* 创建作者：伍恰
* 文件名称：GenericToyTest.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.typeInfo;

public class GenericToyTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Class<FancyToy> ftClass = FancyToy.class;
        FancyToy fancyToy = ftClass.newInstance();
        Class<? super FancyToy> up = ftClass.getSuperclass();
        //Class<Toy> up2 = ftClass.getSuperclass();
        Object obj = up.newInstance();
        
    }
}
