package version.five.executor;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Executor {

    public void execute() {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        System.out.println("All tasks execution : " + LocalTime.now());
        for (int i = 0; i < 100; i++) {
            executor.submit(() -> {
                for(int j=0; j<100000; j++) {
                    for(int k=0; k<100000; k++) {
                        for(int y=0; y<2; y++) {
                            int temp = 1;
                            temp = temp + 1;
                            temp = temp * 2;
                            temp = temp / 2;
                            temp = temp * 2;
                            temp = temp / 2;
                        }
                    }
                }
                String threadName = Thread.currentThread().getName();
                System.out.println("Task1 : " + threadName);
            });

            executor.submit(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String threadName = Thread.currentThread().getName();
                System.out.println("Task2 : " + threadName);
            });

            executor.submit(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println("Task3 : " + threadName);
            });
        }

        executor.shutdown();

        try {
            System.out.println("Start awaitTermination");
            if (executor.awaitTermination(8, TimeUnit.SECONDS)) {
                System.out.println("All tasks terminated : " + LocalTime.now());
            } else {
                System.out.println("Not all tasks terminated : " + LocalTime.now());
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Exception awaitTermination : " + LocalTime.now());
            executor.shutdownNow();
        }
    }
}
