package exam.mobilephonecharge;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Phone {
    private static final int LATE_NIGZHT_HOUR = 22;


    enum PhoneType {REGULAR, NIGHTLY}

    private PhoneType type;

    private Money amount;
    private Money regularAmount;
    private Money nightlyAmount;
    private Duration seconds;
    private List<Call> calls = new ArrayList<>();

    public Phone(Money amount, Duration seconds) {
        this(PhoneType.REGULAR, amount, Money.ZERO, Money.ZERO, seconds);
    }

    public Phone(PhoneType type, Money amount, Money nightlyAmount, Money regularAmount, Duration seconds) {
        this.type = type;
        this.amount = amount;
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            if (type == PhoneType.REGULAR) {
                result = result.plus(
                        amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
            } else {
                if (call.getFrom().getHour() >= LATE_NIGZHT_HOUR) {
                    result = result.plus(
                            nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
                } else {
                    result = result.plus(
                            regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
                }
            }
        }
        return result;
    }

    public void call(Call call) {
        calls.add(call);
    }
}
