package api.collectors;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 描述:
 * 分组测试
 *
 * @author qia.wu
 * @create 2019-04-18 18:40
 */
public class FunctionX {

	public static void main(String[] args) {
		//1.分组计数
		List<Student> list1= Arrays.asList(
				new Student(1,"one","zhao"),new Student(2,"one","qian"),new Student(3,"two","sun"));
		//1.1根据某个属性分组计数
		Map<String,Long> result1=list1.stream().collect(Collectors.groupingBy(Student::getGroupId,Collectors.counting()));
		System.out.println(result1);
		//1.2根据整个实体对象分组计数,当其为String时常使用
		Map<Student,Long> result2=list1.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(result2);
		//1.3根据分组的key值对结果进行排序、放进另一个map中并输出
		Map<String,Long> xMap=new HashMap<>();
		result1.entrySet().stream().sorted(Map.Entry.<String,Long>comparingByKey().reversed()) //reversed不生效
				.forEachOrdered(x->xMap.put(x.getKey(),x.getValue()));
		System.out.println(xMap);

		//2.分组，并统计其中一个属性值得sum或者avg:id总和
		Map<String,Integer> result3=list1.stream().collect(
				Collectors.groupingBy(Student::getGroupId,Collectors.summingInt(Student::getId))
		);
		System.out.println(result3);


		//筛选
		List list = list1.stream().filter(e -> 1 == e.getId()).collect(Collectors.toList());
		System.out.println(JSON.toJSON(list));

	}

}

class Student{
	private Integer id;
	private String groupId;
	private String name;

	public Student(Integer id, String groupId, String name) {
		this.id = id;
		this.groupId = groupId;
		this.name = name;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
