/**
 * 版权所有: wulihua
 * 创建日期: 2019/2/20
 * 创建作者：wuqia
 * 文件名称：CallablTest.java
 * 版本: 1.0
 * 修改记录:
 */
package interrupt;

import java.util.concurrent.Callable;

/**
 * Description: 测试.
 * @author wuqia
 * @since 2019/2/20
 */
public class CallablTest implements Callable {



    @Override
    public Object call() throws Exception {
        return "call";
    }
}

