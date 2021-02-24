public class TalkService {

    private String alimtalkUrl = "alimtalk";
    private String friendtalkUrl = "friendtalk";

    public String checkRequestUrl(String messageType) {
        if(TalkGroup.FRIENDTALK.hasTalkCode(messageType)) {
            return friendtalkUrl;
        } else if (TalkGroup.ALIMTALK.hasTalkCode(messageType)){
            return alimtalkUrl;
        } else {
            return "";
        }
    }
}
