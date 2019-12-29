package exam.object.moviesreservation;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
