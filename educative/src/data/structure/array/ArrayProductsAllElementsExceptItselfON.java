package data.structure.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayProductsAllElementsExceptItselfON {

  @Test
  public void findProduct() {
    int[] arr = {1, 2, 3, 4};
    Assert.assertEquals("[24,12,8,6]", printString(findProduct(arr)));
  }

  private String printString(int[] product) {
    String result = "[";
    for (int i : product) {
      result = result + i + ",";
    }
    result = result.substring(0, result.length() - 1);
    result = result + "]";
    return result;
  }

  private int[] findProduct(int[] arr) {
    int total = 1;
    int len = arr.length;
    int[] result = new int[len];
    for (int i : arr) {
      total *= i;
    }

    int index = 0;
    for (int i : arr) {
      result[index] = total / i;
      index++;
    }

    return result;
  }
}
