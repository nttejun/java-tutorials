package exam.mobilephonecharge.test;

import exam.mobilephonecharge.Call;
import exam.mobilephonecharge.Phone;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class PhoneTest {
    @Test
    public void createPhoneObject(){
        Phone phone = new Phone(10, 5);
        Assert.assertNotNull(phone);
    }

    @Test
    public void calculateFee() throws InterruptedException {
        LocalDateTime start = LocalDateTime.of(2020, 2, 10, 12, 00, 40);
        LocalDateTime end = LocalDateTime.of(2020, 2, 10, 12, 00, 30);

        Call call = new Call(start, end);
        Phone phone = new Phone(1, 5);

        Assert.assertEquals(50, phone.calculateFee(call));
    }
}
