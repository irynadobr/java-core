import java.util.Objects;

public class Computer {
    private String model;
    private int year;
    private int ram;
    private int price;
    private Hard hard;
    private Processor processor;

    public Computer() {
    }

    public Computer(String model, int year, int ram, int price, Hard hard, Processor processor) {
        this.model = model;
        this.year = year;
        this.ram = ram;
        this.price = price;
        this.hard = hard;
        this.processor = processor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Hard getHard() {
        return hard;
    }

    public void setHard(Hard hard) {
        this.hard = hard;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return year == computer.year && ram == computer.ram && price == computer.price && Objects.equals(model, computer.model) && Objects.equals(hard, computer.hard) && Objects.equals(processor, computer.processor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, year, ram, price, hard, processor);
    }

    @Override
    public String toString() {
        return "Computer{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", ram=" + ram +
                ", price=" + price +
                ", hard=" + hard +
                ", processor=" + processor +
                '}';
    }
}
