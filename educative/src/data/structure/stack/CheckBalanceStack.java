package data.structure.stack;

import org.junit.Assert;
import org.junit.Test;

public class CheckBalanceStack {

  boolean isBalanced(String expression) {

    Stack<String> stack = new Stack<>(expression.length());

    for (int i = 0; i < expression.length(); i++) {

      String expressionVal = String.valueOf(expression.charAt(i));

      if (expressionVal.equals("{") || expressionVal.equals("[") || expressionVal.equals("(")) {
        stack.push(expressionVal);

      } else {
        switch (expressionVal) {
          case "}": {
            if (!stack.pop().equals("{")) {
              return false;
            }
            break;
          }
          case "]": {
            if (!stack.pop().equals("[")) {
              return false;
            }
            break;
          }
          case ")": {
            if (!stack.pop().equals("(")) {
              return false;
            }
            break;
          }
        }

      }
    }
    if (stack.isEmpty()) return true;
    return false;
  }

  @Test
  public void isBalanced() {
    Assert.assertEquals(true, isBalanced("{[()]}"));
    Assert.assertEquals(false, isBalanced("[{(}]"));
  }
}
