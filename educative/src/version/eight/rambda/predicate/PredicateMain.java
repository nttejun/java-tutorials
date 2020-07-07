package version.eight.rambda.predicate;

import java.util.function.Predicate;

public class PredicateMain {

  public static boolean isPersonEligibleForVoting(Person person, Predicate<Person> predicate) {
    return predicate.test(person);
  }

  public static void main(String[] args) {
    Person person = new Person("Alex", 23);
    Predicate<Person> greaterThanEighteen = p -> p.getAge() > 18;
    Predicate<Person> lessThanSixty = (p) -> p.getAge() < 60;
    Predicate<Person> predicateAnd = greaterThanEighteen.and(lessThanSixty);
    Predicate<Person> predicateOr = greaterThanEighteen.or(lessThanSixty);
    Predicate<Person> predicateNegate = greaterThanEighteen.negate();
    Predicate<Person> predicatePositive = greaterThanEighteen;
    Predicate<String> predicateIsEqual = Predicate.isEqual("TEST");

    boolean eligibleAnd = isPersonEligibleForVoting(person, predicateAnd);
    System.out.println(eligibleAnd);
    boolean eligibleOr = isPersonEligibleForVoting(person, predicateOr);
    System.out.println(eligibleOr);
    boolean eligibleNegate = isPersonEligibleForVoting(person, predicateNegate);
    System.out.println(eligibleNegate);
    boolean eligiblePositive = isPersonEligibleForVoting(person, predicatePositive);
    System.out.println(eligiblePositive);
    boolean eligibleIsEqual = predicateIsEqual.test("TEST");
    System.out.println(eligibleIsEqual);
    boolean eligibleIsNotEqual = predicateIsEqual.test("REAL");
    System.out.println(eligibleIsNotEqual);

    /***
     * 이슈 : age 컴파일 시점 오류 확인 필요
     Person person1 = new Person("Alex", 23);
     boolean eligibleBiPredicate =
     isPersonEligibleForVoting(
     person1,
     18,
     (p, minAge) -> {
     return p.age > minAge;
     });
     System.out.println(eligibleBiPredicate);
     */

  }

}
