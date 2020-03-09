package data.structure.array;

import org.junit.Assert;
import org.junit.Test;

// 
public class EvenInteger {

  public int[] removeEvenNumber(int[] arr) {

    int removedArrayIndex = 0;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] % 2 != 0) {
        removedArrayIndex++;
      }
    }

    int[] removedArray = new int[removedArrayIndex];
    int index = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] % 2 != 0) {
        removedArray[index] = arr[i];
        index++;
      }
    }
    return removedArray;
  }

  public String intArrayToString(int[] arr){
    String result  = "";
    for(int value : arr){
      result = result + value;
    }
    return result;
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
