package design.version.b.structural;

import java.util.ArrayList;
import java.util.List;

// 조직 구조를 표현
// 개별 사원과 팀을 하나의 조직 구조로 표현
public class CompositePattern {

  interface Employee {

    void showDetails();
  }

  // Leaf
  class Developer implements Employee {

    private String name;
    private String position;

    public Developer(String name, String position) {
      this.name = name;
      this.position = position;
    }

    @Override
    public void showDetails() {
      System.out.println("Developer: " + name + ", Position: " + position);
    }
  }

  // Composite
  class Manager implements Employee {

    private String name;
    private String position;
    private List<Employee> subordinates = new ArrayList<>();

    public Manager(String name, String position) {
      this.name = name;
      this.position = position;
    }

    public void addSubordinate(Employee employee) {
      subordinates.add(employee);
    }

    @Override
    public void showDetails() {
      System.out.println("Manager: " + name + ", Position: " + position);
      System.out.println("Subordinates:");
      for (Employee employee : subordinates) {
        employee.showDetails();
      }
    }
  }

  public void main() {
    Developer dev1 = new Developer("Alice", "Software Engineer");
    Developer dev2 = new Developer("Bob", "Front-end Developer");

    Manager manager1 = new Manager("Charlie", "Development Manager");
    manager1.addSubordinate(dev1);
    manager1.addSubordinate(dev2);

    Developer dev3 = new Developer("David", "Back-end Developer");

    Manager manager2 = new Manager("Eve", "QA Manager");
    manager2.addSubordinate(dev3);

    Manager topManager = new Manager("Grace", "CEO");
    topManager.addSubordinate(manager1);
    topManager.addSubordinate(manager2);

    topManager.showDetails();
  }
}
