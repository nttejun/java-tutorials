package dip.locator;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

// 제네릭을 이용한 객체 등록 방식
public class ServiceLocator {
    private static Map<Class<?>, Object> objectMap = new HashMap<Class<?>, Object>();

    public static <T> T get(Class<T> klass) {
        return (T) objectMap.get(klass);
    }

    public static void regist(Class<?> klass, Object obj) {
        objectMap.put(klass, obj);
    }

    private class JobQueue {

    }

    private class Transcoder {

    }

    private class AJobQueue {

    }

    private class ATranscoder {

    }

    @Test
    public void REGIST() {
        ServiceLocator.regist(JobQueue.class, new AJobQueue());
        ServiceLocator.regist(Transcoder.class, new ATranscoder());
    }
}
