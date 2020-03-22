package data.structure.list;

public class LinkedList<T> {

  public class Node {
    public T data;
    public Node nextNode;
  }

  public Node headNode;
  public int size;

  public LinkedList(){
    this.headNode = null;
    this.size = 0;
  }
}
