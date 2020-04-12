package data.structure.graph;

import org.junit.Test;

public class Graph {

  private final int verticles;
  DoublyLinkedList<Integer> dll[];

  public Graph(int verticles) {
    this.verticles = verticles;
    dll = new DoublyLinkedList[verticles];

    for (int i = 0; i < verticles; i++) {
      dll[i] = new DoublyLinkedList<>();
    }
  }

  private void addEdge(int source, int destination) {
    if (source < verticles && destination < verticles) {
      this.dll[source].insertAtEnd(destination);
    }
  }

  private void printGraph() {
    for(int i = 0; i < dll.length; i++){
      if(dll[i] != null){
        System.out.println(i);

        DoublyLinkedList<Integer>.Node temp = dll[i].getHeadNode();
        while (temp != null){
          temp = temp.nextNode;
        }
        System.out.println(temp.data + " = null ");
      } else {
        System.out.println(i + " = null ");
      }
    }
  }



  public static void main(String[] args){
    Graph graph = new Graph(4);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 3);
    graph.addEdge(2, 3);
    graph.addEdge(3, 0);

    graph.printGraph();
  }

}
