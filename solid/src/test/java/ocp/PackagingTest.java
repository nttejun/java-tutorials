package ocp;

import org.junit.jupiter.api.Test;

class PackagingTest {

  @Test
  public void pack() {
    Product product = new Product();
    Packaging packaging = new IcePackaging(product);
    packaging.pack();
  }

  @Test
  public void invalidOpenClosePrinciplePack() {
    Product product = new Product();
    Packaging packaging = new HotPackaging(product);
    packaging.invalidOpenClosePrinciplePack(packaging);
  }
}