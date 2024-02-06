public class TestCustomer {
    public static void main(String[] args) {
        int vector = 1;
        int result = 0;
    
        // TEST VECTOR: Throws IllegalArgumentException on negative price
        try {
            Customer c = new Customer("Prof Rice", "rice.name");
            System.err.println("FAIL: Customer accepted email with no @");
            result |= vector;
        } catch(IllegalArgumentException e) {
        } catch(Exception e) {
            System.err.println("FAIL: Customer threw wrong exception on email with no @:\n" + e);
            result |= vector;
        }
        try {
            Customer c = new Customer("Prof Rice", "george.rice@uta");
            System.err.println("FAIL: Customer accepted email with no domain");
            result |= vector;
        } catch(IllegalArgumentException e) {
        } catch(Exception e) {
            System.err.println("FAIL: Customer threw wrong exception on email with no domain:\n" + e);
            result |= vector;
        }
        vector <<= 1;
        
        // TEST VECTOR: Creates correct String representation
        Customer c1 = new Customer("Prof Rice", "george.rice@uta.edu");
        String c1Expected = "Prof Rice (george.rice@uta.edu)";
        if(!c1.toString().equals(c1Expected)) {
            System.err.println("FAIL: Incorrect Customer toString:");
            System.err.println("  returned '" + c1 + "'");
            System.err.println("  expected '" + c1Expected + "'");
            result |= vector;
        }

        if(result != 0) {
            System.err.println("\nFAILED Customer Test with error code " + result);
            System.exit(result);
        }
    }
}
