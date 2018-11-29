/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年12月21日 下午4:56:10
* 创建作者：伍恰
* 文件名称：DaemonThreadFactory.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.concurrency;

import java.util.concurrent.ThreadFactory;

public class DaemonThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }

}
