package test;

import store.Customer;
import store.Exposure;
import store.Item;
import store.Order;
import store.Plant;
import store.Product;
import store.Tool;

public class TestProduct {
    public static void main(String[] args) {
        int vector = 1;
        int result = 0;
    
        // TEST VECTOR: Throws IllegalArgumentException on negative price
        try {
            Product p = new Tool("Bad", -1);
            System.err.println("FAIL: Product accepted negative price");
            result |= vector;
        } catch(IllegalArgumentException e) {
        } catch(Exception e) {
            System.err.println("FAIL: Product threw wrong exception on negative price:\n" + e);
            result |= vector;
        }
        vector <<= 1;
        
        // TEST VECTOR: Creates correct stock numbers
        Product p1 = new Plant("Valiant Apricot Vinca",Exposure.SUN, 1105);
        Product p2 = new Tool("Gardening Shovel", 1200);
        if(p1.getStockNumber() != 0 || p2.getStockNumber() != 1) {
            System.err.println("FAIL: Incorrect Product stock number "
                             + p1.getStockNumber() + " (0 expected) or "
                             + p2.getStockNumber() + " (1 expected)");
            result |= vector;
        }
        vector <<= 1;
        
        // TEST VECTOR: Returns correct prices
        if(p1.getPrice() != 1105 || p2.getPrice() != 1200) {
            System.err.println("FAIL: Incorrect Product price "
                             + p1.getPrice() + " (1105 expected) or "
                             + p2.getPrice() + " (1200 expected)");
            result |= vector;
        }
        vector <<= 1;
        
        // TEST VECTOR: Creates correct String representation
        String p1Expected = "Plant: Valiant Apricot Vinca             $   11.05";
        if(!p1.toString().equals(p1Expected)) {
            System.err.println("FAIL: Incorrect Product toString:");
            System.err.println("  returned '" + p1 + "'");
            System.err.println("  expected '" + p1Expected + "'");
            result |= vector;
        }

        if(result != 0) {
            System.err.println("\nFAILED with error code " + result);
            System.exit(result);
        }
    }
}
