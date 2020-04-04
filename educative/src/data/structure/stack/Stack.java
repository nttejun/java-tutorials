package data.structure.stack;

public class Stack<T> {
  private int maxSize;
  private int top;
  private T[] array;
  private int currentSize;

  public Stack(int maxSize){
    this.maxSize = maxSize;
    this.top = -1;
    array = (T[]) new Object[maxSize];
    this.currentSize = 0;
  }

  public int getCurrentSize(){
    return currentSize;
  }

  public int getMaxSize(){
    return maxSize;
  }

  public boolean isEmpty(){
    return top == -1;
  }

  public boolean isFull(){
    return top == maxSize - 1;
  }

  public T top(){
    if(isEmpty())
      return null;
    return array[top];
  }

  public void push(T val){
    if(isFull()){
      throw new OutOfMemoryError();
    }
    array[++top] = val;
    currentSize++;
  }

  public T pop(){
    if(isEmpty())
      return null;
    currentSize--;
    return array[top--];
  }
}
