package store;

import java.util.ArrayList;

public class Store {
    public Store(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
        this.products  = new ArrayList<>();
        this.orders    = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    // Customers
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    /*
    public int getNumberOfCustomers() {
        return customers.size();
    }
    public String getCustomerString(int index) {
        return customers.get(index).toString();
    }
    */
    public String getCustomerList() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<customers.size(); ++i) 
            sb.append(String.format("%3d] %s\n", i, customers.get(i)));
        return sb.toString();
    }
    
    // Products
    public void addProduct(Product product) {
        products.add(product);
    }
    /*
    public int getNumberOfProducts() {
        return products.size();
    }
    public String getProductString(int index) {
        return products.get(index).toString();
    }
    */
    public String getProductList() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<products.size(); ++i) 
            sb.append(String.format("%3d] %s\n", i, products.get(i)));
        return sb.toString();
    }
    
    // Orders
    public int newOrder(int customer) {
        orders.add(new Order(customers.get(customer)));
        return orders.size() - 1;
    }
    public void addToOrder(int order, int product, int quantity) {
        orders.get(order).addItem(new Item(products.get(product), quantity));
    }
    /*
    public int getNumberOfOrders() {
        return orders.size();
    }
    public String getOrderString(int index) {
        return orders.get(index).toString();
    }
    */
    public String getOrderList() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<orders.size(); ++i) 
            sb.append(String.format("\n%s\n", orders.get(i)));
        return sb.toString();
    }
   
    private String name;
    private ArrayList<Customer> customers;
    private ArrayList<Product> products;
    private ArrayList<Order> orders;
}
