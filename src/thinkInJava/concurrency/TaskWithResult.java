/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年12月20日 下午4:28:48
* 创建作者：伍恰
* 文件名称：TaskWithResult.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TaskWithResult implements Callable<String>{

    private int id;
    
    public TaskWithResult(int id) {
        this.id = id;
    }
    
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()+id);
        return "result "+Thread.currentThread().getName()+"-"+ id;
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<String>> results = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }
        for(Future<String> future : results) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ExecutionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
