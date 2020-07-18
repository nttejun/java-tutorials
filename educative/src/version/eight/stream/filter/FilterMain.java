package version.eight.stream.filter;

import java.util.ArrayList;
import java.util.List;

public class FilterMain {

  public static void main(String[] args) {

    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(10);
    list.add(100);
    list.add(1000);
    list.add(10000);
    list.add(100000);
    list.add(1000000);

    filteringLimitNumber(list, 5000);
    getOriginStream(list);

    List<Person> persons = new ArrayList<>();
    persons.add(new Person("A", 10));
    persons.add(new Person("B", 20));
    persons.add(new Person("C", 30));
    persons.add(new Person("D", 40));
    persons.add(new Person("E", 50));

    getLimitAge(persons);

  }

  private static void getLimitAge(List<Person> persons) {
    persons.stream()
        .filter(person -> person.getAge() > 30)
        .forEach(System.out::println);
  }

  private static void getOriginStream(List<Integer> list) {
    list.stream()
        .forEach(System.out::println);
  }

  private static void filteringLimitNumber(List<Integer> list, int limitNum) {
    list.stream()
        .filter(num -> num > limitNum)
        .forEach(System.out::println);
  }


}

class Person {

  private String name;
  private int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
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

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", age=" + age + '}';
  }
}
