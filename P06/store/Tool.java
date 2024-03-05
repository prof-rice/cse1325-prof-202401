package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Tool extends Product {
    public Tool(String name, int price) {
        super(name, price);
    }
    public Tool(BufferedReader br) throws IOException {
        super(br);
    }
    // Inherit save from the superclass - no changes!
}
