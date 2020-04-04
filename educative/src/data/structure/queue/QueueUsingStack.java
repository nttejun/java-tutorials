package data.structure.queue;

import data.structure.stack.Stack;

public class QueueUsingStack<T> {

  Stack<T> s1;
  Stack<T> s2;

  public QueueUsingStack(int maxSize) {
    this.s1 = new Stack<>(maxSize);
    this.s2 = new Stack<>(maxSize);
  }

  public void enqueue(T value) {
    s1.push(value);
  }

  public T dequeue() {
    if (isEmpty()) {
      return null;
    } else if (s2.isEmpty()) {
      while (!s1.isEmpty()) {
        s2.push(s1.pop());
      }
      return s2.pop();
    } else {
      return s2.pop();
    }
  }

  public boolean isEmpty() {
    if (s1.isEmpty() && s2.isEmpty()) {
      return true;
    }
    return false;
  }

  public static void main(String args[]) {
    QueueUsingStack<Integer> q = new QueueUsingStack(4);
    q.enqueue(1);
    q.enqueue(2);
    q.enqueue(3);
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
    q.enqueue(1);
    q.enqueue(2);
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
  }
}
