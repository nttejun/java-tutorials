package exam.responsibility.moviereservation;

import java.time.Duration;
import java.util.Arrays;

public class AmountDiscountMovie extends Movie{
    private Money discountAmount;

    public AmountDiscountMovie(String title, Duration runningTime, Money fee, Money discountAmount, DiscountCondition... discountConditions){
        super(title, runningTime, fee, Arrays.asList(discountConditions));
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money calculateDiscountAmount() {
        return discountAmount;
    }
}
