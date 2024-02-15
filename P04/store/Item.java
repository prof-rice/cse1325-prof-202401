package store;

public class Item {
    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
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
