package version.eight.stream.matching;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class MatchFeatures {

  private List<Student> students;

  @Before
  public void anyMatch() {
    students = new ArrayList<>();
    students.add(new Student("hun", 20, "Literature"));
    students.add(new Student("kim", 21, "Literature"));
    students.add(new Student("joe", 22, "science"));
    students.add(new Student("sara", 20, "science"));
  }

  @Test
  public void testAnyMatch() {
    boolean anyAdultCourseStudents = students.stream()
        .anyMatch(s -> s.getCourse().equals("science"));
    System.out.println("anyAdultDayStudents is " + anyAdultCourseStudents);
  }

  @Test
  public void testAllMatch() {
    boolean allMatchCourseStudents = students.stream()
        .allMatch(s -> s.getCourse().equals("science"));
    System.out.println("allMatchCourseStudents is " + allMatchCourseStudents);
  }

  @Test
  public void noneMatch() {
    boolean noneMatchCourse = students.stream()
        .noneMatch(s -> s.getCourse().equals("science"));
    System.out.println("noneMatchCourse is " + noneMatchCourse);

    noneMatchCourse = students.stream()
        .noneMatch(s -> s.getCourse().equals("korean"));
    System.out.println("noneMatchCourse is " + noneMatchCourse);
  }
}
