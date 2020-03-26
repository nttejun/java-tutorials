package data.structure.list;

import org.junit.Assert;
import org.junit.Test;

public class DoublyLinkedList<T> {
  public class Node{
    public T data;
    public Node prevNode;
    public Node nextNode;
  }

  public Node headNode;
  public Node tailNode;
  public int size;

  public DoublyLinkedList(){
    this.size = 0;
    this.headNode = null;
    this.tailNode = null;
  }

  private boolean isEmpty() {
    if(this.headNode == null && tailNode == null){
      return true;
    }
    return false;
  }

  public Node getHeadNode(){
    return headNode;
  }

  public Node getTailNode(){
    return tailNode;
  }

  private void insertHead(T i) {
    Node node = new Node();
    node.data = i;
    node.nextNode = this.headNode;
    node.prevNode = null;
    if (!isEmpty()) {
      headNode.prevNode = node;
    } else {
      tailNode = node;
    }
    this.headNode = node;
    size++;
  }

  private boolean search(T data) {
    if(isEmpty()){
      return false;
    }

    if(headNode.data.equals(data)){
      return true;
    }

    Node node = this.headNode;
    node = node.nextNode;

    while (node.data != data && node != this.headNode){
      node = node.nextNode;
    }

    if(node.data.equals(data)){
      return true;
    }
    return false;
  }

  private boolean deleteValue(T data){
    if(isEmpty()){
      return false;
    }

    if(headNode.data.equals(data)){
      headNode = headNode.nextNode;
      headNode.prevNode = null;
      size--;
      return true;
    }

    Node startNode = this.headNode;
    Node node = headNode.nextNode;

    while (node.data != data && node != startNode){
      node = node.nextNode;
    }

    if(node.data.equals(data)){
      if(node == tailNode){
        if(node.prevNode == null){
          tailNode = null;
        } else {
          tailNode = node.prevNode;
        }
      }
      Node afterNode = node.nextNode;
      afterNode.prevNode = node.prevNode;
      Node beforeNode = node.prevNode;
      beforeNode.nextNode = node.nextNode;
      size--;
      return true;
    }
    return false;
  }

  public int lengthList() {
    return size;
  }

  @Test
  public void createList(){
    DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
    Assert.assertEquals(null, dll.headNode);
  }

  @Test
  public void isEmptyList(){
    DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
    Assert.assertEquals(true, dll.isEmpty());
  }

  @Test
  public void insertHead(){
    DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
    for(int i = 0; i < 10; i++){
      dll.insertHead(i);
    }
    Assert.assertEquals(true, dll.search(3));
  }

  @Test
  public void deleteValue() {
    DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
    for (int i = 0; i < 10; i++) {
      dll.insertHead(i);
    }
    Assert.assertEquals(true, dll.deleteValue(3));
  }

  @Test
  public void length() {
    DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
    for(int i = 0; i < 10; i++){
      dll.insertHead(i);
    }
    Assert.assertEquals(10, dll.lengthList());
  }
}
