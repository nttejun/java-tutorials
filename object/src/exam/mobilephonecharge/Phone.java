package exam.mobilephonecharge;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Phone extends AbstractPhone{
    private Money amount;
    private Duration seconds;
    private List<Call> calls = new ArrayList<>();

    public Phone(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }

    protected Money calculateCallFee(Call call){
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }

    public void call(Call call) {
        calls.add(call);
    }
}
