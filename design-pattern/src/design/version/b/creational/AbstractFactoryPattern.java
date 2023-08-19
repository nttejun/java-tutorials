package design.version.b.creational;

// 여러 객체의 생성을 하나의 팩토리로 묶는 패턴
public class AbstractFactoryPattern {

  // Abstract Factory Interface
  interface GUIFactory {

    Button createButton();

    TextField createTextField();
  }

  // Concrete Factory 1
  class WinFactory implements GUIFactory {

    @Override
    public Button createButton() {
      return new WinButton();
    }

    @Override
    public TextField createTextField() {
      return new WinTextField();
    }
  }

  // Concrete Factory 2
  class MacFactory implements GUIFactory {

    @Override
    public Button createButton() {
      return new MacButton();
    }

    @Override
    public TextField createTextField() {
      return new MacTextField();
    }
  }

  // Abstract Product: Button
  interface Button {

    void render();
  }

  // Concrete Product: Windows Button
  class WinButton implements Button {

    @Override
    public void render() {
      System.out.println("Rendering a Windows button");
    }
  }

  // Concrete Product: Mac Button
  class MacButton implements Button {

    @Override
    public void render() {
      System.out.println("Rendering a Mac button");
    }
  }

  // Abstract Product: TextField
  interface TextField {

    void display();
  }

  // Concrete Product: Windows TextField
  class WinTextField implements TextField {

    @Override
    public void display() {
      System.out.println("Displaying a Windows text field");
    }
  }

  // Concrete Product: Mac TextField
  class MacTextField implements TextField {

    @Override
    public void display() {
      System.out.println("Displaying a Mac text field");
    }
  }

  public void main() {
    // 원하는 GUI 객체를 선택할 수 있다
    GUIFactory factory = new WinFactory();

    Button button = factory.createButton();
    TextField textField = factory.createTextField();

    button.render();
    textField.display();
  }
}
