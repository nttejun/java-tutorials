import java.util.Arrays;
import java.util.List;

public enum TalkGroup {
    ALIMTALK("알림톡", Arrays.asList("AT", "AI")),
    FRIENDTALK("친구톡", Arrays.asList("FT", "FI", "FW"));

    private String talkName;
    private List<String> talkList;

    TalkGroup(String talkName, List<String> talkList) {
        this.talkName = talkName;
        this.talkList = talkList;
    }

    public boolean hasTalkCode(String code) {
        return talkList.stream()
                .anyMatch(talk -> talk.equals(code));
    }
}
