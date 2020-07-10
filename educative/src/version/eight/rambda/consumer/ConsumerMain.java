package version.eight.rambda.consumer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerMain {

  public static void main(String[] args) {
    Consumer<String> stringConsumer = s -> System.out.println(s);
    stringConsumer.accept("Test Case 1");

    Consumer<Integer> integerConsumer = i -> System.out.println(i);
    integerConsumer.accept(10000);

    Consumer<String> consumer1 = (arg) -> System.out.println(arg + " Test 1");
    Consumer<String> consumer2 = (arg) -> System.out.println(arg + " Test 2");
    Consumer<String> consumer3 = (arg) -> System.out.println(arg + " Test 3");
    consumer1.andThen(consumer2).andThen(consumer2).andThen(consumer3).accept(" Result. ");

    BiConsumer<String, String> biConsumer = (s1, s2) -> System.out.println(s1 + s2);
    biConsumer.accept("Test1", " Test2");
    biConsumer.accept(String.valueOf(consumer1), String.valueOf(consumer2));
  }
}
