package javatest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import study.Study;

public class TagTest {

  private static Study study = new Study(10);

  /***
   * 생성한 어노테이션 : FastTest, SlowTest 사용 예시
   */
  @FastTest
  @DisplayName("Fast!")
  void create_fast_annotaion_test() {
    assertThat(study.getLimit()).isGreaterThan(15);
  }

  @SlowTest
  @DisplayName("Slow!")
  void create_slow_annotaion_test() {
    assertThat(study.getLimit()).isGreaterThan(15);
  }

  /***
   * 기능 : @Tag 설정하여 원하는 테스트만 실행
   * 테스트 준비 : Edit configurations > configuration > tags > tag expressions 원하는 테스트 태그 입력 > 실행
   */
  @Test
  @Tag("slow")
  void slow_test() {
    assertThat(study.getLimit()).isGreaterThan(15);
  }

  @Test
  @Tag("fast")
  void fast_test() {
    assertThat(study.getLimit()).isGreaterThan(5);
  }

}
