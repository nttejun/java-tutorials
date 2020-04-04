package data.structure.queue;

import data.structure.stack.Stack;

public class QueueReverseK<T> {

  public static void main(String[] args){
    Queue<Integer> queue = new Queue<>(10);
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(5);
    queue.enqueue(6);
    queue.enqueue(7);
    queue.enqueue(8);
    queue.enqueue(9);
    queue.enqueue(10);

    reverseK(queue, 5);

    System.out.println(" Q u e u e : ");

    while (!queue.isEmpty()){
      System.out.print(queue.dequeue() + " ");
    }
  }

  private static <T> void reverseK(Queue<T> queue, int k) {
    if(queue.isEmpty() || k <= 0)
      return;

    Stack<T> stack = new Stack<>(k);

    while (!stack.isFull())
      stack.push(queue.dequeue());

    while (!stack.isEmpty())
      queue.enqueue(stack.pop());

    int size = queue.getCurrentSize();
    for(int i = 0; i < size - k; i++)
      queue.enqueue(queue.dequeue());
  }
}