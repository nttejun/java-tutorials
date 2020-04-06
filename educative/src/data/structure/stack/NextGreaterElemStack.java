package data.structure.stack;

import java.util.Arrays;
import org.junit.Test;

public class NextGreaterElemStack {

  public int[] nextGreaterNormal(int[] arr){
    int tempIndex = 0;
    for(int i = 0; i < arr.length-1; i++){
      if(arr[i] < arr[i+1]){
        for(int j = tempIndex; j < i+1; j++){
          arr[j] = arr[i+1];
        }
        tempIndex = i+1;
      }
    }

    if (tempIndex < arr.length){
      for(int j = tempIndex; j < arr.length; j++){
        arr[j] = -1;
      }
    }
    return arr;
  }

  private int[] nextGreaterStack(int[] arr) {
    Stack<Integer> stack = new Stack<>(arr.length);
    int result[] = new int[arr.length];

    for (int i = arr.length - 1; i >= 0; i--) {
      if (!stack.isEmpty()) {
        while (!stack.isEmpty() && stack.top() <= arr[i]) {
          stack.pop();
        }
      }
      if (stack.isEmpty()) {
        result[i] = -1;
      } else
        result[i] = stack.top();

      stack.push(arr[i]);

    }
    return result;
  }

  public void printInt(int[] arr){

    String res = "";
    for(int i : arr){
      res += i + " ";
    }
    System.out.println(res);
  }

  @Test
  public void nextGreater(){
    int arr[] = {4,6,3,2,8,1,11};
    int result[] = nextGreaterStack(arr);

    printInt(result);
    System.out.println(Arrays.toString(result));

    System.out.println("-----------------");

    printInt(nextGreaterNormal(arr));
    printInt(nextGreaterStack(arr));
  }

}
