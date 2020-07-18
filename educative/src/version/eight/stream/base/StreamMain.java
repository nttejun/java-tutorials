package version.eight.stream.base;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamMain {

  public static void main(String[] args) {

    useStreamOf();
    useListStream();
  }

  private static void useListStream() {
    List<String> list = new ArrayList<>();
    list.add("a");
    list.add("b");
    list.add("c");
    Stream<String> stream = list.stream();
    stream.forEach(l -> System.out.println(l));
  }

  private static void useStreamOf() {
    Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
    stream.forEach(s -> System.out.println(s));
  }
}
