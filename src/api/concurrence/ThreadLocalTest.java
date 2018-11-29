/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2018年3月8日 上午11:26:43
* 创建作者：伍恰
* 文件名称：ThreadLocalTest.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package api.concurrence;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.annotation.Scope;

/**
 * 线程本地内存测试
 * @author 伍恰
 * 2018年3月8日 上午11:26:52
 */
public class ThreadLocalTest {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue()
        {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };
    
    public synchronized static String formatDate(Date date) {
        return sdf.format(date);
    }
    
    public static String formatIt(Date date)
    {
        return formatter.get().format(date);
    }
    
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+":"+formatIt(new Date()));
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                formatter.set(new SimpleDateFormat("yyyy-MM-dd"));
                System.out.println(Thread.currentThread().getName()+":"+formatIt(new Date()));
            }
        };
        thread1.start();
        System.out.println(Thread.currentThread().getName()+":"+formatIt(new Date()));
    }
}
