package design.version.b.behavioral;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorPattern {

  public void main() {
    List<String> names = new ArrayList<>();
    names.add("Alice");
    names.add("Bob");
    names.add("Charlie");

    // Using Iterator to iterate over the collection
    Iterator<String> iterator = names.iterator();
    while (iterator.hasNext()) {
      String name = iterator.next();
      System.out.println(name);
    }
  }
}
