package data.structure.queue;

import data.structure.array.QuickSort;
import java.util.NoSuchElementException;
import org.junit.Assert;
import org.junit.Test;

public class QueueArray<T> {

  private Node<T> first;
  private Node<T> last;
  private T data;

  class Node<T> {

    private T data;
    private Node<T> next;

    public Node(T data) {
      this.data = data;
    }

  }

  public void add(T item) {
    Node<T> t = new Node<T>(item);

    if (last != null) {
      last.next = t;
    }
    last = t;
    if (first == null) {
      first = last;
    }
  }

  public T remove() {
    if (first == null) {
      throw new NoSuchElementException();
    }

    T data = first.data;
    first = first.next;

    if (first == null) {
      last = null;
    }
    return data;
  }

  public T peek() {
    if (first == null) {
      throw new NoSuchElementException();
    }
    return first.data;
  }

  public boolean isEmpty(){
    return first == null;
  }

  @Test
  public void testCase(){
    QueueArray q = new QueueArray();
    q.add(1);
    q.add(2);
    q.add(3);
    q.add(4);
    Assert.assertEquals(1, q.remove());
    Assert.assertEquals(2, q.remove());
    Assert.assertEquals(3, q.peek());
    Assert.assertEquals(3, q.remove());
    Assert.assertFalse(q.isEmpty());
    Assert.assertEquals(4, q.remove());
    Assert.assertTrue(q.isEmpty());
  }
}
