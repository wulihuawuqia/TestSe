/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年8月23日 下午5:10:57
* 创建作者：伍恰
* 文件名称：ConcurrentHashMapTest.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package api.concurrence;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentHashMapTest {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println(test());
        }
    }
    
    private static int test() throws InterruptedException {
        Map<String, Integer> map = new HashMap<String, Integer>();
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 8; i++) {
            pool.execute(new MyTask(map));
        }
        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.DAYS);
        
        return map.get(MyTask.KEY);
    }
}

class MyTask implements Runnable {
    
    public static final String KEY = "key";
    
    private Map<String, Integer> map;
    
    public MyTask(Map<String, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            this.addup();
        }
    }
    
    private void addup() {
        synchronized ("") {
            if (!map.containsKey(KEY)) {
                map.put(KEY, 1);
            } else {
                map.put(KEY, map.get(KEY) + 1);
            }    
        }
    }
}
