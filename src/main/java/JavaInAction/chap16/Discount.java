package JavaInAction.chap16;


import static JavaInAction.chap16.v1.Util.delay;
import static JavaInAction.chap16.v1.Util.format;

public class Discount {

  public static String applyDiscount(Quote quote) {
    return quote.getShopName() + " price is " + Discount.apply(quote.getPrice(), quote.getDiscountCode());
  }

  private static double apply(double price, Code code) {
    delay();
    return format(price * (100 - code.percentage) / 100);
  }

  public enum Code {
    NONE(0),
    SILVER(5),
    GOLD(10),
    PLATINUM(15),
    DIAMOND(20);

    private final int percentage;

    Code(int percentage) {
      this.percentage = percentage;
    }
  }
}
