package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Plant extends Product {
    public Plant(String species, Exposure exposure, int price) {
        super("Plant: " + species, price);
        this.exposure = exposure;
    }
    public Plant(BufferedReader br) throws IOException {
        super(br);
        this.exposure = Exposure.valueOf(br.readLine());
    }
    public void save(BufferedWriter bw) throws IOException {
        super.save(bw);
        bw.write(exposure.name() + '\n');
    }
    public Exposure getExposure() {
        return exposure;
    }
    private Exposure exposure;
}
