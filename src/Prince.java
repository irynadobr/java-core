import java.util.Objects;

public class Prince {

    private int id;
    private String name;
    private int foundedShoe;

    public Prince() {
    }

    public Prince(int id, String name, int foundedShoe) {
        this.id = id;
        this.name = name;
        this.foundedShoe = foundedShoe;
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

    public int getFoundedShoe() {
        return foundedShoe;
    }

    public void setFoundedShoe(int foundedShoe) {
        this.foundedShoe = foundedShoe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prince prince = (Prince) o;
        return id == prince.id && foundedShoe == prince.foundedShoe && Objects.equals(name, prince.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, foundedShoe);
    }

    @Override
    public String toString() {
        return "Prince{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", foundedShoe=" + foundedShoe +
                '}';
    }

    public void Cinderella (int sizeCinderella, String nameCinderella) {
        if (sizeCinderella == foundedShoe) {
          System.out.println(nameCinderella + " - попелюшка, яка загубила туфельку");
        }
    }

}
