package design.version.b.behavioral;

public class CommandPattern {

  // Command interface
  interface Command {

    void execute();
  }

  // Concrete Commands
  class LightOnCommand implements Command {

    private Light light;

    public LightOnCommand(Light light) {
      this.light = light;
    }

    @Override
    public void execute() {
      light.turnOn();
    }
  }

  class LightOffCommand implements Command {

    private Light light;

    public LightOffCommand(Light light) {
      this.light = light;
    }

    @Override
    public void execute() {
      light.turnOff();
    }
  }

  // Receiver
  class Light {

    public void turnOn() {
      System.out.println("Light is on");
    }

    public void turnOff() {
      System.out.println("Light is off");
    }
  }

  // Invoker
  class RemoteControl {

    private Command command;

    // 요청을 객체 형태로 캡슐화하여 매개변수화 하거나 로깅하거나 실행 취소할 수 있도록 하는 패턴
    public void setCommand(Command command) {
      this.command = command;
    }

    public void pressButton() {
      command.execute();
    }
  }

  public void main() {
    RemoteControl remote = new RemoteControl();
    Light light = new Light();

    Command lightOnCommand = new LightOnCommand(light);
    Command lightOffCommand = new LightOffCommand(light);

    remote.setCommand(lightOnCommand);
    remote.pressButton();

    remote.setCommand(lightOffCommand);
    remote.pressButton();
  }
}
