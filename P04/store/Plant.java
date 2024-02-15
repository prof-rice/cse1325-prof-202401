package store;

public class Plant extends Product {
    public Plant(String species, Exposure exposure, int price) {
        super("Plant: " + species, price);
        this.exposure = exposure;
    }
    public Exposure getExposure() {
        return exposure;
    }
    private Exposure exposure;
}
