package assuming;

import static assuming.CustomAssumingThat.customeAssumingThat;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.Test;

class CustomAssumingThatTest {

  private static String upperCase = "A";
  private static String lowerCase = "a";

  @Test
  void execute_assumingThat() {
    customeAssumingThat(upperCase.equalsIgnoreCase(lowerCase), () -> {
      System.out.println("custom");
    });
  }

  @Test
  void execute_assumingThatOrigin() {
    assumingThat(upperCase.equalsIgnoreCase(lowerCase), () -> {
      System.out.println("origin");
    });
  }
}