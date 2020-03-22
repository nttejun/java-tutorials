package data.structure.list;


import org.junit.Assert;
import org.junit.Test;

public class SinglyLinkedList<T> {

  public class Node{
    public T data;
    public Node nextNode;
  }

  public Node headNode;
  public int size;

  public SinglyLinkedList(){
    headNode = null;
    size = 0;
  }

  public boolean isEmpty(){
    if(headNode == null) return true;
    return false;
  }

  public void insertAtHead(T data){
    Node node = new Node();
    node.data = data;

    node.nextNode = headNode;
    headNode = node;
    size++;
  }

  public String printList(){
    String printReseult = "";

    if(isEmpty()){
      System.out.println("empty list");
      return printReseult;
    }

    Node result = headNode;

    while(result.nextNode != null){
      printReseult = printReseult + " data >>> " + result.data.toString()+"\n";
      result = result.nextNode;
    }
    return printReseult;
  }

  @Test
  public void confirmSinglyLinkedList(){
    SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

    for(int i = 0; i < 5; i++){
      singlyLinkedList.insertAtHead(i);
    }

    String expected = ""
        + " data >>> 4\n"
        + " data >>> 3\n"
        + " data >>> 2\n"
        + " data >>> 1\n";
    Assert.assertEquals(expected, singlyLinkedList.printList());
  }
}

