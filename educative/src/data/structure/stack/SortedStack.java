package data.structure.stack;

import org.junit.Assert;
import org.junit.Test;

public class SortedStack {

  public void sortedStack(Stack stack){

    Stack<Integer> newStack = new Stack<>(stack.getMaxSize());

    while (!stack.isEmpty()){
      int value = (int) stack.pop();

      if(!newStack.isEmpty() && value >= newStack.top()){
        newStack.push(value);
      } else {
        while (!newStack.isEmpty() && newStack.top() > value){
          stack.push(newStack.pop());
        }
        newStack.push(value);
      }
    }

    while (!newStack.isEmpty())
      stack.push(newStack.pop());
  }

  @Test
  public void sortedStack(){
    Stack<Integer> stack = new Stack<>(6);
    stack.push(1);
    stack.push(100);
    stack.push(10);
    stack.push(1000);
    stack.push(2);
    stack.push(200);
    sortedStack(stack);

    String res = "";
    while (!stack.isEmpty()){
      res+=stack.pop() + " ";
    }

    Assert.assertEquals("1 2 10 100 200 1000 ", res);
  }
}