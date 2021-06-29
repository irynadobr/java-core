public class Main {
    public static void main(String[] args) {

        Printable[] printable = new Printable[7];
        printable[0] = new Book("Java", "Bert Beyts", 2018);
        printable[1] = new Magazine("Moda", 2018);
        printable[2] = new Book("JS", "Golovatiy", 2019);
        printable[3] = new Magazine("Health", 2019);
        printable[4] = new Book("Python", "Kerol Vorderman", 2020);
        printable[5] = new Magazine("Zog", 2017);
        printable[6] = new Magazine("Model", 2015);

        for (Printable printables : printable) {
            printables.print();
        }
        Magazine.printMagazines(printable);
        Book.printBooks(printable);
    }
}
