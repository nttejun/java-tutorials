package exam.responsibility.moviereservation;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
