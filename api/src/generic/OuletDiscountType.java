package generic;

public class OuletDiscountType {

  public boolean isSeasonDiscount;
  public String seasonDiscount;
  public String dailyDiscountcode;

  public OuletDiscountType(boolean isSeasonDiscount, String seasonDiscount,
      String dailyDiscountcode) {
    this.isSeasonDiscount = isSeasonDiscount;
    this.seasonDiscount = seasonDiscount;
    this.dailyDiscountcode = dailyDiscountcode;
  }
}
