package data.structure.stack;

import org.junit.Assert;
import org.junit.Test;

public class PostfixStack {

  public int calculate(String expression) {

    Stack<Integer> stack = new Stack<>(expression.length());

    for (int i = 0; i < expression.length(); i++) {
      char expre = expression.charAt(i);

      if (!Character.isDigit(expre)) {
        Integer pop1 = stack.pop();
        Integer pop2 = stack.pop();

        switch (expre) {
          case '+':
            stack.push(pop2 + pop1);
            break;
          case '-':
            stack.push(pop2 - pop1);
            break;
          case '*':
            stack.push(pop2 * pop1);
            break;
          case '/':
            stack.push(pop2 / pop1);
            break;
        }
      } else {
        stack.push(Character.getNumericValue(expre));
      }
    }
    return stack.pop();
  }

  @Test
  public void cal() {
    Assert.assertEquals(3, calculate("921*-8-4+"));
    Assert.assertEquals(13, calculate("1028*+3-"));
    Assert.assertEquals(8, calculate("642/+"));
    Assert.assertEquals(-5, calculate("34-5*"));
  }
}