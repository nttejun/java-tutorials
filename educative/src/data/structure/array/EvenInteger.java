package data.structure.array;

import org.junit.Assert;
import org.junit.Test;

// 반복문이 2회 수행되므로 2n 시간복잡도 -> 계수를 제외하면 -> 시간복잡도 = O(n)
public class EvenInteger {
  public int[] removeEvenNumber(int[] arr) {
    return getRemovedArr(arr, createEmptyArr(arr));
  }

  private int[] createEmptyArr(int[] arr) {
    int removedArrIdx = 0;
    for (int i : arr) {
      if (i % 2 != 0) {
        removedArrIdx++;
      }
    }
    return new int[removedArrIdx];
  }

  private int[] getRemovedArr(int[] arr, int[] removedEvenArr) {
    int idx = 0;
    for (int i : arr) {
      if (i % 2 != 0) {
        removedEvenArr[idx] = i;
        idx++;
      }
    }
    return removedEvenArr;
  }

  public String intArrayToString(int[] arr){
    String res  = "";
    for(int value : arr){
      res = res + value;
    }
    return res;
  }

  @Test
  public void removeAll() {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
    Assert.assertEquals(1, removeEvenNumber(arr)[0]);
    Assert.assertEquals(3, removeEvenNumber(arr)[1]);
    Assert.assertEquals(5, removeEvenNumber(arr)[2]);
    Assert.assertEquals(7, removeEvenNumber(arr)[3]);
    Assert.assertEquals(4, removeEvenNumber(arr).length);
    Assert.assertEquals("1357", intArrayToString(removeEvenNumber(arr)));
  }
}
