package data.structure.array;

import org.junit.Assert;
import org.junit.Test;

public class RearrangeMaxMinArray {

  @Test
  public void rearrangeMaxMinArray() {
    int[] arr = {100, 200, 300, 400, 500};
    rearrangeMaxMinArray(arr);
  }

  private void rearrangeMaxMinArray(int[] arr) {
    sort(arr, 0, arr.length-1);
    Assert.assertEquals("500100400200300", printArray(maxMinValue(arr)));
  }

  private String printArray(int[] arr){
    String res = "";
    for(int i : arr){
      res += i;
    }
    return res;
  }

  private void sort(int[] arr, int l, int r) {
    int pivotIndex = partition(arr, l, r);
     if(l < pivotIndex-1){
       sort(arr, l, pivotIndex-1);
     }
    if(pivotIndex < r){
      sort(arr, pivotIndex, r);
    }
  }

  private int partition(int[] arr, int l, int r) {
    int pivot = arr[(l + r) / 2];
    while (l <= r) {
      while (arr[l] < pivot) {
        l++;
      }
      while (pivot < arr[r]){
        r--;
      }
      if(l <= r){
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

  private int[] maxMinValue(int[] arr) {
    int[] result = new int[arr.length];
    int start = 0;
    int end = arr.length-1;
    boolean flag = false;

    for(int i=0; i<arr.length; i++){
      if(flag == true){
        result[i] = arr[start];
        start++;
        flag = false;
      } else {
        result[i] = arr[end];
        end--;
        flag = true;
      }
    }

    return result;
  }
}
