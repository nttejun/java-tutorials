package eaxm.object.moviesreservation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PercentDiscountPolicy implements DiscountPolicy {
    private List<DiscountCondition> conditions = new ArrayList<>();
    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition ... conditions) {
        this.conditions = Arrays.asList(conditions);
        this.percent = percent;
    }

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
