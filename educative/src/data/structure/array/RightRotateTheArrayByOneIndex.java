package data.structure.array;

import org.junit.Assert;
import org.junit.Test;

public class RightRotateTheArrayByOneIndex {
  @Test
  public void rightToLeft(){
    int[] arr = {1, 2, 3, 4, 5};
    Assert.assertEquals("51234", printArray(rightToLeft(arr)));
  }

  private String printArray(int[] arr){
    String res = "";
    for(int i : arr){
      res += i;
    }
    return res;
  }

  private int[] rightToLeft(int[] arr) {
    int right = arr[arr.length-1];
    int[] result = new int[arr.length];
    for(int i = 1; i < arr.length; i++){
      result[i] = arr[i-1];
    }
    result[0] = right;
    for(int i : result){
      System.out.println(i);
    }
    return result;
  }
}
