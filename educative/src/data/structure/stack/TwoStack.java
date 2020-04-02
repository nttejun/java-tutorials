package data.structure.stack;

public class TwoStack<T> {

  private int maxSize;
  private int topA, topB;
  private T[] array;

  public TwoStack(int maxSize) {
    this.maxSize = maxSize;
    this.topA = -1;
    this.topB = maxSize;
    array = (T[]) new Object[maxSize];
  }

  public void pushA(T data) {
    if (topA < topB - 1) {
      array[++topA] = data;
    }
  }

  public void pushB(T data) {
    if (topA < topB - 1) {
      array[--topB] = data;
    }
  }

  public T popA() {
    if (topA > -1) {
      return array[topA--];
    }
    return null;
  }

  public T popB() {
    if (topB < maxSize) {
      return array[topB++];
    }
    return null;
  }

  public static void main(String[] args) {
    TwoStack<Integer> tS = new TwoStack<Integer>(5);
    tS.pushA(11);
    tS.pushA(3);
    tS.pushA(7);
    tS.pushB(1);
    tS.pushB(9);

    System.out.println(tS.popA());
    System.out.println(tS.popB());
    System.out.println(tS.popB());
    System.out.println(tS.popB());
    System.out.println(tS.popA());

  }
}
