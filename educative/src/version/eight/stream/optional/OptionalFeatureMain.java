package version.eight.stream.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;

public class OptionalFeatureMain {

  Map<Integer, Student> empMap = new HashMap<>();
  Optional<Student> studuent;

  public Optional<Student> getStudent(Integer employeeId) {
    return Optional.ofNullable(empMap.get(employeeId));
  }

  public void populateStudent() {
    empMap.put(123, new Student("Jun", 20));
  }

  public static String supportOrEleseGet() {
    return "or else get";
  }

  @Before
  public void TEST_createObj() {
    populateStudent();
    studuent = getStudent(123);
  }

  @Test
  public void TEST_isPresent() {
    if (studuent.isPresent()) {
      System.out.println(
          studuent.get().getName()
      );
    }
  }

  @Test
  public void TEST_ifPresentVer1() {
    studuent.ifPresent(student ->
        System.out.println(
            student.getName()
        ));
  }

  @Test
  public void TEST_ifPresentVer2() {
    studuent.ifPresent(System.out::println);
  }

  @Test
  public void TEST_ofNullable() {
    try {
      Optional<String> opt = Optional.ofNullable(null);
      System.out.println(opt.get());
    } catch (Exception e) {
      System.out.println("Exception : No value present");
    }
  }

  @Test
  public void TEST_get() {
    Optional<String> opt = Optional.ofNullable(null);
    System.out.println("GET : " + opt.get());
  }

  @Test
  public void TEST_orElse() {
    Optional<String> opt = Optional.ofNullable(null);
    System.out.println("GET : " + opt.orElse("null == default string"));
  }

  @Test
  public void TEST_orElseGet() {
    Optional<String> opt = Optional.ofNullable(null);
    System.out.println("GET : " + opt.orElseGet(OptionalFeatureMain::supportOrEleseGet));
  }

  @Test
  public void TEST_orElseThrow() {
    Optional<String> opt = Optional.ofNullable(null);
    try {
      System.out.println(opt.orElseThrow(() -> new Exception("Null Exception")));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void TEST_filter() {
    Optional<String> opt = Optional.ofNullable("TEST");
    System.out.println(opt.filter(str -> str.equals("TEST")));
    System.out.println(opt.filter(str -> str.equals("REAL")));
  }

  @Test
  public void TEST_map() {
    Optional<Student> optional = Optional.of(new Student("jun", 30));
    optional
        .map(student -> student.getAge())
        .filter(sal -> sal > 1)
        .ifPresent(System.out::println);
  }

  @Test
  public void TEST_flatMap() {
    Optional<Student> optional = Optional.of(new Student("Jun", 20, 1));
    optional.flatMap(stu -> stu.getNumber())
        .filter(age -> age > 1)
        .ifPresent(System.out::println);
  }
}

class Student {

  String name;
  int age;
  int number;

  Student(String name, int age) {
    this.name = name;
    this.age = age;
  }

  Student(String name, int age, int number) {
    this.name = name;
    this.age = age;
    this.number = number;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public Optional<Integer> getNumber() {
    return Optional.of(number);
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
}