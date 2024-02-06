public class TestProduct {
    public static void main(String[] args) {
        int vector = 1;
        int result = 0;
    
        // TEST VECTOR: Throws IllegalArgumentException on negative price
        try {
            Product p = new Product("Bad", -1);
            System.err.println("FAIL: Product accepted negative price");
            result |= vector;
        } catch(IllegalArgumentException e) {
        } catch(Exception e) {
            System.err.println("FAIL: Product threw wrong exception on negative price:\n" + e);
            result |= vector;
        }
        vector <<= 1;
        
        // TEST VECTOR: Creates correct stock numbers
        Product p1 = new Product("Valiant Apricot Vinca", 1195);
        Product p2 = new Product("Valiant Lilac Vinca", 1295);
        if(p1.getStockNumber() != 0 || p2.getStockNumber() != 1) {
            System.err.println("FAIL: Incorrect Product stock number "
                             + p1.getStockNumber() + " (0 expected) or "
                             + p2.getStockNumber() + " (1 expected)");
            result |= vector;
        }
        vector <<= 1;
        
        // TEST VECTOR: Returns correct prices
        if(p1.getPrice() != 1195 || p2.getPrice() != 1295) {
            System.err.println("FAIL: Incorrect Product price "
                             + p1.getPrice() + " (1195 expected) or "
                             + p2.getPrice() + " (1295 expected)");
            result |= vector;
        }
        vector <<= 1;
        
        // TEST VECTOR: Creates correct String representation
        String p1Expected = "Valiant Apricot Vinca          $   11.95";
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
