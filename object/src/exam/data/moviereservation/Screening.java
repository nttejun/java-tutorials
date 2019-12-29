package exam.data.moviereservation;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    private int sequnce;
    private LocalDateTime whenScreened;

    public Movie getMovie(){
        return movie;
    }

    public void setMovie(Movie movie){
        this.movie = movie;
    }

    public int getSequnce(){
        return sequnce;
    }

    public void setSequnce(int sequnce){
        this.sequnce = sequnce;
    }

    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }

    public void setWhenScreened(LocalDateTime whenScreened){
        this.whenScreened = whenScreened;
    }

}
