package data.structure.array;

import org.junit.Assert;
import org.junit.Test;

public class FindMinimumValueInArray {
  @Test
  public void findMinValue(){
    int[] values = {10, 20, 5, 4};
    int[] values1 = {-10, -20, -5, -4};
    Assert.assertEquals(4, findMinValue(values));
    Assert.assertEquals(-20, findMinValue(values1));
  }

  private int findMinValue(int[] values) {
    int temp = values[0];
    for(int i : values){
      if(i < temp){
        temp = i;
      }
    }
    return temp;
  }
}
