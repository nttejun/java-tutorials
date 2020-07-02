package version.eight.rambda.greeting;

public class Translator {

  public void greeting(Greeting greeting) {
    greeting.greet();
  }

  public static void main(String[] args) {
    Translator translator = new Translator();

    Greeting kor = new KoreaGreeting();
    translator.greeting(kor);

    Greeting eng = new EnglishGreeting();
    translator.greeting(eng);
  }
}
