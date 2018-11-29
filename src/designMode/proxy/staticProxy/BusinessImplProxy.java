/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年9月27日 下午8:06:59
* 创建作者：伍恰
* 文件名称：BusinessImplProxy.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package designMode.proxy.staticProxy;

public class BusinessImplProxy implements Business{

    private BusinessImpl businessImpl;
    @Override
    public void doAction() {
        // TODO Auto-generated method stub
        if (businessImpl == null) {
            businessImpl = new BusinessImpl();
        }
        befor();
        businessImpl.doAction();
        after();
    }

    public void befor() {
        System.out.println("执行前置动作！！！");
    }
    
    public void after() {
        System.out.println("执行后置动作！！！");
    }
    
    public static void main(String[] args) {
        //引用变量定义为抽象角色类型
        Business bi = new BusinessImplProxy();
        bi.doAction();
    }
}
