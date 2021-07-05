public class Main {
    public static void main(String[] args) {
        Time startTime1 = new Time(12, 15);
        Time startTime2 = new Time(23, 5);
        Time startTime3 = new Time(9, 5);

        Time duration1 = new Time(1, 0);
        Time duration2 = new Time(2, 15);
        Time duration3 = new Time(1, 15);

        Movie movie1 = new Movie("Зоряні війни", duration1);
        Movie movie2 = new Movie("За двума зайцями", duration2);
        Movie movie3 = new Movie("Фараон", duration3);

        Seance seance1 = new Seance(movie1, startTime1);
        Seance seance2 = new Seance(movie2, startTime2);
        Seance seance3 = new Seance(movie3, startTime3);

        Cinema cinema = new Cinema(new Time(9, 00), new Time(23, 59));

        cinema.addSeances("Monday", seance1, seance2, seance3);

        cinema.addSeance("Tuesday", seance1);
        cinema.addSeances("Friday", seance1, seance3);

        cinema.removeMovie(movie3);
        cinema.removeSeance("Monday", seance1);
        System.out.println(cinema);
    }
}

