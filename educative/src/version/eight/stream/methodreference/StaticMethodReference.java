package version.eight.stream.methodreference;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import org.junit.Before;
import org.junit.Test;

public class StaticMethodReference {

  private List<String> list;

  Consumer<String> consumer1 = c -> System.out.println(c);
  Consumer<String> consumer2 = System.out::println;
  Function<Person, String> name1 = p -> p.getName();
  Function<Person, String> name2 = Person::getName;

  public static int getLength(String s) {
    return s.length();
  }

  @Before
  public void createList() {
    list = new ArrayList<>();
    list.add("abcd");
    list.add("abcde");
    list.add("abcdefg");
    list.add("a");
  }

  @Test
  public void getLengthNomalMethodRefernce() {
    System.out.println(">>> getLength nomal method reference");
    list.stream()
        .mapToInt(s -> StaticMethodReference.getLength(s))
        .forEach(System.out::println);
  }

  @Test
  public void getLengthStaticMethodReference() {
    System.out.println(">>> getLength static method reference");
    list.stream()
        .mapToInt(StaticMethodReference::getLength)
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

