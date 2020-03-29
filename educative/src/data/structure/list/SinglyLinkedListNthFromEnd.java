package data.structure.list;

import java.util.HashMap;
import org.junit.Assert;
import org.junit.Test;

public class SinglyLinkedListNthFromEnd<T> {

  //Node inner class for SLL
  public class Node {

    public T data;
    public Node nextNode;

  }

  //head node of the linked list
  private Node headNode;
  private int size;

  public Node getHeadNode() {
    return headNode;
  }

  public void setHeadNode(Node headNode) {
    this.headNode = headNode;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  //constructor
  public SinglyLinkedListNthFromEnd() {
    headNode = null;
    size = 0;
  }

  public boolean isEmpty() {

    if (headNode == null) {
      return true;
    }
    return false;
  }

  //Inserts new data at the start of the linked list
  public void insertAtHead(T data) {
    //Creating a new node and assigning it the new data value
    Node newNode = new Node();
    newNode.data = data;
    //Linking head to the newNode's nextNode
    newNode.nextNode = headNode;
    headNode = newNode;
    size++;
  }

  //Inserts new data at the end of the linked list
  public void insertAtEnd(T data) {
    //if the list is empty then call insertATHead()
    if (isEmpty()) {
      insertAtHead(data);
      return;
    }
    //Creating a new Node with value data
    Node newNode = new Node();
    newNode.data = data;
    newNode.nextNode = null;

    Node last = headNode;
    //iterate to the last element
    while (last.nextNode != null) {
      last = last.nextNode;
    }
    //make newNode the next element of the last node
    last.nextNode = newNode;
    size++;
  }

  //inserts data after the given prev data node
  public void insertAfter(T data, T previous) {

    //Creating a new Node with value data
    Node newNode = new Node();
    newNode.data = data;
    //Start from head node
    Node currentNode = this.headNode;
    //traverse the list until node having data equal to previous is found
    while (currentNode != null && currentNode.data != previous) {
      currentNode = currentNode.nextNode;
    }
    //if such a node was found
    //then point our newNode to currentNode's nextElement
    if (currentNode != null) {
      newNode.nextNode = currentNode.nextNode;
      currentNode.nextNode = newNode;
      size++;
    }
  }

  public void printList() {
    if (isEmpty()) {
      return;
    }

    Node temp = headNode;

    while (temp.nextNode != null) {
      temp = temp.nextNode;
    }
  }

  public boolean searchNode(T data) {
    Node currentNode = this.headNode;

    //Traverse the list till you reach end
    while (currentNode != null) {
      if (currentNode.data.equals(data)) {
        return true; //value found
      }

      currentNode = currentNode.nextNode;
    }
    return false; //value not found
  }

  public void deleteAtHead() {
    if (isEmpty()) {
      return;
    }
    headNode = headNode.nextNode;
    size--;
  }

  public void deleteAtEnd() {
    if (isEmpty()) {
      return;
    }
    Node prevNode = this.headNode;
    Node currentNode = prevNode.nextNode;
    while (currentNode.nextNode != null) {
      prevNode = currentNode;
      currentNode = currentNode.nextNode;
    }
    prevNode.nextNode = null;
    size--;
  }

  public void deleteByValue(T data) {
    //if empty then simply return
    if (isEmpty()) {
      return;
    }

    //Start from head node
    Node currentNode = this.headNode;
    Node prevNode = null; //previous node starts from null

    if (currentNode.data.equals(data)) {
      //data is at head so delete from head
      deleteAtHead();
      return;
    }
    //traverse the list searching for the data to delete
    while (currentNode != null) {
      //node to delete is found
      if (data.equals(currentNode.data)) {
        prevNode.nextNode = currentNode.nextNode;
        return;
      }
      prevNode = currentNode;
      currentNode = currentNode.nextNode;
    }
  }

  private void getNthNodeFromEnd(int nth) {

    if (isEmpty()) {
      return;
    }

    Node node = headNode;
    HashMap<Integer, T> map = new HashMap<>();
    int mapIndex = 1;

    map.put(mapIndex, node.data);

    while (node.nextNode != null) {
      map.put(mapIndex, node.data);
      node = node.nextNode;
      mapIndex++;
    }
  }

  private <T> Object nthElementFromEnd(SinglyLinkedListNthFromEnd<T> nthFromEnd, int n) {

    SinglyLinkedListNthFromEnd<T>.Node current = nthFromEnd.getHeadNode();
    n = nthFromEnd.getSize() - n + 1;

    if (size < n || size == 0) {
      return null;
    }

    int count = 1;
    while (current != null) {
      if (count == n) {
        return current.data;
      }
      count++;
      current = current.nextNode;
    }
    return null;
  }

  @Test
  public void nthFromEndCase() {
    SinglyLinkedListNthFromEnd<Integer> nthFromEnd = new SinglyLinkedListNthFromEnd<>();

    for (int i = 0; i < 8; i++) {
      nthFromEnd.insertAtHead(i);
    }
    nthFromEnd.getNthNodeFromEnd(3);
  }

  @Test
  public void nthFromEndOtherCase1() {
    SinglyLinkedListNthFromEnd<Integer> nthFromEnd = new SinglyLinkedListNthFromEnd<>();
    for (int i = 0; i < 14; i++) {
      nthFromEnd.insertAtHead(i);
    }
    nthFromEnd.printList();
    Assert.assertEquals(2, nthFromEnd.nthElementFromEnd(nthFromEnd, 3));
    Assert.assertEquals(9, nthFromEnd.nthElementFromEnd(nthFromEnd, 10));
  }

  @Test
  public void nthFromEndOtherCase2() {
    SinglyLinkedListNthFromEnd<Integer> nthFromEnd = new SinglyLinkedListNthFromEnd<>();
    for (int i = 0; i < 50; i += 3) {
      nthFromEnd.insertAtHead(i);
    }
    Assert.assertEquals(12, nthFromEnd.nthElementFromEnd(nthFromEnd, 5));
  }

}
