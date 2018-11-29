/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月19日 下午1:58:54
* 创建作者：伍恰
* 文件名称：AirFilter.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.typeInfo.factory;

public class AirFilter extends Filter{
    public static class FactoryImpl implements Factory<AirFilter>{

        @Override
        public AirFilter create() {
            // TODO Auto-generated method stub
            return new AirFilter();
        }
        
    }
}
