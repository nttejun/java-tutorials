package eaxm.object.moviesreservation;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);

}
