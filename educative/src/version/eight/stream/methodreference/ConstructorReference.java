package version.eight.stream.methodreference;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class ConstructorReference {

  private List<String> list;

  @Before
  public void createObject() {
    list = new ArrayList<>();
    list.add("Jane");
    list.add("Jany");
    list.add("Dean");
    list.add("Kay");
    list.add("Henry");
  }

  @Test
  public void constructorRef1() {
    list.stream()
        .map(n -> new Tester(n))
        .forEach(System.out::println);
  }

  @Test
  public void constructorRef2() {
    list.stream()
        .map(Tester::new)
        .forEach(System.out::println);
  }


}

class Tester {

  private String name;

  public Tester(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "name : " + name;
  }
}
