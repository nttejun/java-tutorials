package data.structure.array;

import java.util.HashMap;
import org.junit.Assert;
import org.junit.Test;

public class ArrayProductsAllElementsExceptItselfON2 {

  @Test
  public void findProduct() {
    int[] arr = {1, 2, 3, 4};
    Assert.assertEquals("[24,12,8,6]", printString(findProduct(arr)));
  }

  private String printString(HashMap product) {
    String result = "[";
    for (int i = 0; i < product.size(); i++) {
      result = result + product.get(i) + ",";
    }
    result = result.substring(0, result.length() - 1);
    result = result + "]";
    return result;
  }

  private HashMap findProduct(int[] arr) {
    HashMap product = new HashMap();

    for (int i = 0; i < arr.length; i++) {
      int result = 1;
      for (int j = 0; j < arr.length; j++) {
        if (j == i) {
          continue;
        }
        result = result * arr[j];
      }
      product.put(i, result);
      result = 1;
    }
    return product;
  }
}
