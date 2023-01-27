import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.concurrent.*;
import java.util.concurrent.Future;

class FutureTest {

    @Test
    public void future() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Future<Integer> future1 = executor.submit(() -> {
            Integer sum = sum(1);
            return sum;
        });

        Future<Integer> future2 = executor.submit(() -> {
            Integer sum = sum(2);
            return sum;
        });

        Future<Integer> future3 = executor.submit(() -> {
            Integer sum = sum(3);
            return sum;
        });

        Future<Integer> future4 = executor.submit(() -> {
            Integer sum = sum(4);
            return sum;
        });

        System.out.println(LocalTime.now() + " Waiting the task done");
        Integer result1 = future1.get();
        Integer result2 = future2.get();
        Integer result3 = future3.get();
        Integer result4 = future4.get();
        System.out.println(LocalTime.now() + " Result 1 : " + result1);
        System.out.println(LocalTime.now() + " Result 2 : " + result2);
        System.out.println(LocalTime.now() + " Result 3 : " + result3);
        System.out.println(LocalTime.now() + " Result 4 : " + result4);

        executor.shutdown();
        checkJobStatus(executor);

        /*** 실행결과
         09:24:26.577 Waiting the task done
         09:24:26.577 3 Starting runnable
         09:24:26.577 1 Starting runnable
         09:24:26.577 2 Starting runnable
         09:24:29.589 4 Starting runnable
         09:24:32.595 Result 1 : 2
         09:24:32.596 Result 2 : 4
         09:24:32.596 Result 3 : 6
         09:24:32.597 Result 4 : 8
         09:24:32.598 All jobs are terminated
         */
    }

    private Integer sum(int num) throws InterruptedException {
        System.out.println(LocalTime.now() + " " + num + " Starting runnable");
        Integer sum = num + num;
        Thread.sleep(3000);
        return sum;
    }

    private void checkJobStatus(ExecutorService executor) throws InterruptedException {
        if (executor.awaitTermination(20, TimeUnit.SECONDS)) {
            System.out.println(LocalTime.now() + " All jobs are terminated");
        } else {
            System.out.println(LocalTime.now() + " some jobs are not terminated");
            executor.shutdown();
        }
    }
}