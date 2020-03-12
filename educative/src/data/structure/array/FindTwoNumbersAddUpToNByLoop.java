package data.structure.array;

import org.junit.Assert;
import org.junit.Test;

public class FindTwoNumbersAddUpToNByLoop {

  @Test
  public void findTwoNumbersAddUpToN(){
    int[] arr = {1, 21, 3, 14, 5, 60, 7, 6};
    int n = 27;
    Assert.assertEquals("21 6 ", printArr(findTwoNumbersAddUpToN(arr, n)));
  }

  private int[] findTwoNumbersAddUpToN(int[] arr, int n) {
    int[] result = new int[2];
    first : for (int i = 0; i < arr.length; i++){
      for (int j = 0; j < arr.length; j++){
        if (i == j){
          continue;
        }
        if (arr[i] + arr[j] == n){
          result[0] = arr[i];
          result[1] = arr[j];
          break first;
        }
      }
    }
    return result;
  }

  private String printArr(int[] arr){
    String res = "";
    for(int v : arr){
      res = res+v+" ";
    }
    return res;
  }
}
