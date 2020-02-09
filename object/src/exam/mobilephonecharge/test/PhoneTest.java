package exam.mobilephonecharge.test;

import exam.mobilephonecharge.Call;
import exam.mobilephonecharge.Money;
import exam.mobilephonecharge.Phone;
import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;

public class PhoneTest {
    @Test
    public void calculateFee() {
        Phone phone = new Phone(Money.wons(5), Duration.ofSeconds(10));
        phone.call(new Call(LocalDateTime.of(2020, 2, 2, 12, 0, 0),
                LocalDateTime.of(2020, 2, 2, 12, 0, 10)));
        phone.call(new Call(LocalDateTime.of(2020, 2, 2, 12, 0, 20),
                LocalDateTime.of(2020, 2, 2, 12, 0, 30)));

        Assert.assertNotNull(phone.calculateFee());

    }
}
