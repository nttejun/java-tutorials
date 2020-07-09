package version.eight.rambda.supplier;

import java.util.function.DoubleSupplier;

public class DoubleSupplierMain {

  public static void main(String[] args) {
    DoubleSupplier supplier = () -> (int) (Math.random() * 100);
    System.out.println(supplier.getAsDouble());
  }
}
