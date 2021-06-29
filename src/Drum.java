import java.util.Objects;

public class Drum implements Tool {
    private int size;

    public Drum() {
    }

    public Drum(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drum drum = (Drum) o;
        return size == drum.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }

    @Override
    public String toString() {
        return "Drum{" +
                "size=" + size +
                '}';
    }

    @Override
    public void play() {
        System.out.println("playing instrument " + getClass().getName() + "  with  " + "size: " + this.getSize());
    }
}
