import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class AppTest {

  @Test
  @DisplayName("DRAFT 테스트")
  public void create() {
    Study study = new Study();
    assertNotNull(study);
    assertEquals(StudyStatus.DRAFT, study.getStatus(), "스터디를 처음 만들면 status = DRAFT 여야 한다.");
  }

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