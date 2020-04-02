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
      T remove = array[topA];
      array[topA--] = null;
      return remove;
    }
    return null;
  }

  public T popB() {
    if (topB < maxSize) {
      T remove = array[topB];
      array[topB++] = null;
      return remove;
    }
    return null;
  }

  public static void main(String[] args) {
    TwoStack<Integer> tS = new TwoStack<Integer>(5);
    tS.pushA(11);
    tS.printStr(tS);
    tS.pushA(3);
    tS.printStr(tS);
    tS.pushA(7);
    tS.printStr(tS);
    tS.pushB(1);
    tS.printStr(tS);
    tS.pushB(9);
    tS.printStr(tS);

    System.out.println(tS.popA());
    System.out.println(tS.popB());
    System.out.println(tS.popB());
    System.out.println(tS.popB());
    System.out.println(tS.popA());
  }

  public void printStr(TwoStack<T> tS) {
    String s = "";
    for (int i = 0; i < tS.array.length; i++) {
      s += tS.array[i] + " ";
    }
    System.out.println(s);
  }
}
