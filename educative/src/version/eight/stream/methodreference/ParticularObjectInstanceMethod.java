package version.eight.stream.methodreference;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class ParticularObjectInstanceMethod {

  private List<String> list;

  public int getLength(String s) {
    return s.length();
  }

  @Before
  public void TEST_createObject() {
    list = new ArrayList<>();
    list.add("a");
    list.add("bb");
    list.add("ccc");
    list.add("dddd");
  }

  @Test
  public void getLengthNomalMethodRefernce() {
    System.out.println(">>> getLength nomal method reference");
    ParticularObjectInstanceMethod oim = new ParticularObjectInstanceMethod();
    list.stream()
        .mapToInt(s -> oim.getLength(s))
        .forEach(System.out::println);
  }

  @Test
  public void getLengthStaticMethodReference() {
    System.out.println(">>> getLength static method reference");
    ParticularObjectInstanceMethod oim = new ParticularObjectInstanceMethod();
    list.stream()
        .mapToInt(oim::getLength)
        .forEach(System.out::println);
  }

}
