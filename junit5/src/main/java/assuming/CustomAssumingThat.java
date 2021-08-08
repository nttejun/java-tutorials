package assuming;

import function.Executable;

/***
 * 구현 목적 : assumingThat 직접 구현할 수 있을까? -> 성공 경험을 쌓아 다음 학습 때 실제 구현을 할 수 있다고 생각할 수 있도록 만들기
 * 추가 목적 : 내부 람다 실행이 궁금 > assumingThat 에서 람다는 어떻게 동작되는가? 작동 과정
 */
public class CustomAssumingThat {

  public static void customeAssumingThat(boolean assumption, Executable executable) {
    if (assumption) {
      try {
        executable.execute();
      } catch (Throwable var3) {
        System.out.println("Exception");
      }
    }
  }
}
