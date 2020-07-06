package version.eight.rambda.not.comparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonService {

  public static List<Person> getPersons(List<Person> persons) {
    Collections.sort(persons, Comparator.comparing(Person::getName));
    return persons;
  }
}
