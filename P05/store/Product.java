package store;

public abstract class Product {
    public Product(String name, int price) {
        if(price < 0) 
            throw new IllegalArgumentException("Invalid price of " + name + ": " + price/100 + "." + price%100);
        this.name = name;
        this.stockNumber = nextStockNumber++;
        this.price = price;
    }
    public int getStockNumber() {
        return stockNumber;
    }
    public int getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return String.format("%-40s $%5d.%02d", name, price/100, price%100);
    }
    private String name;
    private int stockNumber;
    private int price;
    private static int nextStockNumber = 0;
}
