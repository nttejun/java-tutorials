package data.structure.array;

import org.junit.Test;

public class RearrangeMaxMinArray {
  @Test
  public void rearrangeMaxMinArray(){
    int[] arr = {1,2,3,4,5};
    rearrangeMaxMinArray(arr);
  }

  private void rearrangeMaxMinArray(int[] arr) {
    sort(arr, 0, arr.length-1);
  }

  private void sort(int[] arr, int l, int r) {
    int partition = partition(arr, l, r);
  }

  private int partition(int[] arr, int l, int r) {

    return l;
  }
}
