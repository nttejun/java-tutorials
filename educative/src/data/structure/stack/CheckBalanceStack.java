package data.structure.stack;

import org.junit.Assert;
import org.junit.Test;

public class CheckBalanceStack {

  boolean isBalanced(String expression){

    return true;
  }

  @Test
  public void isBalanced(){
    Assert.assertEquals(true, isBalanced("{[()]}"));
    Assert.assertEquals(false, isBalanced("[{(}]"));
  }
}
