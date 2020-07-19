package version.eight.stream.mapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.Before;
import org.junit.Test;

public class MappingMain {

  private List<String> list;
  private List<List<String>> collectionList;
  Stream<List<String>> streamObj;

  @Before
  public void TEST_createObject() {
    list = new ArrayList<>();
    list.add("a");
    list.add("bb");
    list.add("ccc");
    list.add("dddd");
  }

  @Before
  public void TEST_createCollectionObject() {
    collectionList = new ArrayList<>();
    collectionList.add(Arrays.asList("a", "aa", "aaa"));
    collectionList.add(Arrays.asList("b", "bb", "bbb"));
    collectionList.add(Arrays.asList("c", "cc", "ccc"));
    streamObj = collectionList.stream();

  }

  private void useMapToUpperString() {
    list.stream()
        .map(name -> name.toUpperCase())
        .forEach(System.out::println);
  }

  private void useMapToIntGetStringLength() {
    list.stream()
        .mapToInt(alphabet -> alphabet.length())
        .forEach(System.out::println);
  }

  private void useNotFlatMap() {
    Stream<String> flatMapStream = streamObj.flatMap(str -> str.stream());
    Stream<String> filterStream = flatMapStream.filter(str -> "bb".equals(str));
    filterStream.forEach(System.out::println);
  }

  private void useFlatMap() {
    collectionList.stream()
        .flatMap(s -> s.stream())
        .filter(aa -> "cc".equals(aa))
        .forEach(System.out::println);
  }

  @Test
  public void TEST_useMaptoUpperString() {
    useMapToUpperString();
  }

  @Test
  public void TEST_useMapToIntgetStringLength() {
    useMapToIntGetStringLength();
  }

  @Test
  public void TEST_useNotFlatMap() {
    System.out.println(">>> useNotFlatMap");
    useNotFlatMap();
  }

  @Test
  public void TEST_useFlatMap() {
    System.out.println(">>> usezFlatMap");
    useFlatMap();
  }

}
