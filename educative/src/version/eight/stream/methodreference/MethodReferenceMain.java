package version.eight.stream.methodreference;

import java.util.function.Consumer;
import java.util.function.Function;

public class MethodReferenceMain {

  Consumer<String> consumer1 = c -> System.out.println(c);
  Consumer<String> consumer2 = System.out::println;
  Function<Person, String> name1 = p -> p.getName();
  Function<Person, String> name2 = Person::getName;

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
