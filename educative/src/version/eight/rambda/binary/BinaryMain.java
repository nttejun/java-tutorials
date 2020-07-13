package version.eight.rambda.binary;

import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;

public class BinaryMain {

  public static void main(String[] args) {

    Person person1 = new Person("wonjun", 29);
    Person person2 = new Person("changed wonjun", 29);
    BinaryOperator<Person> binaryOperator = (p1, p2) -> {
      p1.setName(p2.getName());
      p1.setAge(p2.getAge());
      return p1;
    };

    Person binaryOperatorResult = binaryOperator.apply(person1, person2);
    System.out.println(binaryOperatorResult.getName());

    DoubleBinaryOperator doubleBinaryOperator = (d1, d2) -> d1 * d2;
    System.out.println(doubleBinaryOperator.applyAsDouble(5.5, 5.5));

  }

}

class Person {

  public String name;
  public int age;

  public Person() {
  }

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return this.name;
  }

  public int getAge() {
    return this.age;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

}

