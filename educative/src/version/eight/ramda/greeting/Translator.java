package version.eight.ramda.greeting;

public class Translator {

  public void greeting(Greeting greeting) {
    greeting.greeting();
  }

  public static void main(String[] args) {
    Translator translator = new Translator();

    Greeting kor = new KoreaGreeting();
    translator.greeting(kor);

    Greeting eng = new EnglishGreeting();
    translator.greeting(eng);
  }
}
