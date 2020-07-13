package version.eight.rambda.unary;

import java.util.function.DoubleUnaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.LongUnaryOperator;
import java.util.function.UnaryOperator;

class Unaray {

  public static void main(String[] args) {
    Person person = new Person();
    UnaryOperator<Person> operator = (p) -> {
      p.name = "wonjun";
      p.age = 29;
      return p;
    };

    operator.apply(person);
    System.out.println(person.getName());
    System.out.println(person.getAge());

    operator = (p) -> {
      p.name = "changed wonjun";
      p.age = 28;
      return p;
    };

    operator.apply(person);
    System.out.println(person.getName());
    System.out.println(person.getAge());

    IntUnaryOperator intOperator = n -> n * n;
    int intOperatorResult = intOperator.applyAsInt(5);
    System.out.println(intOperatorResult);

    intOperatorResult = intOperator.applyAsInt(10);
    System.out.println(intOperatorResult);

    DoubleUnaryOperator doubleUnaryOperator = (d) -> d * d;
    double doubleUnaryOperatorResult = doubleUnaryOperator.applyAsDouble(5.5);
    System.out.println(doubleUnaryOperatorResult);

    LongUnaryOperator longUnaryOperator = (l) -> l * l;
    long longUnaryOperatorResult = longUnaryOperator.applyAsLong((long) 10.5);
    System.out.println(longUnaryOperatorResult);

  }
}

class Person {

  public String name;
  public int age;

  public Person() {
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
