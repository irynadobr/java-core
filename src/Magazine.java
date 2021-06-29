import java.util.ArrayList;
import java.util.Objects;

public class Magazine implements Printable {

    private String nameMagazine;
    private int yearOfPublicationMagazine;

    public Magazine() {
    }

    public Magazine(String nameMagazine, int yearOfPublicationMagazine) {
        this.nameMagazine = nameMagazine;
        this.yearOfPublicationMagazine = yearOfPublicationMagazine;
    }

    public String getNameMagazine() {
        return nameMagazine;
    }

    public void setNameMagazine(String nameMagazine) {
        this.nameMagazine = nameMagazine;
    }

    public int getYearOfPublicationMagazine() {
        return yearOfPublicationMagazine;
    }

    public void setYearOfPublicationMagazine(int yearOfPublicationMagazine) {
        this.yearOfPublicationMagazine = yearOfPublicationMagazine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Magazine magazine = (Magazine) o;
        return yearOfPublicationMagazine == magazine.yearOfPublicationMagazine && Objects.equals(nameMagazine, magazine.nameMagazine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameMagazine, yearOfPublicationMagazine);
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "nameMagazine='" + nameMagazine + '\'' +
                ", yearOfPublicationMagazine=" + yearOfPublicationMagazine +
                '}';
    }


    static void printMagazines(Printable[] printable) {
        System.out.println("names mgazines: ");
        for (Printable printables : printable) {
            if (printables instanceof Magazine) {
                System.out.println(((Magazine) printables).nameMagazine);
            }
        }
    }

    @Override
    public void print() {
        System.out.println("Name magazine is " + this.getNameMagazine() + ",  year of publication is " + this.getYearOfPublicationMagazine());
    }
}
