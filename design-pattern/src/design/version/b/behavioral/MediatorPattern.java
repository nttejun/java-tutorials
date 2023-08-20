package design.version.b.behavioral;

import java.util.ArrayList;
import java.util.List;

public class MediatorPattern {

  // Mediator interface
  interface ChatMediator {

    void sendMessage(User user, String message);
  }

  // Concrete Mediator
  class ConcreteChatMediator implements ChatMediator {

    private List<User> users = new ArrayList<>();

    @Override
    public void sendMessage(User user, String message) {
      for (User u : users) {
        if (u != user) {
          u.receiveMessage(message);
        }
      }
    }

    public void addUser(User user) {
      users.add(user);
    }
  }

  // Colleague
  abstract class User {

    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator mediator, String name) {
      this.mediator = mediator;
      this.name = name;
    }

    abstract void sendMessage(String message);

    abstract void receiveMessage(String message);
  }

  // Concrete Colleague
  class ChatUser extends User {

    public ChatUser(ChatMediator mediator, String name) {
      super(mediator, name);
    }

    @Override
    void sendMessage(String message) {
      System.out.println(name + " sends: " + message);
      mediator.sendMessage(this, message);
    }

    @Override
    void receiveMessage(String message) {
      System.out.println(name + " receives: " + message);
    }
  }

  public void main() {
    ConcreteChatMediator chatMediator = new ConcreteChatMediator();

    User user1 = new ChatUser(chatMediator, "User1");
    User user2 = new ChatUser(chatMediator, "User2");
    User user3 = new ChatUser(chatMediator, "User3");

    chatMediator.addUser(user1);
    chatMediator.addUser(user2);
    chatMediator.addUser(user3);

    user1.sendMessage("Hello, everyone!");
    user2.sendMessage("Hi there!");
  }
}
