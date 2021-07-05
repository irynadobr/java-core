import java.util.Iterator;
import java.util.Objects;
import java.util.TreeMap;

public class Cinema {
    private TreeMap<Days, Schedule> cinema;
    private Time open;
    private Time close;

    public Cinema() {
    }

    public Cinema(Time open, Time close) {
        this.cinema = new TreeMap<>();
        setOpen(open);
        setClose(close);
    }

    public TreeMap<Days, Schedule> getCinema() {
        return cinema;
    }

    public void setCinema(TreeMap<Days, Schedule> cinema) {
        this.cinema = cinema;
    }

    public Time getOpen() {
        return open;
    }

    public void setOpen(Time open) {
        if (open.getHour() == 9 && open.getMin() == 0)
            this.open = open;
    }

    public Time getClose() {
        return close;
    }

    public void setClose(Time close) {
        if (close.getHour() == 23 && close.getMin() == 59)
            this.close = close;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cinema cinema1 = (Cinema) o;
        return Objects.equals(cinema, cinema1.cinema) && Objects.equals(open, cinema1.open) && Objects.equals(close, cinema1.close);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cinema, open, close);
    }

    @Override
    public String toString() {
        return "Cinema: " + "\r\n"
                + cinema +
                ", open=" + open +
                ", close=" + close +
                '}';
    }

    public void print() {
        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    public void addSeances(String day, Seance... seances) {
        for (Seance seance : seances) {
            addSeance(day, seance);
        }
        System.out.println("Графік сеансів кінотеатру:  " + "\r\n" + cinema +
                " open cinema: " + open + "  close cinema: " + close);
        print();
    }


    public void addSeance(String day, Seance seance) {
        if (considerationCloseAndOpenAtFormationSeance(seance) == false)
            return;
        for (Days days : Days.values()) {
            if (days.name().equals(day)) {

                if (cinema.containsKey(days)) {
                    cinema.get(days).addSeance(seance);
                    System.out.println(day);
                    print();
                    return;
                }
                Schedule schedule = new Schedule();
                schedule.addSeance(seance);
                cinema.put(days, schedule);
                System.out.println(day);
                print();
                return;
            }
        }
        System.out.println("в " + day + " кінотеатр не працює, " + seance + " не додано до графіку");
    }

    public void removeMovie(Movie movie) {
        int s = 0;
        int s1 = 0;
        System.out.println("Дні роботи кінотеатру " + cinema.keySet());
        Iterator<Schedule> scheduleIterator = this.cinema.values().iterator();
        while (scheduleIterator.hasNext()) {
            Schedule schedule = scheduleIterator.next();
            s += schedule.getSeances().size();
            schedule.getSeances().removeIf(seance -> seance.getMovie().equals(movie));
            s1 += schedule.getSeances().size();
        }
        int n = s - s1;
        if (n != 0) {
            print();
            System.out.println("З графіку кінотеатру видалено " + n + " сеанс(и) фільму: " + movie.getTitle());
            print();
        } else {
            System.out.println(" у графіку кінотеатру немає  фільму: " + movie.getTitle());
        }
    }

    public void removeSeance(String day, Seance seance) {
        for (Days days : Days.values()) {
            if (days.name().equals(day)) {
                if (cinema.containsKey(days)) {
                    if (cinema.get(days).getSeances().contains(seance)) {
                        print();
                        cinema.get(days).removeSeance(seance);
                        print();
                        return;
                    }
                }
                print();
                System.out.println("в " + day + " немає  такого сеансу, " + seance + " не видалено");
                return;
            }
        }
        print();
        System.out.println("в " + day + " кінотеатр не працює, " + seance + " не видалено з графіку");
    }

    public boolean considerationCloseAndOpenAtFormationSeance(Seance seance) {
        if (getOpen() == null || getClose() == null) {
            print();
            System.out.println("Не введено час відкриття і закриття кінотеатру");
            return false;
        }
        int considerationCloseHourAtformationSeance = close.getHour() - seance.getEndTime().getHour();
        int considerationOpenHourAtformationSeances = seance.getStartTime().getHour() - this.open.getHour();
        if (considerationCloseHourAtformationSeance < 0 ||
                (considerationCloseHourAtformationSeance == 0 &&
                        (close.getMin() - seance.getEndTime().getMin()) < 0) ||
                (considerationOpenHourAtformationSeances < 0) ||
                (considerationOpenHourAtformationSeances == 0 &&
                        (seance.getStartTime().getMin() - this.open.getMin()) < 0)) {
            System.out.println("При формуванні сеансу: " + seance + " не враховано час відкриття і закриття кінотеатру" + "\r\n" +
                    " фільм: " + seance.getMovie().getTitle() + " не додано до графіку сеансів, " + "\r\n" + "кінотеатр в цей час зачинено.");
            print();
            return false;
        }
        return true;
    }
}





