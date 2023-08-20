package design.version.b.behavioral;

public class TemplateMethodPattern {

  // Abstract class with template method
  abstract class Animal {

    // 템플릿 메서드
    // makeSound() : 알고리즘 구조를 정의하고
    // getName(), specificSound() : 일부 단계는 서브클래스로 미루는 패턴
    public final void makeSound() {
      System.out.print(getName() + " makes ");
      specificSound();
    }

    abstract String getName();

    abstract void specificSound();
  }

  // Concrete classes
  class Dog extends Animal {

    @Override
    String getName() {
      return "Dog";
    }

    @Override
    void specificSound() {
      System.out.println("Woof!");
    }
  }

  class Cat extends Animal {

    @Override
    String getName() {
      return "Cat";
    }

    @Override
    void specificSound() {
      System.out.println("Meow!");
    }
  }

  public void main() {
    Animal dog = new Dog();
    Animal cat = new Cat();

    System.out.println("Dog sound:");
    dog.makeSound();

    System.out.println("\nCat sound:");
    cat.makeSound();
  }
}
