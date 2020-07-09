package version.eight.rambda.supplier;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class SupplierMain {

  public static boolean isPersonEligibleForVoting(
      Supplier<Person> supplier, Predicate<Person> predicate) {
    return predicate.test(supplier.get());
  }

  public static void main(String args[]) {
    Supplier<Person> supplier = () -> new Person("Wonjun", 29);
    Predicate<Person> predicate = (p) -> p.age > 18;
    boolean eligible = isPersonEligibleForVoting(supplier, predicate);
    System.out.println("eligible : " + eligible);
  }
}

class Person {

  String name;
  int age;

  Person(String name, int age) {
    this.name = name;
    this.age = age;
  }
}