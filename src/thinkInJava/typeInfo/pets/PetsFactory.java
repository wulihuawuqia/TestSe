/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月19日 下午2:23:08
* 创建作者：伍恰
* 文件名称：PetsFanctory.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.typeInfo.pets;

public interface PetsFactory<T> {
    T create();
}
