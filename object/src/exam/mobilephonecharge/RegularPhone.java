package exam.mobilephonecharge;

import java.time.Duration;

public class RegularPhone extends Phone {
    private Money amount;
    private Duration seconds;

    public RegularPhone(Money amount, Duration seconds, double taxRate) {
        super(taxRate);
        this.amount = amount;
        this.seconds = seconds;
    }
}
