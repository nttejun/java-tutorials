package data.structure.array;

import org.junit.Assert;
import org.junit.Test;

public class OneDimensionArray {

  @Test
  public void initIntArrayCase1() {
    int intArray[];
    intArray = new int[]{1, 2, 3, 4, 5};
    Assert.assertEquals(4, intArray[3]);
    Assert.assertEquals(5, intArray[4]);
  }

  @Test
  public void initIntArrayCase2() {
    int[] intArray = {1, 2, 3, 4, 5};
    Assert.assertEquals(4, intArray[3]);
    Assert.assertEquals(5, intArray[4]);
  }
}
