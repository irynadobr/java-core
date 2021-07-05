import java.util.Objects;

public class Seance implements Comparable<Seance> {
    private Movie movie;
    private Time startTime;
    private Time endTime;

    public Seance() {
    }

    public Seance(Movie movie, Time startTime) {
        this.movie = movie;
        this.startTime = startTime;
        endTime();
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seance seance = (Seance) o;
        return Objects.equals(movie, seance.movie) && Objects.equals(startTime, seance.startTime) && Objects.equals(endTime, seance.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movie, startTime, endTime);
    }

    @Override
    public String toString() {
        return "\r\n" + "Seanse: " + "\r\n" +
                movie + "\r\n" +
                " startTime=" + startTime +
                ", endTime=" + endTime;
    }

    public void endTime() {
        int min = startTime.getMin() + movie.getDuration().getMin();
        int hour = startTime.getHour() + movie.getDuration().getHour();
        if (min > 59) {
            hour += 1;
            min -= 60;
        }
        if (hour > 23) {
            hour -= 24;
        }
        this.endTime = new Time(hour, min);
    }

    @Override
    public int compareTo(Seance seance) {
        int startTimeHour = this.startTime.getHour() - seance.getStartTime().getHour();
        int startTimeMin = this.startTime.getMin() - seance.getStartTime().getMin();
        if (startTimeHour != 0) {
            return startTimeHour;
        } else
            return startTimeMin;
    }
}
