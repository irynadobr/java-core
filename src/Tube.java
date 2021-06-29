import java.util.Objects;

public class Tube implements Tool {
    int diameter;

    public Tube() {
    }

    public Tube(int diameter) {
        this.diameter = diameter;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tube tube = (Tube) o;
        return diameter == tube.diameter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(diameter);
    }

    @Override
    public void play() {
        System.out.println("playing instrument " + this.getClass().getName() + "  with  " + "diameter: " + this.diameter);
    }
}
