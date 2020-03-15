package data.structure.array;

import org.junit.Test;

public class FindTwoNumbersAddUpToNBySorting {
  public int partition(int[] arr, int low, int high){
    int pivot = arr[high];
    int i = low;
    for(int j = low; j < high; j++){
      if(arr[j] <= pivot){

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
      }
    }

    int temp = arr[i];
    arr[i] = arr[high];
    arr[high] = temp;

    return i;
  }

  private void sort(int[] arr, int low, int high) {
    if(low < high) {
      int partition = partition(arr, low, high);
      sort(arr, 0, partition-1);
      sort(arr, partition + 1, high);
    }
  }

  public int[] findSum(int arr[], int n) {
    sort(arr, 0, arr.length-1);
    int[] result = new int[2];
    int first = 0;
    int second = arr.length-1;
    int sum = 0;

    while (first != second) {
      sum = arr[first] + arr[second];

      if(sum < n){
        first++;
      } else if(sum > n){
        second--;
      } else {
        result[0] = arr[first];
        result[1] = arr[second];
        return result;
      }
    }
    return result;
  }

  @Test
  public void findSum(){
    int n = 50;
    int[] arr1 = {13, 4, 2, 7, 8, 10, 40, 50};
    if(arr1.length > 0){
      int[] arr2 = findSum(arr1, n);
      int num1 = arr2[0];
      int num2 = arr2[1];

      if((num1 + num2) != n)
        System.out.println("Not Found");
      else {
        System.out.println("Number 1 = " + num1);
        System.out.println("Number 2 = " + num2);
        System.out.println("Sum = " +  (n) );

      }
    } else {
      System.out.println("Input Array is Empty!");
    }
  }
}
