package isp;

public class EmailSender {

  public void sendEmail(String type) {

    if (type == "B2B") {
      System.out.println("B2B 이메일 발송");
      return;
    }

    if (type == "B2C") {
      System.out.println("B2C 이메일 발송");
      return;
    }
  }
}
