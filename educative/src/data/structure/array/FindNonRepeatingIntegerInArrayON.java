package data.structure.array;

import java.util.HashMap;
import org.junit.Assert;
import org.junit.Test;

public class FindNonRepeatingIntegerInArrayON {

  @Test
  public void findFirstUnique(){
    int[] arr = {11,33,22,11,22,44,33};
    Assert.assertEquals(44, findFirstUnique(arr));
  }

  private int findFirstUnique(int[] arr) {

    HashMap<Integer, Integer> hashMap = new HashMap<>();

    for(int i : arr){
      if(hashMap.get(i) != null){
        hashMap.put(i, hashMap.get(i)+1);
      } else {
        hashMap.put(i, 1);
      }
    }

    for(int i : arr){
      if(hashMap.get(i) == 1){
        return i;
      }
    }
    return 0;
  }
}
