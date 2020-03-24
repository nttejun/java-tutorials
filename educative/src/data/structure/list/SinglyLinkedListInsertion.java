package data.structure.list;

import org.junit.Test;

public class SinglyLinkedListInsertion<T> {

  public class Node {
    public T data;
    public Node nextNode;
  }

  public int size;
  public Node headNode;

  public SinglyLinkedListInsertion(){
    headNode = null;
    size = 0;
  }

  public boolean isEmpty(){
    if(headNode == null) return true;
    return false;
  }

  public void insertAtEnd(T data){
    if(isEmpty()){
      insertAtHead(data);
      return;
    }
    Node node = new Node();
    node.data = data;
    node.nextNode = null;

    Node last = headNode;
    while (last.nextNode != null){
      last = last.nextNode;
    }

    last.nextNode = node;
    size++;
  }

  private void insertAtHead(T data) {
    Node node = new Node();
    node.data = data;
    node.nextNode = headNode;
    headNode = node;
    size++;

  }

  public void insert(T data, T previous){
    Node node = new Node();
    node.data = data;

    Node currentNode = this.headNode;
    while (currentNode != null && !currentNode.data.equals(previous)){
      currentNode = currentNode.nextNode;
    }

    if(currentNode != null){
      node.nextNode = currentNode.nextNode;
      currentNode.nextNode = node;
      size++;
    }
  }

  private boolean searchCase1(T i) {
    Node node = this.headNode;
    while(node != null && !node.data.equals(i)){
      node = node.nextNode;
    }

    if(node.data == i){
      return true;
    }

    return false;
  }

  private boolean searchCase2(T i) {
    Node node = this.headNode;
    while(node != null){
      if(node.data.equals(i)){
        return true;
      }
      node = node.nextNode;
    }

    if(node.data == i){
      return true;
    }

    return false;
  }

  @Test
  public void insert(){
    SinglyLinkedListInsertion<Integer> singlyLinkedListInsertion = new SinglyLinkedListInsertion<Integer>();
    for (int i = 1; i <= 20; i++) {
      singlyLinkedListInsertion.insertAtEnd(i); // inserting value at the tail of the list
    }
    String result = singlyLinkedListInsertion.printResult();
    System.out.println(result);

    System.out.println ("\nInserting 8 after 2");
    singlyLinkedListInsertion.insert(8, 2);
    result = singlyLinkedListInsertion.printResult();   // calling insert after
    System.out.println(result);
    System.out.println ("\nInserting 10 after 3");
    singlyLinkedListInsertion.insert(10, 3);   // calling insert after
    result = singlyLinkedListInsertion.printResult();
    System.out.println(result);
  }

  @Test
  public void search(){
    SinglyLinkedListInsertion<Integer> singlyLinkedListInsertion = new SinglyLinkedListInsertion<Integer>();
    for (int i = 1; i <= 10; i++) {
      singlyLinkedListInsertion.insertAtEnd(i); // inserting value at the tail of the list
    }
    boolean resultCase1 = singlyLinkedListInsertion.searchCase1(6);
    System.out.println(resultCase1);
    boolean resultCase2 = singlyLinkedListInsertion.searchCase2(6);
    System.out.println(resultCase2);
  }

  public String printResult(){
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
}
