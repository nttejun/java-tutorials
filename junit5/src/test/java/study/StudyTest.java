package study;

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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

  private static Study study = new Study(10);

  /***
   * @ReoeatedTest : 테스트 반복 실행하기
   */
  @DisplayName("스터디 만들기")
  @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
  void repeatTest(RepetitionInfo repetitionInfo) {
    System.out.println(
        "Repeat Test : " + repetitionInfo.getCurrentRepetition() + "/" + repetitionInfo
            .getTotalRepetitions());
  }

  /***
   * @ParameterizedTest : 파라미터 값을 받으며 테스트 반복 실행하기
   */
  @DisplayName("스터디 만들기")
  @ParameterizedTest(name = "{index} {displayName} : {0}")
  @ValueSource(strings = {"날씨가", "많이", "추워지고", "있네요"})
  void repeatParameterizedTest(String message) {
    System.out.println(message);
  }

  /***
   * @ParameterizedTest : 파라미터 값을 받으며 테스트 반복 실행하기
   */
  @DisplayName("스터디 만들기")
  @ParameterizedTest(name = "{index} {displayName} : {0}")
  @ValueSource(strings = {"날씨가", "많이", "추워지고", "있네요"})
  @EmptySource
  @NullSource
  @NullAndEmptySource
  @CsvSource({"영어", "수학"})
  void repeatEmptyTest(String message) {
    System.out.println(message);
  }

  @DisplayName("스터디 만들기")
  @ParameterizedTest(name = "{index} {displayName} message={0}")
  @CsvSource({"10, '자바'", "20, 'C'"})
  void repeatCsvTest(int limit, String name) {
    System.out.println(new Study(limit, name));
  }

  @DisplayName("스터디 만들기")
  @ParameterizedTest(name = "{index} {displayName} message={0}")
  @CsvSource({"10, '자바'", "20, 'C'"})
  void repeatCsvConvertTest(Integer limit, String name) {
    Study study = new Study(limit, name);
    System.out.println(study);
  }

  /***
   * ArgumentsAccessor
   * 기능 : 여러 개의 인자 값의 타입을 변환
   */
  @DisplayName("스터디 만들기")
  @ParameterizedTest(name = "{index} {displayName} : {0}")
  @CsvSource({"10, '자바'", "20, 'C'"})
  void repeatConvertTest(ArgumentsAccessor argumentsAccessor) {
    Study study = new Study(argumentsAccessor.getInteger(0), argumentsAccessor.getString(1));
    System.out.println(study);
  }

  /***
   * SimpleArgumentConverter
   * 기능 : 구현체를 만들어서 하나의 인자 값의 타입을 변환
   */
  @DisplayName("스터디 만들기")
  @ParameterizedTest(name = "{index} {displayName} : {0}")
  @ValueSource(ints = {10, 20, 30})
  void repeatConvertTest(@ConvertWith(StudyConverter.class) Study study) {
    System.out.println(study.getLimit());
  }

  static class StudyConverter extends SimpleArgumentConverter {

    @Override
    protected Object convert(Object source, Class<?> targetType)
        throws ArgumentConversionException {
      assertEquals(Study.class, targetType, "Can only convert to Study");
      return new Study(Integer.parseInt(source.toString()));
    }
  }

  /***
   * 함수 : assertAll()
   * 기능 : 선언된 람다식 전체 선언, 1개의 테스트가 실패해도 전체를 실행할 수 있다는 장점
   */
  @Test
  @DisplayName("DRAFT 테스트")
  void create() {
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
    assertTrue(study.getLimit() > 0, "스터디 참석 가능 인원은 0보다 많아야 한다. (테스트 실패하면 Message 반환)");
    assertEquals(StudyStatus.DRAFT, study.getStatus(),
        () -> "스터디를 처음 만들면 " + StudyStatus.DRAFT + " 상태다. (테스트 실패하면 Message 반환)");
    assertEquals(StudyStatus.DRAFT, study.getStatus(),
        () -> "스터디를 처음 만들면 " + StudyStatus.DRAFT + " 상태다. (테스트 실패하면 Message 반환)");
  }

  /***
   * 기능 : supplier 인자를 받지 않고 Type T 객체를 반환하는 함수형 인터페이스
   */
  @Test
  void supplierResponseTypeT() {
    assertEquals(StudyStatus.DRAFT, study.getStatus(), new Supplier<String>() {
      @Override
      public String get() {
        return "스터디를 처음 만들면 " + StudyStatus.DRAFT + " 상태다.";
      }
    });
  }

  /***
   * 함수 : assertThrows()
   * 기능 : 테스트 코드 예외가 발생하는지 확인
   */
  @Test
  @DisplayName("스터디 만들기")
  void create_new_study() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> new Study(-10));
    String message = exception.getMessage();
    assertEquals("limit은 0보다 커야한다.", message);
  }


  /***
   * 함수 : assertTimeout()
   * 기능 : 실행시간 초과 확인 (시간 초과되어도 테스트가 종료될 때까지 테스트 코드는 실행)
   */
  @Test
  void create_new_study_timer() {
    assertTimeout(Duration.ofMillis(10), () -> {
      new Study(10);
      Thread.sleep(300);
    });
  }

  /***
   * 함수 : assertTimeoutPreemptively()
   * 기능 : 실행시간 초과로 테스트 코드 실패하면 함수를 즉시 종료시킵니다.
   * 주의 : 로컬에서 사용중인 쓰레드가 있는 경우 DB 롤백이 되지 않고 DB 업데이트가 될 수 있다. assertTimeoutPreemptively 함수를 별도 쓰레드를 사용하여 실행하기 때문입니다
   */
  @Test
  void create_new_study_timer_preemptively() {
    assertTimeoutPreemptively(Duration.ofMillis(10), () -> {
      new Study(10);
      Thread.sleep(300);
    });
  }

  /***
   * 테스트 사전준비 : vim ~/.zshrc > export TEST_ENV=LOCAL
   */
  @Test
  void create_new_study_env() {
    String test_env = System.getenv("TEST_ENV");
    assumeTrue("local".equalsIgnoreCase(test_env));
    assumingThat("local".equalsIgnoreCase(test_env), () -> {
      System.out.println("local");
      Study actual = new Study(10);
      assertThat(actual.getLimit()).isGreaterThan(0);
    });
  }

  @Test
  void create_new_study_env_add() {
    String test_env = System.getenv("TEST");
    assumeTrue("test".equalsIgnoreCase(test_env));
    assumingThat("test".equalsIgnoreCase(test_env), () -> {
      System.out.println("test");
      Study actual = new Study(10);
      assertThat(actual.getLimit()).isGreaterThan(0);
    });
  }
}