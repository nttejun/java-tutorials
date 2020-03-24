package data.structure.list;

import org.junit.Assert;
import org.junit.Test;

public class SinglyLinkedLIstDeletion<T> {
  public class Node{
    public T data;
    public Node nextNode;
  }

  public Node headNode;
  public int size;

  public boolean isEmpty(){
    if(headNode == null){
      return true;
    }
    return false;
  }

  public SinglyLinkedLIstDeletion(){
    headNode = null;
    size = 0;
  }

  public void insertHead(T data) {
    Node node = new Node();
    node.data = data;
    node.nextNode = headNode;
    headNode = node;
    size++;
  }

  public boolean deleteHead(){
    if(isEmpty()){
      return false;
    }
    headNode = headNode.nextNode;
    size--;
    return true;
  }

  public boolean deleteTarget(int data){
    if(isEmpty()){
      return false;
    }

    Node node = this.headNode;
    Node prevNode = null;

    while (node.nextNode != null){
      if (node.data.equals(data)){
        prevNode.nextNode = node.nextNode;
        return true;
      }
      prevNode = node;
      node = node.nextNode;
    }
    return false;
  }

  public boolean searchNode(int data){
    Node node = this.headNode;

    while (node != null){
      if(node.data.equals(data)) {
        return true;
      }
      node = node.nextNode;
    }
    return false;
  }

  @Test
  public void insertHead(){
    SinglyLinkedLIstDeletion<Integer> slld = new SinglyLinkedLIstDeletion<>();
    for(int i = 0; i < 5; i++){
      slld.insertHead(i);
    }
  }

  @Test
  public void deletionTarget(){
    SinglyLinkedLIstDeletion<Integer> slld = new SinglyLinkedLIstDeletion<>();
    for(int i = 0; i < 5; i++){
      slld.insertHead(i);
    }
    slld.deleteTarget(3);
    Assert.assertEquals(true, slld.searchNode(0));
    Assert.assertEquals(true, slld.searchNode(1));
    Assert.assertEquals(true, slld.searchNode(2));
    Assert.assertEquals(false, slld.searchNode(3));
    Assert.assertEquals(true, slld.searchNode(4));
  }

  @Test
  public void deletionHead(){
    SinglyLinkedLIstDeletion<Integer> slld = new SinglyLinkedLIstDeletion<>();
    for(int i = 0; i < 5; i++){
      slld.insertHead(i);
    }
    slld.deleteHead();
    Assert.assertEquals(true, slld.searchNode(0));
    Assert.assertEquals(true, slld.searchNode(1));
    Assert.assertEquals(true, slld.searchNode(2));
    Assert.assertEquals(true, slld.searchNode(3));
    Assert.assertEquals(false, slld.searchNode(4));

  }

}
