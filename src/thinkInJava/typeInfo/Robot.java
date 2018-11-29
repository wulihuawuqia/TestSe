/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月19日 下午4:50:54
* 创建作者：伍恰
* 文件名称：Robot.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.typeInfo;

import java.util.List;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public interface Robot {
    String name();
    String model();
    List<Operation> operations();
    class Test{
        public static void test(Robot r){
            if(r instanceof Null){
                System.out.println("[Null Robot]");
            }else{
                System.out.println("Robot name :"+ r.name());
                System.out.println("Robot entity : "+ r.model());
                for(Operation operation : r.operations()){
                    System.out.println(operation.description());
                    operation.command();
                }
            }
        }
    }
}
