package design.version.a.observer;

import org.junit.Test;

public class StatusChecker extends StatusSubject {
    public void check() {
        Status status = loadStatus();

        if (status.isNotNormal())
            super.notifyStatus(status);
    }

    private Status loadStatus() {
        return null;
    }

    @Test
    public void addObserver() {
        StatusChecker checker = new StatusChecker();
        checker.add(new StatusEmailSender());
    }
}
