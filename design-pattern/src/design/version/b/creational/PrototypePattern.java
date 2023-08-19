package design.version.b.creational;

public class PrototypePattern {

  // Prototype interface
  interface Prototype {

    Prototype clone();
  }

  // Concrete Prototypes
  class Knight implements Prototype {

    private String name;

    public Knight(String name) {
      this.name = name;
    }

    @Override
    public Prototype clone() {
      return new Knight(this.name);
    }

    @Override
    public String toString() {
      return "Knight{" +
          "name='" + name + '\'' +
          '}';
    }
  }

  class Mage implements Prototype {

    private String name;

    public Mage(String name) {
      this.name = name;
    }

    @Override
    public Prototype clone() {
      return new Mage(this.name);
    }

    @Override
    public String toString() {
      return "Mage{" +
          "name='" + name + '\'' +
          '}';
    }
  }

  다

  public void main() {
    // 객체의 상태를 복사해서 새로운 객체를 만들 수 있다
    Prototype knightPrototype = new Knight("Sir Lancelot");
    Prototype magePrototype = new Mage("Gandalf");

    Prototype clonedKnight = knightPrototype.clone();
    Prototype clonedMage = magePrototype.clone();

    System.out.println(clonedKnight);
    System.out.println(clonedMage);
  }
}
