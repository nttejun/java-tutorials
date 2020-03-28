package data.structure.list;

import java.util.HashSet;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

public class SinglyLinkedListDetectLoop<T> {

  class Node {

    public T data;
    public Node nextNode;
  }

  public int size;
  public Node headNode;

  public SinglyLinkedListDetectLoop() {
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

  public boolean isDetectLoop(){
    if(isEmpty()){
      return false;
    }

    Node node = headNode;
    Node tempHeadNode = headNode;
    Set<Node> set = new HashSet<>();

    set.add(node);
    while (!set.contains(node.nextNode) && node.nextNode != null && node.nextNode != tempHeadNode){
      set.add(node.nextNode);
      node = node.nextNode;
    }
    if(set.contains(node.nextNode)){
      return true;
    }
    return false;
  }

  @Test
  public void isDetectLoopCase(){
    SinglyLinkedListDetectLoop<Integer> slld = new SinglyLinkedListDetectLoop<>();
    slld.insertNodeHead(1);
    slld.insertNodeHead(2);
    slld.insertNodeHead(3);
    slld.headNode.nextNode.nextNode = slld.headNode;
    Assert.assertEquals(true, slld.isDetectLoop());
  }

  @Test
  public void isDetectUnloopCase(){
    SinglyLinkedListDetectLoop<Integer> slld = new SinglyLinkedListDetectLoop<>();
    slld.insertNodeHead(1);
    slld.insertNodeHead(2);
    slld.insertNodeHead(3);
    slld.headNode.nextNode.nextNode = null;
    Assert.assertEquals(false, slld.isDetectLoop());
  }

}
