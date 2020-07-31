package version.eight.stream.collector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;

public class CollectorFeaturesMain {

  private List<Student> students = new ArrayList<>();
  private List<Student> duplicateStudents = new ArrayList<>();

  @Before
  public void createObject() {
    students = new ArrayList<>();
    students.add(new Student("Jun", 20, "A"));
    students.add(new Student("Kane", 15, "B"));
    students.add(new Student("Din", 10, "C"));
    students.add(new Student("Dao", 25, "B"));
    students.add(new Student("Key", 40, "A"));
    students.add(new Student("Pan", 30, "D"));
  }

  @Before
  public void createDuplicateObject() {
    duplicateStudents = new ArrayList<>();
    duplicateStudents.add(new Student("Jun", 20, "A"));
    duplicateStudents.add(new Student("Kane", 15, "B"));
    duplicateStudents.add(new Student("Din", 10, "C"));
    duplicateStudents.add(new Student("Dao", 25, "B"));
    duplicateStudents.add(new Student("Dao", 40, "A"));
    duplicateStudents.add(new Student("Pan", 30, "D"));
  }

  @Test
  public void testCollectorsToList() {
    List<String> names = students.stream()
        .map(n -> n.getName())
        .collect(Collectors.toList());
    System.out.println("to list " + names);
  }

  @Test
  public void testCollectorsSet() {
    Set<String> names = students.stream()
        .map(n -> n.getName())
        .collect(Collectors.toSet());
    System.out.println("to set " + names);
  }

  @Test
  public void testCollectorsToCollection() {
    LinkedList<String> names = students.stream()
        .map(n -> n.getName())
        .collect(Collectors.toCollection(LinkedList::new));
    System.out.println("toCollection " + names);
  }

  @Test
  public void testCollectorsToMap() {
    try {
      Map<String, Integer> names = students.stream()
          .map(n -> n.getName())
          .collect(Collectors.toMap(s -> s, s -> s.length()));
      System.out.println(names);
    } catch (IllegalStateException e) {
      throw new IllegalStateException("Duplicate key excetion");
    }
  }

  @Test
  public void testCollectorsToMapPossibleDuplicate() {
    Map<String, Integer> names = duplicateStudents.stream()
        .map(n -> n.getName())
        .collect(Collectors.toMap(s -> s, s -> s.length(), (s1, s2) -> s1));
    System.out.println("binary operation " + names);
  }

  @Test
  public void testCollectorsToMapConvertToHashMap() {
    Map<String, Integer> names = students.stream()
        .map(n -> n.getName())
        .collect(Collectors.toMap(s -> s, s -> s.length(), (s1, s2) -> s1, HashMap::new));
    System.out.println("hash map " + names);
  }

  @Test
  public void testCollectorsCollectingAndThen() {
    List<String> list = new ArrayList<>();
    list.add("A");
    list.add("B");
    list.add("C");
    list.add("D");

    List<String> unmodifiableList = list.stream()
        .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));

    System.out.println(unmodifiableList);
  }
}
