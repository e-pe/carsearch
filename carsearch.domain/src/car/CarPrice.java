package car;

public class CarPrice {
    private String value;

    public CarPrice(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
