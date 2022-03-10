package concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallableSampleTest {

    @Test
    public void TEST_CALL() {

        ExecutorService executor = Executors.newFixedThreadPool(4);

        Entity entity = new Entity("1번");
        int count = 0;

        CallableSample callableSample = new CallableSample(entity, count);
        Future<String> future = executor.submit(callableSample);

        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}