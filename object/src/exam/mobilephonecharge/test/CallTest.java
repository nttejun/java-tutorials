package exam.mobilephonecharge.test;

import exam.mobilephonecharge.Call;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;


public class CallTest {

    @Test
    public void createConstructorCall() throws InterruptedException {

        LocalDateTime to = LocalDateTime.now();
        Thread.sleep(1000);
        LocalDateTime from = LocalDateTime.now();

        Call call = new Call(to, from);
        Assert.assertNotNull(call);

    }

    @Test
    public void getDuration(){

        LocalDateTime to = LocalDateTime.now();
        LocalDateTime from = LocalDateTime.now();

        Call call = new Call(to, from);
        Assert.assertNotNull(call.getDuration());

    }

    @Test
    public void getFrom() throws InterruptedException {

        LocalDateTime to = LocalDateTime.now();
        Thread.sleep(1000);
        LocalDateTime from = LocalDateTime.now();

        Call call = new Call(to, from);
        Assert.assertEquals(call.getFrom(), from);

    }


}