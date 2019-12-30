package exam.data.moviereservation;

public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        Movie movie = screening.getMovie();

        boolean discountable = false;
        // DiscountCondition 데이터가 변경되면 ReservationAgency 내부 구현도 변경된다 (의존성을 가진 결합상태)
        // 낮은 응집도 : 할인 정책 추가, 요금 계산방법 추가 등이 발생하는 경우 -> 변경의 이유가 다른 코드들이 하나의 모듈 안에 있어 서로에게 영향이 있다.
        for (DiscountCondition condition : movie.getDiscountConditions()) {
            if (condition.getType() == DiscountConditionType.PERIOD) {
                discountable = screening.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek()) &&
                        condition.getStartTime().compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
                        condition.getEndTime().compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
            } else {
                discountable = condition.getSequence() == screening.getSequnce();
            }

            if (discountable) {
                break;
            }
        }

        Money fee;
        if (discountable) {
            Money discountAmount = Money.ZERO;
            switch (movie.getMovieType()) {
                case AMOUNT_DISCOUNT:
                    discountAmount = movie.getDiscountAmount();
                    break;
                case PERCENT_DISCOUNT:
                    discountAmount = movie.getFee().times(movie.getDiscountPercent());
                    break;
                case NONE_DISCOUNT:
                    discountAmount = Money.ZERO;
                    break;
            }

            // 아래 코드의 문제점
            // movie의 getFee 메서드 호출 결과를 Money 타입의 fee로 저장하고 있다
            // fee 타입이 변경되면 getFee 메서드 호출부인 ReservationAgency 구현도 변경된 타입으로 수정되어야 하는 높은 결합 구조에 있다
            fee = movie.getFee().minus(discountAmount).times(audienceCount);
        } else {
            fee = movie.getFee();
        }

        return new Reservation(customer, screening, fee, audienceCount);

    }

}
