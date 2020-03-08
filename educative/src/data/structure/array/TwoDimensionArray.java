package data.structure.array;

import org.junit.Assert;
import org.junit.Test;

public class TwoDimensionArray {

  private int rows = 3;
  private int columns = 4;

  @Test
  public void initialization1() {
    int[][] twoDimensionArray;
    twoDimensionArray = new int[rows][columns];
    twoDimensionArray[0][0] = 10;
    Assert.assertEquals(10, twoDimensionArray[0][0]);
  }

  @Test
  public void initialization2() {
    int[][] twoDimensionArray = new int[rows][columns];
    twoDimensionArray[0][0] = 10;
    Assert.assertEquals(10, twoDimensionArray[0][0]);
  }

  @Test
  public void assignLoop() {
    int[][] twoDimensionArray = new int[10][10];
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        twoDimensionArray[i][j] = i + j;
        Assert.assertEquals(i + j, twoDimensionArray[i][j]);
      }
    }
  }

  @Test
  public void assignClassroom() {
    int[][] teacherAssignmentClassroom = new int[5][2];
    int classroom = 0;
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 2; j++) {
        teacherAssignmentClassroom[i][j] = classroom;
        classroom++;
      }
    }
    Assert.assertEquals(0, teacherAssignmentClassroom[0][0]);
    Assert.assertEquals(8, teacherAssignmentClassroom[4][0]);
    Assert.assertEquals(9, teacherAssignmentClassroom[4][1]);
  }
}