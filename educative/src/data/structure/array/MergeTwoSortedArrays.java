package data.structure.array;

import org.junit.Assert;
import org.junit.Test;

public class MergeTwoSortedArrays {
  private String printArr(int[] arr){
    String res = "";
    for(int v : arr){
      res = res+v+" ";
    }
    return res;
  }

  private int[] mergeTwoSortedArrays(int[] aArr, int[] bArr) {
    int aSize = aArr.length;
    int bSize = bArr.length;
    int[] sortedArray = new int[aSize+bSize];
    int i = 0;
    int j = 0;
    int k = 0;
    while(i < aSize && j < bSize){
      if(aArr[i] > bArr[j]){
        sortedArray[k++] = bArr[j++];
      } else {
        sortedArray[k++] = aArr[i++];
      }
    }

    while (i < aSize){
      sortedArray[k++] = aArr[i++];
    }
    while (j < bSize){
      sortedArray[k++] = bArr[j++];
    }
    return sortedArray;
  }

  @Test
  public void mergeTwoSortedArrays(){

    int[] aArr = {1,3,5,7,11,23,24,29,30};
    int[] bArr = {0,1,2,5,6,7,9,11,19,27};

    int[] res = mergeTwoSortedArrays(aArr, bArr);
    Assert.assertEquals("0 1 1 2 3 5 5 6 7 7 9 11 11 19 23 24 27 29 30 ", printArr(res));
  }
}
