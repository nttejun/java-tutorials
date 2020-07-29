package version.eight.stream.finding;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;

public class FindFeaturesMain {

  private List<Student> list;

  @Before
  public void createObject() {
    list = new ArrayList<>();
    list.add(new Student("kay", 20, "A"));
    list.add(new Student("Min", 25, "B"));
    list.add(new Student("Hun", 21, "C"));
    list.add(new Student("Jun", 44, "B"));
    list.add(new Student("Joo", 30, "C"));
  }

  @Test
  public void findFirst() {
    Optional<Student> students = list.stream()
        .filter(s -> s.getCourse().equals("C"))
        .findFirst();

    if (students.isPresent()) {
      System.out.println(students);
    }
  }

  @Test
  public void findAny() {
    Optional<Student> student = list.stream()
        .filter(s -> s.getCourse().equals("C"))
        .findAny();

    if (student.isPresent()) {
      System.out.println(student);
    }
  }
}
