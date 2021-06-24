import java.util.Objects;

public class Cinderella {
    private int id;
    private String name;
    private int size;

    public Cinderella(int id, String name, int size) {
        this.id = id;
        this.name = name;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        Cinderella that = (Cinderella) o;
        return id == that.id && size == that.size && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, size);
    }

    @Override
    public String toString() {
        return "Cinderella{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
