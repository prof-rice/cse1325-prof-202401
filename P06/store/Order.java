package store;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Models an order (in other words, the customer's receipt).
 *
 * @author             Professor George F. Rice
 * @version            1.0
 * @since              1.0
 * @license.agreement  Gnu General Public License 3.0
 */
public class Order {
    /**
     * Creates an Order instance.
     *
     * The Customer for whom this Order is placed is provide
     * as the constructor parameter. The Order number is
     * auto-generated as sequential integers. Items may be 
     * added to the Order via the addItem(Item) method.
     *
     * @param customer     the Customer placing this Order
     * @since              1.0
     */
    public Order(Customer customer) {
        this.items = new ArrayList<>();
        this.customer = customer;
        this.orderNumber = nextOrderNumber++;
    }
    public Order(BufferedReader br) throws IOException {
        this.items = new ArrayList<>();
        this.orderNumber = Integer.parseInt(br.readLine());
        this.nextOrderNumber = Integer.parseInt(br.readLine());
        this.customer = new Customer(br);
        int size = Integer.parseInt(br.readLine());
        while(size-- > 0) items.add(new Item(br));
    }
    public void save(BufferedWriter bw) throws IOException {
        bw.write("" + orderNumber + '\n');
        bw.write("" + nextOrderNumber + '\n');
        customer.save(bw);
        bw.write("" + items.size() + '\n');
        for(Item i : items) i.save(bw);
    }
    /**
     * Adds an Item to this Order.
     *
     * All Orders should logically have at least one Item (this is
     * not enforced, however). Any number of Items will be accepted.
     *
     * @param item     the Item to add to the Order
     * @since          1.0
     */
    public void addItem(Item item) {
        items.add(item);
    }
    /**
     * Calculates and returns the total price of the Order.
     *
     * The price is simply the sum of all Item prices.
     *
     * @returns     the total price of the Order
     * @since       1.0
     */
    public int getPrice() {
        int price = 0;
        for(Item item : items) {
            price += item.getPrice();
        }
        return price;
    }
    /**
     * Returns an Order summary in receipt format.
     *
     * This includes the Order number and Customer, a table
     * of Items in the Order, and the total price of the Order.
     * Sales tax is not included at this time.
     *
     * @returns     a formatted receipt for this Order
     * @since       1.0
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Order #" + orderNumber + " for " + customer);
        for(Item item : items) 
            sb.append("\n  " + item);
        int price = getPrice();
        sb.append(String.format("\nOrder total $%5d.%2d", price/100, price%100));
        return sb.toString();
    }
    private ArrayList<Item> items;
    private Customer customer;
    private int orderNumber;
    private static int nextOrderNumber = 0;
}
