/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年7月17日 上午10:14:55
* 创建作者：伍恰
* 文件名称：ThrowGenericException.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.generics;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.regexp.internal.recompile;

interface Processor<T,E extends Exception> {
    void process(List<T> resultCollector) throws E;
}

class ProcessRunner<T,E extends Exception> extends ArrayList<Processor<T,E>> {
    List<T> processAll() throws E {
        List<T> resultCollector = new ArrayList<T>();
        for(Processor<T,E> processor : this) {
            processor.process(resultCollector);
        }
        return resultCollector;
    }
}

class Failurel extends Exception {}

class Processor1 implements Processor<String,Failurel> {
    static int count = 3;
    @Override
    public void process(List<String> resultCollector) throws Failurel {
        if(count-- > 1) {
            resultCollector.add("Hep!");
        } else{
            resultCollector.add("Ho!");
        }
        if(count < 0){
            throw new Failurel();
        }
    }
    
}

class Failure2 extends Exception {}

class Processor2 implements Processor<Integer,Failure2> {
    static int count = 2;
    @Override
    public void process(List<Integer> resultCollector) throws Failure2 {
        // TODO Auto-generated method stub
        if(count-- == 0) {
            resultCollector.add(47);
        }else {
            resultCollector.add(11);
        }
        if(count < 0){
            throw new Failure2();
        }
    }
    
}

public class ThrowGenericException {
    public static void main(String[] args) {
        ProcessRunner<String,Failurel> runner =
                new ProcessRunner<String,Failurel>();
        for(int i = 0; i<3; i++){
            runner.add(new Processor1());
        }
        try {
            System.out.println(runner.processAll());
        } catch (Failurel e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        ProcessRunner<Integer,Failure2> runner2 =
                new ProcessRunner<Integer,Failure2>();
        for(int i = 0; i<3; i++){
            runner2.add(new Processor2());
        }
        try {
            System.out.println(runner2.processAll());
        } catch (Failure2 e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
