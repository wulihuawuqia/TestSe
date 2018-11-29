/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月19日 下午2:24:58
* 创建作者：伍恰
* 文件名称：CatFactory.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.typeInfo.pets;

public class CatFactory {
    public static class PetsFactoryImpl implements PetsFactory<Cat>{

        @Override
        public Cat create() {
            // TODO Auto-generated method stub
            return new Cat();
        }
        
    }
}
