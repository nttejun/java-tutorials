package eaxm.object.moviesreservation;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
