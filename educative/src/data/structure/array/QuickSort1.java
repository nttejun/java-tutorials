package data.structure.array;

import org.junit.Assert;
import org.junit.Test;

public class QuickSort1 {

  @Test
  public void quickSort() {
    int[] arr = {3, 3, 9, 4, 7, 7, 5, 0, 1};
    String res = printRes(quickSort(arr, 0, arr.length-1));

    Assert.assertEquals("013345779", res);
  }

  private String printRes(int[] ints) {
    String res = "";
    for (int i : ints) {
      res += i;
    }
    return res;
  }

  public int[] quickSort(int[] arr, int l, int r) {
    int p = partition(arr, l, r);
    if (l < p-1) {
      quickSort(arr, l, r-1);
    }
    if (p < r) {
      quickSort(arr, p, r);
    }
    return arr;
  }

  private int partition(int[] arr, int l, int r) {
    int pivot = arr[(l + r) / 2];
    while (l <= r) {
      while (arr[l] < pivot) l++;
      while (arr[r] > pivot) r--;
      if (l <= r) {
        swap(arr, l, r);
        l++;
        r--;
      }
    }
    return l;
  }

  private void swap(int[] arr, int l, int r) {
    int temp = arr[l];
    arr[l] = arr[r];
    arr[r] = temp;
  }
}
