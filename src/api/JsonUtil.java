package api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;

/**
 * 版权所有： 爱WiFi无线运营中心
 * 创建日期:Jan 9, 2017 8:07:43 PM
 * 创建作者：亢燕翔
 * 文件名称：JsonUtil.java
 * 版本：  v1.0
 * 功能： json数据转换
 * 修改记录：
 */
public class JsonUtil {

	/**
	 * 将对象转为JSON字符转
	 * @param obj 数据源
	 * @return json字符串
	 * @author 亢燕翔  
	 * @date Jan 9, 2017 8:09:25 PM
	 */
    public static String toJson(Object obj){
        if(obj == null){
            return StringUtils.EMPTY;
        }
        return JSON.toJSONString(obj);
    }
	
    /**
     * 将json转为指定对象
     * @param <T> 
     * @param json json数据
     * @param typeOfT 数据类型
     * @return new 数据
     * @author 亢燕翔  
     * @date Jan 9, 2017 8:14:29 PM
     */
    public static <T> T fromJson(String json, Class<T> typeOfT){
    	return JSON.parseObject(json, typeOfT);
    }
    
    /**
     * 测试
     * @param args 参数
     * @author 许小满  
     * @date 2017年7月14日 下午12:36:09
     */
    public static void main(String[] args) {
        System.out.println(toJson("aa"));
        Boolean b = true;
        System.out.println(toJson(b));
        List<String> list = new ArrayList<String>();
        list.add("calc");
        list.add("bbb");
        System.out.println(toJson(list));
        Set<String> set = new HashSet<String>();
        set.add("calc");
        set.add("bbb");
        System.out.println(toJson(list));
        Map<String,String> map = new HashMap<String,String>();
        map.put("calc","a1");
        map.put("bbb","b1");
        System.out.println(toJson(map));
    }
}
