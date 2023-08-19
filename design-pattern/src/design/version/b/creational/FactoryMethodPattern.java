package design.version.b.creational;

// 추상적인 객체 생성을 허용하여, 상속을 통해 실제 생성 로직을 구현한 서브클래스에서 객체를 생성
public class FactoryMethodPattern {

  // Abstract Product
  interface Character {

    void attack();
  }

  // Concrete Products
  class Warrior implements Character {

    @Override
    public void attack() {
      System.out.println("Warrior attacks with a sword");
    }
  }

  class Mage implements Character {

    @Override
    public void attack() {
      System.out.println("Mage casts a spell");
    }
  }

  // Abstract Creator
  abstract class CharacterFactory {

    abstract Character createCharacter();
  }

  // Concrete Creators
  class WarriorFactory extends CharacterFactory {

    @Override
    Character createCharacter() {
      return new Warrior();
    }
  }

  class MageFactory extends CharacterFactory {

    @Override
    Character createCharacter() {
      return new Mage();
    }
  }

  public void main() {
    CharacterFactory warriorFactory = new WarriorFactory();
    Character warrior = warriorFactory.createCharacter();
    warrior.attack();

    CharacterFactory mageFactory = new MageFactory();
    Character mage = mageFactory.createCharacter();
    mage.attack();
  }
}
