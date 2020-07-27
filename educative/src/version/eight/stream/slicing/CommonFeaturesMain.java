package version.eight.stream.slicing;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class CommonFeaturesMain {

  private List<String> students;

  @Before
  public void testCreateList() {
    students = new ArrayList<>();
    students.add("Kane");
    students.add("Jane");
    students.add("Joo");
    students.add("charly");
    students.add("charly");
    students.add("charly");
    students.add("Joo");
    students.add("Jane");
  }

  @Test
  public void testDistinct() {
    students.stream()
        .distinct()
        .forEach(System.out::println);
  }

  @Test
  public void testLimit() {
    students.stream()
        .limit(5)
        .forEach(System.out::println);
  }

  @Test
  public void testSkip() {
    students.stream()
        .distinct()
        .skip(2)
        .forEach(System.out::println);
  }

  @Test
  public void testSkipNotDistinct() {
    students.stream()
        .skip(4)
        .forEach(System.out::println);
  }
}
