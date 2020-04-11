package data.structure.stack;

public class MinStack<T> {

  private int size;
  private Stack<Integer> minStack;
  private Stack<Integer> valStack;

  public MinStack(int size) {
    this.size = size;
    this.minStack = new Stack<>(size);
    this.valStack = new Stack<>(size);
  }

  public void push(Integer val) {
    valStack.push(val);
    if (!minStack.isEmpty() && minStack.top() < val) {
      minStack.push(minStack.top());
    } else {
      minStack.push(val);
    }
  }

  public int pop() {
    minStack.pop();
    return valStack.pop();
  }

  public int minVal() {
    return minStack.top();
  }


  public static void main(String[] args){

    MinStack stack = new MinStack(6);
    stack.push(5);
    stack.push(2);
    stack.push(4);
    stack.push(1);
    stack.push(3);
    stack.push(9);

    System.out.println(stack.minVal());

    stack.pop();
    stack.pop();
    stack.pop();

    System.out.println(stack.minVal());

  }
}
