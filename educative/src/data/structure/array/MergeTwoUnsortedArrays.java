package data.structure.array;

import org.junit.Assert;
import org.junit.Test;

public class MergeTwoUnsortedArrays {

  public int[] mergeArray(int[] aArr, int[] bArr){
    int[] result = new int[aArr.length + bArr.length];
    int idx = 0;
    for(int arr : aArr){
      result[idx] = arr;
      idx++;
    }
    for(int arr : bArr){
      result[idx] = arr;
      idx++;
    }

    QuickSort quickSort = new QuickSort();
    result = quickSort.quickSort(result);

    return result;
  }

  private String printArr(int[] arr){
    String res = "";
    for(int v : arr){
      res = res+v;
    }
    return res;
  }

  @Test
  public void mergeTwoUnsortedArrays(){
    int[] aArr = {3,3,9,4,7};
    int[] bArr = {7,5,0,1};
    int[] res = mergeArray(aArr, bArr);
    Assert.assertEquals("013345779",printArr(res));
  }
}
