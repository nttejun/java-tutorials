package version.eight.stream.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.junit.Test;

public class OptionalMain {

  private Employee emp;

  Map<Integer, Employee> employeeMap = new HashMap<>();

  public Optional<Employee> getEmployee(Integer empId) {
    return Optional.ofNullable(employeeMap.get(empId));
  }

  @Test
  public void createObject() {
    OptionalMain optionalMain = new OptionalMain();
    Optional<Employee> emp = optionalMain.getEmployee(100);
    if (emp.isPresent()) {
      System.out.println(emp.get().getName());
    } else {
      System.out.println("is Empty");
    }
  }

  @Test
  public void createOptionalUsingEmptyMethod() {
    Optional<Employee> employee = Optional.empty();

  }

  @Test
  public void createOptionalUsingOfMethod() {
    Employee employee = new Employee();
    Optional<Employee> optional = Optional.of(employee);
    System.out.println(optional);
  }

  @Test
  public void createOptionalUsingOfNullableMethod() {
    Employee employee = new Employee();
    Optional<Employee> optional = Optional.ofNullable(employee);
    System.out.println(optional);
  }

}

class Employee {

  String name;
  int age;
  int salary;

  public Employee() {

  }

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

