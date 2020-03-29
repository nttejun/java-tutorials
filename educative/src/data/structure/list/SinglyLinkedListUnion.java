package data.structure.list;

import java.util.HashSet;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

public class SinglyLinkedListUnion<T> {

  class Node {

    public T data;
    public Node nextNode;
  }

  public int size;
  public Node headNode;

  public SinglyLinkedListUnion() {
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

  public void removeDuplicateData() {
    if (isEmpty()) {
      return;
    }

    Node currentNode = headNode;
    Set<T> setData = new HashSet<>();
    setData.add(currentNode.data);

    while (currentNode.nextNode != null) {
      if (setData.contains(currentNode.nextNode.data)) {
        if (currentNode.nextNode.nextNode != null) {
          currentNode.nextNode = currentNode.nextNode.nextNode;
        } else {
          currentNode.nextNode = null;
        }
      } else {
        setData.add(currentNode.nextNode.data);
        currentNode = currentNode.nextNode;
      }
    }
  }

  private void unionList(SinglyLinkedListUnion<Integer> unionBeforeA,
      SinglyLinkedListUnion<Integer> unionBeforeB) {

    SinglyLinkedListUnion<T>.Node unionBeforeANode = (Node) unionBeforeA.headNode;

    while (unionBeforeANode.nextNode != null) {
      unionBeforeANode = unionBeforeANode.nextNode;
    }

    unionBeforeANode.nextNode = (Node) unionBeforeB.headNode;
    unionBeforeA.removeDuplicateData();

  }

  public String printList() {
    String result = "RESULT : ";
    Node node = headNode;
    result += node.data + " ";
    while (node.nextNode != null) {
      result = result + String.valueOf(node.nextNode.data) + " ";
      node = node.nextNode;
    }
    return result;
  }

  @Test
  public void unionCase() {
    SinglyLinkedListUnion<Integer> unionBeforeA = new SinglyLinkedListUnion<>();
    SinglyLinkedListUnion<Integer> unionBeforeB = new SinglyLinkedListUnion<>();

    unionBeforeA.insertNodeHead(30);
    unionBeforeA.insertNodeHead(25);
    unionBeforeA.insertNodeHead(20);
    unionBeforeA.insertNodeHead(10);
    unionBeforeA.insertNodeHead(4);
    unionBeforeA.insertNodeHead(3);

    unionBeforeB.insertNodeHead(500);
    unionBeforeB.insertNodeHead(100);
    unionBeforeB.insertNodeHead(30);
    unionBeforeB.insertNodeHead(20);
    unionBeforeB.insertNodeHead(40);
    unionBeforeB.insertNodeHead(3);

    unionList(unionBeforeA, unionBeforeB);
    Assert.assertEquals("RESULT : 3 4 10 20 25 30 40 100 500 ", unionBeforeA.printList());
  }


}
