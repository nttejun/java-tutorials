package version.eight.stream.not.optional;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

// object null is possible case
public class OriginalMain {

  private Employee emp;

  Map<Integer, Employee> employeeMap = new HashMap<>();

  public Employee getEmployee(Integer empId) {
    return employeeMap.get(empId);
  }

  @Test
  public void createObject() {
    OriginalMain originalMain = new OriginalMain();
    Employee emp = originalMain.getEmployee(100);
    System.out.println(emp.getName());
  }

}

class Employee {

  String name;
  int age;
  int salary;

  public Employee(String name, int age, int salary) {
    this.name = name;
    this.age = age;
    this.salary = salary;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", salary=" + salary +
        '}';
  }
}
