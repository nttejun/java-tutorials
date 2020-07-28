package version.eight.stream.reduce;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;

public class ReduceFeaturesMain {

  private List<Student> students;
  private List<Integer> list;

  @Before
  public void createObject() {
    students = new ArrayList<>();
    students.add(new Student("Aj", 20, "A"));
    students.add(new Student("Ky", 25, "B"));
    students.add(new Student("Pu", 24, "C"));
    students.add(new Student("Ta", 30, "B"));
    students.add(new Student("Sa", 40, "C"));
  }

  @Before
  public void createInteger() {
    list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
  }

  @Test
  public void reduceAccumulator() {
    Optional<Integer> totalAge = students.stream()
        .map(p -> p.getAge())
        .reduce((a, b) -> a + b);

    if (totalAge.isPresent()) {
      System.out.println("totalAge is " + totalAge);
    }
  }

  @Test
  public void sumIntStream() {
    int totalAge = students.stream()
        .mapToInt(p -> p.getAge())
        .sum();

    System.out.println("totalAge is " + totalAge);
  }

  @Test
  public void reduceIdentity() {
    int totalSum = list.stream()
        .reduce(0, (partialSum, num) -> partialSum + num);
    System.out.println("totalSum is " + totalSum);
  }

  @Test
  public void reduceParallelStream() {
    int totalSum = list.parallelStream()
        .reduce(10500, (partialSum, num) -> partialSum + num);
    System.out.println("totalSum is " + totalSum);
  }

  @Test
  public void maxMin() {
    Optional<Integer> max = list.stream()
        .max(Comparator.naturalOrder());

    System.out.println("max is " + max);

    Optional<Integer> min = list.stream()
        .min(Comparator.naturalOrder());

    System.out.println("min is " + min);
  }

}
