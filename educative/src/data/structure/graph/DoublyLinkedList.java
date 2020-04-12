package data.structure.graph;

public class DoublyLinkedList<T> {

  class Node {
    public T data;
    public Node prevNode;
    public Node nextNode;
  }

  public Node headNode;
  public Node tailNode;
  public int size;

  public DoublyLinkedList() {
    this.headNode = null;
    this.tailNode = null;
  }

  public Node getHeadNode() {
    return headNode;
  }

  public Node getTailNode() {
    return tailNode;
  }

  public int getSize() {
    return size;
  }
  public void insertAtEnd(T data) {
    Node node = new Node();
    node.data = data;
    node.prevNode = tailNode;
    node.nextNode = null;
    tailNode.nextNode = node;
    tailNode = node;
    size++;
  }

  public void insertAtHead(T data){
    Node newNode = new Node();
    newNode.data = data;
    newNode.nextNode = headNode;
    newNode.prevNode = null;
    if(headNode != null){
      headNode = headNode.nextNode;
    } else {
      tailNode = newNode;
    }

    this.headNode = newNode;
    size++;
  }

  public boolean isEmpty(){
    if (headNode == null && tailNode == null)
      return true;
    return false;
  }

}
