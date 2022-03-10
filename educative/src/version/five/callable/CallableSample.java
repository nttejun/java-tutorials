package concurrent;

import java.util.concurrent.Callable;

public class CallableSample implements Callable<String> {

    private final Entity entity;
    private final int count;

    public CallableSample(Entity entity, int count) {
        this.entity = entity;
        this.count = count;
    }

    @Override
    public String call() {
        System.out.println("===> call / count = " + count);
        return null;
    }
}
