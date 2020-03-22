package data.structure.list;


import org.junit.Assert;
import org.junit.Test;

/*

메모 : Linked list

해쉬맵, 관련 리스트, 파일 시스템에서 사용됩니다.
동적 메모리 할
산술연산이 진행된다 -> 작은 데이터 타입이 큰 타입으로 자동으로 변환이 가능하다


 */
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

  public String printList(Node 사용자){
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
    Node 사용자1 = new Node();
    for(int i = 0; i < 5; i++){
      사용자1.data = (T) ("Test " + i);
      insertAtHead(사용자1.data);
    }

    String expected = ""
        + " data >>> Test 4\n"
        + " data >>> Test 3\n"
        + " data >>> Test 2\n"
        + " data >>> Test 1\n";
    Assert.assertEquals(expected, printList(사용자1));
  }
}

