package generic;

public class GenericSampleMain {

  public static void main(String[] args) {
    DiscountType<OuletDiscountType> ouletPriceType = new DiscountType<OuletDiscountType>(
        new OuletDiscountType(false, "1000", "2300"));
    DiscountType<EditDiscountType> editPriceType = new DiscountType<EditDiscountType>(
        new EditDiscountType(false, "1111"));

    Shop<OutletShop> outletShop = new Shop<OutletShop>(new OutletShop("outlet", 2, ouletPriceType));
    Shop<EditShop> editShop = new Shop<EditShop>(new EditShop("edit", 1, editPriceType));

    if (outletShop.shopType instanceof OutletShop) {
      System.out.println("outletShop");
    } else {
      System.out.println("결과 오류");
    }

    if (editShop.shopType instanceof EditShop) {
      System.out.println("editShop");
    } else {
      System.out.println("결과 오류");
    }

    if (ouletPriceType.discountType.dailyDiscountcode != null) {
      System.out.println("아울렛 데일리 할인 코드는 " + ouletPriceType.discountType.dailyDiscountcode);
    } else {
      System.out.println("아울렛 데일리 할인 코드를 일시적으로 제공하고 있지 않습니다.");
    }

    /*** 컴파일 시점에서 오류 발생
     if (editPriceType.discountType.dailyDiscountcode != null) {
     System.out.println("편집샵은 데일리 할인코드가 없습니다.");
     } else {
     System.out.println("편집샵은 데일리 할인코드가 없습니다.");
     }
     */

    /*** 컴파일 시점에서 오류 발생
     DiscountType<String> issueDiscountType = new DiscountType<>("기타 할인");
     System.out.println(issueDiscountType.discountType.dailyDiscountcode);
     */
  }
}
