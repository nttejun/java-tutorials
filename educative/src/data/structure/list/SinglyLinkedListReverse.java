package data.structure.list;

import org.junit.Assert;
import org.junit.Test;

public class SinglyLinkedListReverse<T> {

  class Node {

    public T data;
    public Node nextNode;
  }

  public int size;
  public Node headNode;

  public SinglyLinkedListReverse() {
    this.headNode = null;
    this.size = 0;
  }

  public void insertNodeHead(T data) {
    Node node = new Node();
    node.data = data;
    node.nextNode = headNode;

    headNode = node;
    size++;
  }

  public boolean isEmpty() {
    if (headNode == null) {
      return true;
    }
    return false;
  }

  @Test
  public void createNodeHeadIsNullCase() {
    SinglyLinkedListReverse<Integer> singleLinkReverse = new SinglyLinkedListReverse<>();
    Assert.assertEquals(null, singleLinkReverse.headNode);
  }

  @Test
  public void insertNodeCase() {
    SinglyLinkedListReverse<Integer> singlyLinkedListReverse = new SinglyLinkedListReverse<>();
    for (int i = 0; i < 5; i++) {
      singlyLinkedListReverse.insertNodeHead(i);
    }
    Assert.assertEquals(java.util.Optional.of(4), java.util.Optional.ofNullable(singlyLinkedListReverse.headNode.data));
  }

  @Test
  public void reverseCase(){
    SinglyLinkedListReverse<Integer> sllr = new SinglyLinkedListReverse<>();
    for(int i = 0; i < 5; i++){
      sllr.insertNodeHead(i);
    }
    reverse((SinglyLinkedListReverse<T>) sllr);
  }

  public void reverse(SinglyLinkedListReverse<T> nodeList) {
    SinglyLinkedListReverse<T>.Node previous = null;
    SinglyLinkedListReverse<T>.Node current = nodeList.headNode;
    SinglyLinkedListReverse<T>.Node next = null;

    while (current != null) {
      next = current.nextNode;
      current.nextNode = previous;
      previous = current;
      current = next;
    }
    nodeList.headNode = previous;
  }
}
