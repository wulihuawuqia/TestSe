/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月16日 下午3:19:34
* 创建作者：伍恰
* 文件名称：CountedInteger.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.typeInfo;

import java.util.ArrayList;
import java.util.List;

class CountedInteger {
    private static Long counter;
    private final Long id = counter++;
    public String toString(){
        return Long.toString(id);
    }
}
public class FilledList<T>{
    private Class<T> type;
    public FilledList(Class<T> type){
        this.type = type;
    }
    public List<T> create(int nElements){
        List<T> result = new ArrayList<>();
        try {
            for(int i = 0;i < nElements; i++){
                result.add(type.newInstance());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    public static void main(String[] args) {
        FilledList<CountedInteger> fl = new FilledList<CountedInteger>(CountedInteger.class);
        System.out.println(fl.create(10));
    }
}   
