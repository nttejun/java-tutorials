package javatest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/***
 * @Retention : FastTest 어노테이션 사용한 코드는 런타임 까지 정보를 유지해야 한다
 * @Target : FastTest 어노테이션을 메소드에서 사용할 수 있다
 * @Tag, @Test : 메타 어노테이션 두 개를 이용하여 새로운 FastTest 라는 새로운 어노테이션을 만들었다
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Test
@Tag("fast")
public @interface FastTest {

}
