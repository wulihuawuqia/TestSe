/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年11月16日 下午9:15:23
* 创建作者：伍恰
* 文件名称：NioTest.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import org.junit.Test;

public class NioTest {
    
    @Test
    public void writeNio() {
        String filename = "out.txt";  
        FileOutputStream fos = null;  
        try {  
  
            fos = new FileOutputStream(new File(filename));  
            FileChannel channel = fos.getChannel();  
            String sp = System.getProperty("line.separator");
            for(int i = 0;i<10000;i++) {
                StringBuilder string = new StringBuilder();
                string.append("test1"+i);
                string.append("\t");
                string.append("[0.076622,-0.187024,0.065153,-0.187242,-0.000478,-0.0435,-0.066982,-0.020019,0.084123,-0.119783,0.109297,-0.141505,-0.045096,-0.106235,0.095398,-0.022359,0.127449,0.029292,0.028418,0.028572,-0.011435,0.035493,-0.183557,0.043321,0.092168,0.069235,0.081671,0.035667,0.005119,-0.02998,0.067385,0.082949,0.032606,-0.047723,0.069622,-0.003046,-0.052582,0.079947,-0.01224,0.088447,0.024797,-0.100864,0.130171,-0.170722,-0.065986,-0.110013,0.056588,0.035722,-0.043478,-0.035733,0.080007,-0.013517,0.117129,-0.061513,0.085185,-0.108566,0.047217,-0.030016,0.029486,-0.025276,0.149828,0.016405,-0.042191,0.233233,0.055929,0.092132,0.149987,-0.075103,0.019524,-0.021216,-0.035246,-0.291994,0.112375,-0.157856,-0.087712,0.059989,0.026117,-0.043401,-0.022404,-0.089893,-0.052349,0.032549,-0.041018,0.091859,0.130482,-0.123244,0.118556,-0.060537,0.064927,0.074053,-0.028393,0.024383,-0.032221,-0.017852,0.053887,-0.020906,0.011584,0.053898,-0.073632,0.025965,0.146945,-0.065145,0.138573,0.063189,0.081676,0.166304,-0.002161,0.091975,0.036288,-0.106165,0.015841,-0.045393,0.033943,-0.003577,-0.051969,-0.158957,-0.103155,0.13391,0.138482,-0.029449,0.007291,0.073744,-0.093388,0.099347,0.165527,-0.010902,-0.026801,-0.043168]");
                if(i < 10000-1) {
                    string.append("\n");
                }
                ByteBuffer src = Charset.forName("utf8").encode(string.toString());
                
                // 字节缓冲的容量和limit会随着数据长度变化，不是固定不变的  
                System.out.println("初始化容量和limit：" + src.capacity() + ","  
                        + src.limit());  
                int length = 0;  
      
                while ((length = channel.write(src)) != 0) {  
                    /*  
                     * 注意，这里不需要clear，将缓冲中的数据写入到通道中后 第二次接着上一次的顺序往下读  
                     */  
                    System.out.println("写入长度:" + length);  
                }  
            }
            
  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (fos != null) {  
                try {  
                    fos.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }
    }
}
