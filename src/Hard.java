import java.util.Objects;

public class Hard {
    private String model;
    private TypeHard type;
    private int volume;
    private ProductionCountry manufacturer;

    public Hard() {
    }

    public Hard(String model, TypeHard type, int volume, ProductionCountry manufacturer) {
        this.model = model;
        this.type = type;
        this.volume = volume;
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public TypeHard getType() {
        return type;
    }

    public void setType(TypeHard type) {
        this.type = type;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
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
        Hard hard = (Hard) o;
        return volume == hard.volume && Objects.equals(model, hard.model) && type == hard.type && manufacturer == hard.manufacturer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, type, volume, manufacturer);
    }

    @Override
    public String toString() {
        return "Hard{" +
                "model='" + model + '\'' +
                ", type=" + type +
                ", volume=" + volume +
                ", manufacturer=" + manufacturer +
                '}';
    }
}