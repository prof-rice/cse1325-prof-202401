package test;

import store.Customer;
import store.Exposure;
import store.Item;
import store.Order;
import store.Plant;
import store.Product;
import store.Tool;

public class TestItem {
    public static void main(String[] args) {
        int vector = 1;
        int result = 0;
    
        // TEST VECTOR: Creates correct prices
        Product p1 = new Plant("Valiant Apricot Vinca",Exposure.SUN, 1105);
        Item i1 = new Item(p1, 1);
        Product p2 = new Tool("Gardening Shovel", 1200);
        Item i2 = new Item(p2, 5);
        
        if(i1.getPrice() != 1105 || i2.getPrice() != 6000) {
            System.err.println("FAIL: Incorrect Item price "
                             + i1.getPrice() + " (1105 expected) or "
                             + i2.getPrice() + " (6000 expected)");
            result |= vector;
        }
        vector <<= 1;
        
        // TEST VECTOR: Creates correct String representation
        String i1Expected = "  1 Plant: Valiant Apricot Vinca             $   11.05 $    11.05";
        String i2Expected = "  5 Gardening Shovel                         $   12.00 $    60.00";
        if(!i1.toString().equals(i1Expected)) {
            System.err.println("FAIL: Incorrect Item toString:");
            System.err.println("  returned '" + i1 + "'");
            System.err.println("  expected '" + i1Expected + "'");
            result |= vector;
        }
        if(!i2.toString().equals(i2Expected)) {
            System.err.println("FAIL: Incorrect Item toString:");
            System.err.println("  returned '" + i2 + "'");
            System.err.println("  expected '" + i2Expected + "'");
            result |= vector;
        }

        if(result != 0) {
            System.err.println("\nFAILED Item test with error code " + result);
            System.exit(result);
        }
    }
}
