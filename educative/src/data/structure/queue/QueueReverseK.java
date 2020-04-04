package data.structure.queue;

import data.structure.stack.Stack;

public class QueueReverseK<T> {

  public static void main(String[] args) {
     Queue<Integer> queue = new Queue<>(8);
     queue.enqueue(1);
     System.out.println("  En current front, back : " + queue.getFront() + " " + queue.getBack());
     queue.enqueue(2);
     System.out.println("  En current front, back : " + queue.getFront() + " " + queue.getBack());
     queue.enqueue(3);
     System.out.println("  En current front, back : " + queue.getFront() + " " + queue.getBack());
     queue.enqueue(4);
     System.out.println("  En current front, back : " + queue.getFront() + " " + queue.getBack());
     queue.enqueue(5);
     System.out.println("  En current front, back : " + queue.getFront() + " " + queue.getBack());
     queue.dequeue();
     System.out.println("  De current front, back : " + queue.getFront() + " " + queue.getBack());
     queue.dequeue();
     System.out.println("  De current front, back : " + queue.getFront() + " " + queue.getBack());
     queue.enqueue(6);
     System.out.println("  En current front, back : " + queue.getFront() + " " + queue.getBack());
     queue.enqueue(7);
     System.out.println("  En current front, back : " + queue.getFront() + " " + queue.getBack());
     queue.enqueue(8);
     System.out.println("  En current front, back : " + queue.getFront() + " " + queue.getBack());
     queue.enqueue(9);
     System.out.println("  En current front, back : " + queue.getFront() + " " + queue.getBack());
     queue.enqueue(10);
     System.out.println("  En current front, back : " + queue.getFront() + " " + queue.getBack());
     queue.enqueue(11);
     System.out.println("  En current front, back : " + queue.getFront() + " " + queue.getBack());
     queue.dequeue();
     System.out.println("  De current front, back : " + queue.getFront() + " " + queue.getBack());
     queue.dequeue();
     System.out.println("  De current front, back : " + queue.getFront() + " " + queue.getBack());
     queue.enqueue(12);
     System.out.println("  En current front, back : " + queue.getFront() + " " + queue.getBack());
     queue.enqueue(13);
     System.out.println("  En current front, back : " + queue.getFront() + " " + queue.getBack());


     System.out.println(" E n d I n p u t -");

     reverseK(queue, 2);

     System.out.print(" - Q u e u e : ");

     while (!queue.isEmpty()){
     System.out.print(queue.dequeue() + " ");
     }
  }

  private static <T> void reverseK(Queue<T> queue, int k) {
    if (queue.isEmpty() || k <= 0) {
      return;
    }

    Stack<T> stack = new Stack<>(k);

    while (!stack.isFull()) {
      stack.push(queue.dequeue());
    }

    while (!stack.isEmpty()) {
      queue.enqueue(stack.pop());
    }

    int size = queue.getCurrentSize();
    for (int i = 0; i < size - k; i++) {
      queue.enqueue(queue.dequeue());
    }
  }
}