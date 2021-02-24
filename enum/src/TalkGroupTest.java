import org.junit.Assert;
import org.junit.Test;

public class TalkGroupTest {

    @Test
    public void matchAlimtalkEnumValue(){
        TalkService talkService = new TalkService();
        Assert.assertEquals(talkService.checkRequestUrl("AI"), "alimtalk");
    }

    @Test
    public void notMatchFriendtalkEnumValue(){
        TalkService talkService = new TalkService();
        Assert.assertEquals(talkService.checkRequestUrl("FT"), "alimtalk");
    }
}