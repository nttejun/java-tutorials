package data.structure.array;

import org.junit.Assert;
import org.junit.Test;

public class RearrangePositiveNegativeValues {

  @Test
  public void reArrange() {
    int[] arr = {10, -1, 20, 4, 5, -9, -6};
    Assert.assertEquals("-1-9-6102045", printArray(reArrange(arr)));
  }

  private String printArray(int[] arr){
    String res = "";
    for(int i : arr){
      res += i;
    }
    return res;
  }

  private int[] reArrange(int[] arr) {
    int minIdx = 0;
    for (int i : arr) {
      if (i < 0) {
        minIdx++;
      }
    }

    int[] newArray = new int[arr.length];

    int negativeIdx = 0;
    int positiveIdx = minIdx;
    for (int i : arr) {
      if (i < 0) {
        newArray[negativeIdx] = i;
        negativeIdx++;
      } else {
        newArray[positiveIdx] = i;
        positiveIdx++;
      }
    }
    return newArray;
  }
}
