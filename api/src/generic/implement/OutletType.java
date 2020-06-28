package generic.implement;

public class OutletType implements Type {

  public String type;

  OutletType(String type) {
    this.type = type;
  }

  @Override
  public String getType() {
    return this.type;
  }
}
