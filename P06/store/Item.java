package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.lang.reflect.Constructor;

public class Item {
    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    public Item(BufferedReader br) throws IOException {
        String subclass = br.readLine();
//        if(subclass.equals("Plant")) this.product = new Plant(br);
//        else if(subclass.equals("Tool")) this.product = new Tool(br);
//        else throw new IOException("Unknown Product subclass: " + subclass);
        if(subclass.equals("store.Plant")) this.product = new Plant(br);
        else if(subclass.equals("store.Tool")) this.product = new Tool(br);
        else throw new IOException("Unknown Product subclass: " + subclass);
//        Class<?> clazz = Class.forName(subclass);
//        Constructor<?> ctor = clazz.getContructor(BufferedReader.class);
//        this.product = ctor.newInstance(br);
        this.quantity = Integer.parseInt(br.readLine());
    }
    public void save(BufferedWriter bw) throws IOException {
        bw.write(product.getClass().getName() + '\n');
//         bw.write(product.getClass().getSimpleName() + '\n');
        product.save(bw);
        bw.write("" + quantity + '\n');
    }
    public int getPrice() {
        return product.getPrice() * quantity;
    }
    @Override
    public String toString() {
        int price = getPrice();
        return String.format("%3d %-50s $ %5d.%02d", quantity, product, price/100, price%100);
    }
    private Product product;
    private int quantity;
}
