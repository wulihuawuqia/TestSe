/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月19日 下午2:01:40
* 创建作者：伍恰
* 文件名称：FanBelt.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.typeInfo.factory;

public class FanBelt extends Belt{
    public static class FactoryImpl implements Factory<FanBelt>{

        @Override
        public FanBelt create() {
            // TODO Auto-generated method stub
            return new FanBelt();
        }
        
    }
}
