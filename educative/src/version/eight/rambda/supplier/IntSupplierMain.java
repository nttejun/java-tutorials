package version.eight.rambda.supplier;

import java.util.function.IntSupplier;

public class IntSupplierMain {

  public static void main(String args[]) {
    IntSupplier supplier = () -> (int) (Math.random() * 100);
    System.out.println(supplier.getAsInt());
  }
}
