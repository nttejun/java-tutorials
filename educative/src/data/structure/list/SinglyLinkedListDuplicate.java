package data.structure.list;

import java.util.HashSet;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

public class SinglyLinkedListDuplicate<T> {

  class Node {

    public T data;
    public Node nextNode;
  }

  public int size;
  public Node headNode;

  public SinglyLinkedListDuplicate() {
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

  public void removeDuplicate() {
    if (isEmpty()) {
      return;
    }

    Node tempHeadNode = headNode;
    Node node = headNode;
    Set<T> setData = new HashSet();
    Set<Node> setNode = new HashSet();
    setNode.add(headNode);
    setData.add(headNode.data);

    while (node.nextNode != null && node.nextNode != tempHeadNode && !setNode.contains(node.nextNode)) {
      setNode.add(node.nextNode);
      setData.add(node.nextNode.data);

      if (setData.contains(node.nextNode.data)) {
        if (node.nextNode.nextNode == null) {
          node.nextNode = null;
        }
      } else {
        node.nextNode = node.nextNode.nextNode;
      }
    }
  }

  public String printList() {
    String result = "RESULT : ";
    Node node = headNode;
    result += node.data + " ";
    while (node.nextNode != null) {
      result = result + String.valueOf(node.nextNode.data) + " ";
      node = node.nextNode;
    }
    System.out.println(result);
    return result;
  }

  @Test
  public void duplicateCase1() {
    SinglyLinkedListDuplicate<Integer> slld = new SinglyLinkedListDuplicate<>();
    for (int i = 0; i < 5; i++) {
      slld.insertNodeHead(i);
    }
    slld.insertNodeHead(5);
    slld.insertNodeHead(8);
    slld.insertNodeHead(10);
    slld.removeDuplicate();
    Assert.assertEquals("RESULT : 10 8 5 4 3 2 1 0 ", slld.printList());
  }

  @Test
  public void duplicateCase2() {
    SinglyLinkedListDuplicate<Integer> slld = new SinglyLinkedListDuplicate<>();
    for (int i = 0; i < 5; i++) {
      slld.insertNodeHead(i);
    }
    slld.removeDuplicate();
    Assert.assertEquals("RESULT : 4 3 2 1 0 ", slld.printList());
  }
}
