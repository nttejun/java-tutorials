import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.time.Duration;
import java.util.function.Supplier;
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
    Study study = new Study(10);

    // assertAll 사용하여 람다식으로 전부 실행, 하나가 실패해도 다른 테스트도 모두 실행하도록 할 수 있다.
    assertAll(
        () -> assertNotNull(study),
        () -> assertEquals(StudyStatus.DRAFT, study.getStatus(),
            () -> "스터디를 처음 만들면 " + StudyStatus.DRAFT + " 상태다."),
        () -> assertTrue(study.getLimit() > 0, "스터디 참석 가능한 인원은 0보다 커야한다"),
        () -> assertEquals(StudyStatus.DRAFT, study.getStatus(), new Supplier<String>() {
          @Override
          public String get() {
            return "스터디를 처음 만들면 " + StudyStatus.DRAFT + " 상태다.";
          }
        })
    );

    assertNotNull(study);

    // 실패하는 경우 람다식을 실행한 메시지를 반환합니다.
    assertEquals(StudyStatus.DRAFT, study.getStatus(),
        () -> "스터디를 처음 만들면 " + StudyStatus.DRAFT + " 상태다.");

    assertTrue(study.getLimit() > 0, "스터디 참석 가능한 인원은 0보다 커야한다");

    assertEquals(StudyStatus.DRAFT, study.getStatus(),
        () -> "스터디를 처음 만들면 " + StudyStatus.DRAFT + " 상태다.");

    // supplier 인자를 받지 않고 Type T 객체를 반환하는 함수형 인터페이스 입니다.
    assertEquals(StudyStatus.DRAFT, study.getStatus(), new Supplier<String>() {
      @Override
      public String get() {
        return "스터디를 처음 만들면 " + StudyStatus.DRAFT + " 상태다.";
      }
    });
  }

  // assertThrow 사용하면 실행 시 예외가 발생하는지 확인할 수 있습니다.
  // 에러 메시지도 가져올 수 있습니다.
  @Test
  @DisplayName("스터디 만들기")
  void create_new_study() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> new Study(-10));
    String message = exception.getMessage();
    assertEquals("limit은 0보다 커야한다.", message);
  }


  // assertTimeout 사용하면 실행 시간이 초과되는지 확인할 수 있습니다.
  // 단, 실패해도 실행이 완료될 때까지 기다려야 합니다.
  @Test
  void create_new_study_timer() {
    assertTimeout(Duration.ofMillis(10), () -> {
      new Study(10);
      Thread.sleep(300);
    });
  }

  // 테스트 실패하면 바로 종료됩니다. 트랜잭션 테스트 시 주의
  // 주의 : 쓰레드 로컬에서 사용하는 코드가 있는 경우 예상치 못한 DB 롤백이 안되고 DB 반영이 될 수 있다. 별개의 쓰레드로 해당 쓰레드를 실행하기 때문
  @Test
  void create_new_study_timer_preemptively() {
    assertTimeoutPreemptively(Duration.ofMillis(10), () -> {
      new Study(10);
      Thread.sleep(300);
    });
  }

  // 특정 환경에서만 테스트 실행하기
  // 사전설정 vim ~/.zshrc > export TEST_ENV=LOCAL
  @Test
  void create_new_study_env() {
    String test_env = System.getenv("TEST_ENV");
    assumeTrue("LOCAL".equalsIgnoreCase(test_env));
    assumingThat("LOCAL".equalsIgnoreCase(test_env), () -> {
      System.out.println("local");
      Study actual = new Study(10);
      assertThat(actual.getLimit()).isGreaterThan(0);
    });
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