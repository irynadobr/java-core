import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Schedule {

    private Set<Seance> seances;

    public Schedule() {
        this.seances = new TreeSet<>();
    }

    public Set<Seance> getSeances() {
        return seances;
    }

    public void setSeanses(Set<Seance> seanses) {
        this.seances = seanses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(seances, schedule.seances);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seances);
    }

    @Override
    public String toString() {
        return "\r\n" +
                this.seances + "\r\n";
    }

    public void addSeance(Seance seance) {
        if (seances.contains(seance)) {
            System.out.println("Сеанс " + seance + " вже існує");
            return;
        }
        seances.add(seance);
        System.out.println(seance + "додано до графіку сеансів");
    }


    public void removeSeance(Seance seance) {
        if (seances.isEmpty()) {
            System.out.println("Неможливо видалити " + seance + " сеанс, в графіку не має жодного сеансу");
            return;
        }
        Iterator<Seance> iterator = seances.iterator();
        while (iterator.hasNext()) {
            Seance seanceFilm = iterator.next();
            if (seanceFilm.equals(seance)) {
                iterator.remove();
                System.out.println(seance + "видалено з графіку");
                return;
            }
        }
        System.out.println("Такого " + seance + " в графіку не має");
    }
}

