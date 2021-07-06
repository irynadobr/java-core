import java.util.Objects;

public class Processor {
    private String type;
    private int numberOfNuclei;
    private int frequency;
    private ProductionCountry manufacturer;

    public Processor() {
    }

    public Processor(String type, int numberOfNuclei, int frequency, ProductionCountry manufacturer) {
        this.type = type;
        this.numberOfNuclei = numberOfNuclei;
        this.frequency = frequency;
        this.manufacturer = manufacturer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumberOfNuclei() {
        return numberOfNuclei;
    }

    public void setNumberOfNuclei(int numberOfNuclei) {
        this.numberOfNuclei = numberOfNuclei;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public ProductionCountry getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(ProductionCountry manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Processor processor = (Processor) o;
        return numberOfNuclei == processor.numberOfNuclei && frequency == processor.frequency && Objects.equals(type, processor.type) && manufacturer == processor.manufacturer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, numberOfNuclei, frequency, manufacturer);
    }

    @Override
    public String toString() {
        return "Processor{" +
                "type='" + type + '\'' +
                ", numberOfNuclei=" + numberOfNuclei +
                ", frequency=" + frequency +
                ", manufacturer=" + manufacturer +
                '}';
    }
}
