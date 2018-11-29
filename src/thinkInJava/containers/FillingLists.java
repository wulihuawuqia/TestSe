/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年8月7日 下午4:25:36
* 创建作者：伍恰
* 文件名称：FillingLists.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class StringAddress {
    private String s;
    
    public StringAddress(String s) {
        this.s = s;
    }
    
    public String toString() {
        return super.toString() + " "+s;
    }
}

public class FillingLists {
    public static void main(String[] args) {
        List<StringAddress> list = new ArrayList<StringAddress>(
                Collections.nCopies(4, new StringAddress("Hello")));
        
        System.out.println(list);
        
        Collections.fill(list, new StringAddress("World"));
        
        System.out.println(list);
    }
}
