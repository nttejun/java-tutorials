import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class AppTest {
  @Test
  void create_1() {
    System.out.println("create1");
  }

  @Test
  @Disabled
  void disabled() {
    System.out.println("disabled");
  }

  @Test
  @BeforeAll
  static void beforeAll() {
    System.out.println("before all");
  }

  @Test
  @AfterAll
  static void afterAll() {
    System.out.println("after all");
  }

  @Test
  @BeforeEach
  void beforeEach() {
    System.out.println("before each");
  }

  @Test
  @AfterEach
  void afterEach() {
    System.out.println("after each");
  }
}