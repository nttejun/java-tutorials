package version.eight.rambda.not.greeting;

public class Translator {

  public static void greeting(Greeting greeting) {
    greeting.greet();

  }

  public static void main(String[] args) {

    greeting(
        () -> {
          System.out.println("안녕");
        }
    );

    // convert to one line
    greeting(() -> {
      System.out.println("hello");
    });
  }
}
