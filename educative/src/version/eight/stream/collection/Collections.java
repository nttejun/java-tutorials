package version.eight.stream.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;

public class Collections {

  private List<Student> students;
  private List<String> list;
  private List<String> binaryOperatorList;

  @Before
  public void createObject(){
    students = new ArrayList<>();
    students.add(new Student("Jun", 20, "A"));
    students.add(new Student("Min", 30, "A"));
    students.add(new Student("Lee", 24, "B"));
    students.add(new Student("Qoo", 22, "C"));
  }

  @Before
  public void createList(){
    list = new ArrayList<>();
    list.add("A");
    list.add("BB");
    list.add("CCC");
    list.add("BBB");
  }

  @Before
  public void createDuplicateList(){
    binaryOperatorList = new ArrayList<>();
    binaryOperatorList.add("A");
    binaryOperatorList.add("BB");
    binaryOperatorList.add("CCC");
    binaryOperatorList.add("BB");
  }

  @Test
  public void collectToList(){
    List<String> sName = students.stream()
        .map(s -> s.getName())
        .collect(Collectors.toList());
    System.out.println("toList : " + sName);
  }

  @Test
  public void collectToSet(){
    Set<String> sName = students.stream()
        .map(s -> s.getName())
        .collect(Collectors.toSet());
    System.out.println("toSet : " + sName);
  }

  @Test
  public void collectToCollection(){
    LinkedList<String> sName = students.stream()
        .map(s -> s.getName())
        .collect(Collectors.toCollection(LinkedList::new));
    System.out.println("toCollection : " + sName);
  }

  @Test
  public void collectToMap(){
    Map<String, Integer> sMap = list.stream()
        .collect(Collectors.toMap(s -> s, s -> s.length()));
    System.out.println("toMap : " + sMap);
  }

  @Test
  public void collectToMapBinaryOperator(){
    Map<String, Integer> sMap = binaryOperatorList.stream()
        .collect(Collectors.toMap(s -> s, s -> s.length(), (s1, s2) -> s1));
    System.out.println("toMapBinaryOperator : " + sMap);
  }

  @Test
  public void collectToMapOverloaded(){
    Map<String, Integer> sMap = binaryOperatorList.stream()
        .collect(Collectors.toMap(s -> s, s -> s.length(), (s1, s2) -> s1, HashMap::new));
    System.out.println("toMapBinaryOverloaded : " + sMap);
  }
}
