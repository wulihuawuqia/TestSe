/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月13日 下午8:04:19
* 创建作者：伍恰
* 文件名称：LogginExceptions.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class LoggingException extends Exception{
    private static Logger logger = Logger.getLogger("LoggingExceotion");
    public LoggingException(){
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}
public class LogginExceptions {
    public static void main(String[] args) {
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            System.err.println(e);
        }
    }
}
