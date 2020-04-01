package data.structure.queue;

public class QueueBinary<V> {

  private int maxSize;
  private int front;
  private int back;
  private V arr[];
  private int currentSize;

  public QueueBinary(int maxSize) {
    this.arr = (V[]) new Object[maxSize];
    this.maxSize = maxSize;
    this.front = 0;
    this.back = -1;
    this.currentSize = 0;
  }

  public String printArr(V arr[]) {
    String res = "";
    for (V i : arr) {
      res += i + " ";
    }
    return res;
  }

  public void enqueue(V val) {
    if (isFull()) {
      return;
    }
    back = (back + 1) % maxSize;
    arr[back] = val;
    currentSize++;
  }

  public V dequeue() {
    if (isEmpty()) {
      return null;
    }

    V temp = arr[front];
    front = (front + 1) % maxSize;
    currentSize--;
    return temp;
  }

  public boolean isEmpty() {
    return currentSize == 0;
  }

  public boolean isFull() {
    return currentSize == maxSize;
  }

  public V top() {
    return arr[front];
  }

  public int getMaxSize() {
    return maxSize;
  }

  public int getCurrentSize() {
    return currentSize;
  }

  public static String[] findBin(int number) {
    String[] result = new String[number];
    QueueBinary<String> queue = new QueueBinary<String>(number + 1);

    queue.enqueue("1");
    for (int i = 0; i < number; i++) {
      result[i] = queue.dequeue();
      String a = result[i] + "0";
      String b = result[i] + "1";
      queue.enqueue(a);
      queue.enqueue(b);
    }
    return result;
  }

  public static void main(String args[]) {
    String[] output = findBin(16);
    String res = "";
    for (int i = 0; i < 16; i++) {
      res += output[i] + " ";
    }
    System.out.println(res);
  }
}
