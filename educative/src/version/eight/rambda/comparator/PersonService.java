package version.eight.rambda.comparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonService {

  public static List<Person> getPersons(List<Person> persons) {
    Collections.sort(persons, new Comparator<Person>() {
      @Override
      public int compare(Person person1, Person person2) {
        return person1.getName().compareTo(person2.getName());
      }
    });
    return persons;
  }
}
