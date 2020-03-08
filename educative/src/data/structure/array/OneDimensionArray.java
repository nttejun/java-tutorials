package data.structure.array;

import org.junit.Assert;
import org.junit.Test;

public class OneDimensionArray {

  @Test
  public void initArrayCase1() {
    int arraySample1[];
    arraySample1 = new int[]{1, 2, 3, 4, 5};
    Assert.assertEquals(4, arraySample1[3]);
    Assert.assertEquals(5, arraySample1[4]);
  }

  @Test
  public void initArrayCase2() {
    int[] arraySample1 = {1, 2, 3, 4, 5};
    Assert.assertEquals(4, arraySample1[3]);
    Assert.assertEquals(5, arraySample1[4]);
  }
}
