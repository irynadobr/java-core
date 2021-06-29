import java.util.ArrayList;
import java.util.Objects;

public class Book implements Printable {
    private String nameBook;
    private String authorBook;
    private int yearOfPublicationBook;

    public Book() {
    }

    public Book(String nameBook, String authorBook, int yearOfPublicationBook) {
        this.nameBook = nameBook;
        this.authorBook = authorBook;
        this.yearOfPublicationBook = yearOfPublicationBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthorBook() {
        return authorBook;
    }

    public void setAuthorBook(String authorBook) {
        this.authorBook = authorBook;
    }

    public int getYearOfPublicationBook() {
        return yearOfPublicationBook;
    }

    public void setYearOfPublicationBook(int yearOfPublicationBook) {
        this.yearOfPublicationBook = yearOfPublicationBook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return yearOfPublicationBook == book.yearOfPublicationBook && Objects.equals(nameBook, book.nameBook) && Objects.equals(authorBook, book.authorBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameBook, authorBook, yearOfPublicationBook);
    }

    @Override
    public String toString() {
        return "Book{" +
                "nameBook='" + nameBook + '\'' +
                ", authorBook='" + authorBook + '\'' +
                ", yearOfPublicationBook=" + yearOfPublicationBook +
                '}';
    }

    static void printBooks(Printable[] printable) {
        System.out.println("names books: ");
        for (Printable printables : printable) {
            if (printables instanceof Book) {
                System.out.println(((Book) printables).nameBook);
            }
        }
    }

    @Override
    public void print() {
        System.out.println("Name book is " + this.getNameBook() + ", author book is " + this.getAuthorBook() + ", year of publication is " + this.getYearOfPublicationBook());
    }
}
