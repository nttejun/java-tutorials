package version.eight.rambda.capturing;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Capture {

  public static void main(String[] args) {
    int n = 10;
    int a = 5;

    UnaryOperator<Integer> operator = (num) -> num * n * a;
    int res1 = operator.apply(n);
    int res2 = operator.apply(a);
    System.out.println(res1);
    System.out.println(res2);

    Function<Integer, Integer> multipler = getMultiplier();

    int i = 2;
    int res3 = multipler.apply(i);

    i = 4;
    int res4 = multipler.apply(i);
    System.out.println(res3);
    System.out.println(res4);
  }

  private static Function<Integer, Integer> getMultiplier() {

    int n = 10;

    Function<Integer, Integer> multiplier = t -> t * n;

    // n = 5; is compile error

    return multiplier;
  }
}
