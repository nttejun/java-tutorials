package data.structure.array;

import org.junit.Assert;
import org.junit.Test;

public class FindSecondMaximumValueInArray {
  @Test
  public void findSecondMaxValue(){
    int[] arr = {1,0,20,99,8,88,9,2,3,6};
    Assert.assertEquals(88, findSecondMaxValue(arr));
  }

  private int findSecondMaxValue(int[] arr) {
    int max = -99999;
    int secondMax = -99999;
    for(int i : arr){
      if(secondMax < i){
        if(max < i){
          secondMax = max;
          max = i;
          continue;
        }
        secondMax = i;
      }
    }
    return secondMax;
  }
}
