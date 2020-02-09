package exam.mobilephonecharge;

import java.time.Duration;

public class Phone {

    private int seconds;
    private int amount;

    public Phone(int seconds, int amount) {
        this.seconds = seconds;
        this.amount = amount;
    }

    public int calculateFee(Call call) {
        Duration calltime = call.getDuration();
        long calltimeSeconds = calltime.getSeconds();
        int calltimeSecondsFee = Math.toIntExact((calltimeSeconds / seconds) * amount);
        return calltimeSecondsFee;
    }
}
