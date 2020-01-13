package exam.data.moviereservation;

public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        boolean discountable = checkDiscountable(screening);
        Money fee = calculateFee(screening, discountable, audienceCount);
        return createReservation(screening, customer, audienceCount, fee);

    }

    private boolean checkDiscountable(Screening screening) {
        return screening.getMovie().getDiscountConditions().stream()
                .anyMatch(condition -> isDiscountable(screening, condition));
    }

    private boolean isDiscountable(Screening screening, DiscountCondition condition) {
        if (condition.getType() == DiscountConditionType.PERIOD) {
            return isSatisfiedByPeriod(screening, condition);
        }
        return isSatisfiedBySequence(screening, condition);
    }

    private boolean isSatisfiedByPeriod(Screening screening, DiscountCondition condition) {
        return screening.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek()) &&
                condition.getStartTime().compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
                condition.getEndTime().compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
    }

    private boolean isSatisfiedBySequence(Screening screening, DiscountCondition condition) {
        return condition.getSequence() == screening.getSequnce();
    }

    private Money calculateFee(Screening screening, boolean discountable, int audienceCount) {
        if (discountable) {
            return screening.getMovie().getFee()
                    .minus(calculateDiscountFee(screening.getMovie()))
                    .times(audienceCount);
        }

        return screening.getMovie().getFee();
    }

    private Money calculateDiscountFee(Movie movie) {
        switch (movie.getMovieType()) {
            case AMOUNT_DISCOUNT:
                return calculateAmountDiscountedFee(movie);
            case PERCENT_DISCOUNT:
                return calculatePercentDiscountedFee(movie);
            case NONE_DISCOUNT:
                return calculateNoneDiscountedFee(movie);
        }

        throw new IllegalArgumentException();
    }

    private Money calculateAmountDiscountedFee(Movie movie) {
        return movie.getDiscountAmount();
    }

    private Money calculatePercentDiscountedFee(Movie movie) {
        return movie.getFee().times(movie.getDiscountPercent());
    }

    private Money calculateNoneDiscountedFee(Movie movie) {
        return movie.getFee();
    }

    private Reservation createReservation(Screening screening, Customer customer, int audienceCount, Money fee) {
        return new Reservation(customer, screening, fee, audienceCount);
    }

}
