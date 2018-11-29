/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年7月14日 上午9:17:20
* 创建作者：伍恰
* 文件名称：CRGWithBasicHolder.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.generics;

class Subtype extends BasicHolder<Subtype> {}

public class CRGWithBasicHolder {
    public static void main(String[] args) {
        Subtype st1 = new Subtype(), st2 = new Subtype();
        st1.set(st2);
        Subtype st3 = st1.get();
        st1.f();
        st3.set(st1);
        st3.f();
    }
}
