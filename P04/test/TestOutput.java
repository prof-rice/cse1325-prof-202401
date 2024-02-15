package test;

import store.Customer;
import store.Exposure;
import store.Item;
import store.Order;
import store.Plant;
import store.Product;
import store.Tool;

public class TestOutput {
    public static void main(String[] args) {
        try {
            Customer c1 = new Customer("Prof Rice", "george.rice@uta.edu");
            Customer c2 = new Customer("President Joe Biden", "president@whitehouse.gov");
            Customer c3 = new Customer("The Late Queen Elizabeth II", "queen@royal.gov.uk");
            Customer c4 = new Customer("Mark Zuckerberg", "mark.zuckerberg@facebook.com");

            System.out.println("Famous customers include\n  "
                             + c1 + "\n  " + c2 + "\n  "+ c3 + "\n  " + c4);

            Product p1 = new Plant("Cactus Cereus Peruvianus", Exposure.SUN, 4990);
            Product p2 = new Plant("'White Princess' Philodendron", Exposure.PARTSUN, 5500);
            Product p3 = new Tool("Bypass Pruners", 2299);
            Product p4 = new Tool("Large Gardener's Cart", 34900);

            System.out.println("Our best products include:\n  "
                             + p1 + "\n  " + p2 + "\n  "+ p3 + "\n  " + p4);

            Item i1 = new Item(p1, 4);
            Item i2 = new Item(p2, 3);
            Item i3 = new Item(p3, 2);
            Item i4 = new Item(p4, 1);

            System.out.println("And my order will include:\n  "
                             + i1 + "\n  " + i2 + "\n  "+ i3 + "\n  " + i4);

            Order o1 = new Order(c1);
            o1.addItem(i1);
            o1.addItem(i2);
            o1.addItem(i3);
            o1.addItem(i4);

            System.out.println("\n====================\nHere's your receipt!\n\n" + o1);

        } catch(Exception e) {
            System.err.println("Failed to create and print objects: \n" + e);
        }
    }
}
