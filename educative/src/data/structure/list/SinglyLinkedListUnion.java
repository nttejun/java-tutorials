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

  private void unionList(SinglyLinkedListUnion<T> listA, SinglyLinkedListUnion<T> listB) {
    SinglyLinkedListUnion<T>.Node nodeA = listA.headNode;
    while (nodeA.nextNode != null) {
      nodeA = nodeA.nextNode;
    }

    nodeA.nextNode = listB.headNode;
    listA.removeDuplicateData();
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
    SinglyLinkedListUnion<Integer> listA = new SinglyLinkedListUnion<>();
    SinglyLinkedListUnion<Integer> listB = new SinglyLinkedListUnion<>();

    for(int i=0; i<20; i+=2) {
      listA.insertNodeHead(i);
    }

    for(int i=0; i<40; i+=4){
      listB.insertNodeHead(i);

    }

    unionList((SinglyLinkedListUnion<T>) listA, (SinglyLinkedListUnion<T>) listB);
    Assert.assertEquals("RESULT : 3 4 10 20 25 30 40 100 500 ", listA.printList());
  }


}
