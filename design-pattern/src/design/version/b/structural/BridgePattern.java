package design.version.b.structural;

public class BridgePattern {

  // Implementor interface
  interface Drawing {

    void drawCircle(int radius, int x, int y);

    void drawSquare(int sideLength, int x, int y);
  }

  // Concrete Implementor 1
  class BasicDrawing implements Drawing {

    @Override
    public void drawCircle(int radius, int x, int y) {
      System.out.println("Basic Drawing - Circle: radius " + radius + ", x " + x + ", y " + y);
    }

    @Override
    public void drawSquare(int sideLength, int x, int y) {
      System.out
          .println("Basic Drawing - Square: sideLength " + sideLength + ", x " + x + ", y " + y);
    }
  }

  // Concrete Implementor 2
  class FancyDrawing implements Drawing {

    @Override
    public void drawCircle(int radius, int x, int y) {
      System.out.println("Fancy Drawing - Circle: radius " + radius + ", x " + x + ", y " + y);
    }

    @Override
    public void drawSquare(int sideLength, int x, int y) {
      System.out
          .println("Fancy Drawing - Square: sideLength " + sideLength + ", x " + x + ", y " + y);
    }
  }

  // Abstraction
  abstract class Shape {

    protected Drawing drawing;

    public Shape(Drawing drawing) {
      this.drawing = drawing;
    }

    abstract void draw();
  }

  // Refined Abstraction 1
  class Circle extends Shape {

    private int radius;
    private int x;
    private int y;

    public Circle(int radius, int x, int y, Drawing drawing) {
      super(drawing);
      this.radius = radius;
      this.x = x;
      this.y = y;
    }

    @Override
    void draw() {
      drawing.drawCircle(radius, x, y);
    }
  }

  // Refined Abstraction 2
  class Square extends Shape {

    private int sideLength;
    private int x;
    private int y;

    public Square(int sideLength, int x, int y, Drawing drawing) {
      super(drawing);
      this.sideLength = sideLength;
      this.x = x;
      this.y = y;
    }

    @Override
    void draw() {
      drawing.drawSquare(sideLength, x, y);
    }
  }

  public void main() {
    Drawing basicDrawing = new BasicDrawing();
    Drawing fancyDrawing = new FancyDrawing();

    Shape circle1 = new Circle(5, 10, 15, basicDrawing);
    Shape circle2 = new Circle(8, 20, 25, fancyDrawing);

    Shape square1 = new Square(10, 5, 5, basicDrawing);
    Shape square2 = new Square(15, 15, 15, fancyDrawing);

    circle1.draw();
    circle2.draw();
    square1.draw();
    square2.draw();
  }
}
