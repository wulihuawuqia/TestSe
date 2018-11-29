/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月15日 上午10:14:05
* 创建作者：伍恰
* 文件名称：ParamTest.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package api;
class Employee{
    private String name;
    private Integer salary;
    public Employee(String name,Integer salary) {
        this.name=name;
        this.salary=salary;
    }
    public void raiseSalary(int i) {
        // TODO Auto-generated method stub
        salary=i;
    }
    public String getName() {
        // TODO Auto-generated method stub
        return name;
    }
    public Integer getSalary() {
        // TODO Auto-generated method stub
        return salary;
    }
}
public class ParamTest {
    public static void main(String[] args){
        /**
         * Test 1: Methods can't modify numeric parameters
         */
       System.out.println("Testing tripleValue:");
        double percent = 10;
        System.out.println("Before: percent=" + percent);
        tripleValue(percent);
        System.out.println("After: percent=" + percent);

        /**
         * Test 2: Methods can change the state of object parameters
         */
        System.out.println("\nTesting tripleSalary:");
        Employee harry = new Employee("Harry", 50000);
        System.out.println("Before: salary=" + harry.getSalary());
        tripleSalary(harry);
        System.out.println("After: salary=" + harry.getSalary());

        /**
         * Test 3: Methods can't attach new objects to object parameters
         */
        System.out.println("\nTesting swap:");
        Employee a = new Employee("Alice", 70000);
        Employee b = new Employee("Bob", 60000);
        System.out.println("Before: a=" + a.getName());
        System.out.println("Before: b=" + b.getName());
        swap(a, b);
        System.out.println("After: a=" + a.getName());
        System.out.println("After: b=" + b.getName());
  }

  private static void swap(Employee x, Employee y) {
      Employee temp = x;
      x=y;
      y=temp;
      System.out.println("End of method: x=" + x.getName());
      System.out.println("End of method: y=" + y.getName());
  }

  private static void tripleSalary(Employee x) {
      x.raiseSalary(200);
      System.out.println("End of method: salary=" + x.getSalary());
  }

  private static void tripleValue(double x) {
      x=3*x;
      System.out.println("End of Method X= "+x);
  }
}

