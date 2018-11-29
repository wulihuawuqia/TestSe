/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月23日 上午10:07:20
* 创建作者：伍恰
* 文件名称：BasicGenerator.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.generics;


public class BasicGenerator <T> {
    private Class<T> type;
    public BasicGenerator(Class<T> type){
        this.type = type;
    }
    public T next(){
        try {
            return type.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public static <T> BasicGenerator <T> create(Class<T> type){
        return new BasicGenerator<T>(type);
    }
    
}
