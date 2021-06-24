import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        Prince prince = new Prince(1, "Robert", 34);

        ArrayList<Cinderella> cinderellas = new ArrayList<>();
        cinderellas.add(new Cinderella(1, "Olga", 40));
        cinderellas.add(new Cinderella(2, "Mari", 34));
        cinderellas.add(new Cinderella(3, "Magda", 42));
        cinderellas.add(new Cinderella(4, "Inga", 38));
        cinderellas.add(new Cinderella(5, "Ilona", 39));
        cinderellas.add(new Cinderella(6, "Anna", 37));
        cinderellas.add(new Cinderella(7, "Natalie", 35));

        for (Cinderella cinderella : cinderellas) {
            if (cinderella.getSize() == prince.getFoundedShoe()) {
                System.out.println(cinderella.getName() + " - попелюшка, яка загубила туфельку");
            }
        }
    }
}
