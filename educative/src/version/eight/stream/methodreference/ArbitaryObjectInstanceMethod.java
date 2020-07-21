package version.eight.stream.methodreference;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class ArbitaryObjectInstanceMethod {

  private List<Student> list;

  @Before
  public void createObject() {
    list = new ArrayList<>();
    list.add(new Student("Jane", 20));
    list.add(new Student("Jany", 30));
    list.add(new Student("Dean", 40));
    list.add(new Student("Kay", 50));
    list.add(new Student("Henry", 100));
  }

  @Test
  public void arbitaryObjectInstanceMethod() {

    int sum = list.stream()
        .mapToInt(g -> g.getGrade())
        .sum();

    double average = list.stream()
        .mapToInt(Student::getGrade)
        .average()
        .getAsDouble();

    System.out.println(sum);
    System.out.println(average);

  }
}

class Student {

  private String name;
  private int grade;

  public Student(String name, int grade) {
    this.name = name;
    this.grade = grade;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getGrade() {
    return grade;
  }

  public void setGrade(int grade) {
    this.grade = grade;
  }
}
