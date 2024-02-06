public class TestOutput {
    public static void main(String[] args) {
        try {
            Customer c1 = new Customer("Prof Rice", "george.rice@uta.edu");
            Customer c2 = new Customer("President Joe Biden", "president@whitehouse.gov");
            Customer c3 = new Customer("The Late Queen Elizabeth II", "queen@royal.gov.uk");
            Customer c4 = new Customer("Mark Zuckerberg", "mark.zuckerberg@facebook.com");

            System.out.println("Famous customers include\n  "
                             + c1 + "\n  " + c2 + "\n  "+ c3 + "\n  " + c4);

            Product p1 = new Product("Cactus Cereus Peruvianus", 4990);
            Product p2 = new Product("'White Princess' Philodendron", 5500);
            Product p3 = new Product("6 inch English Lavender", 2909);
            Product p4 = new Product("'Hayi' Rhaphidophora", 3299);

            System.out.println("Our best plants include:\n  "
                             + p1 + "\n  " + p2 + "\n  "+ p3 + "\n  " + p4);

            Item i1 = new Item(p1, 1);
            Item i2 = new Item(p2, 2);
            Item i3 = new Item(p3, 3);
            Item i4 = new Item(p4, 4);

            System.out.println("And my order will include:\n  "
                             + i1 + "\n  " + i2 + "\n  "+ i3 + "\n  " + i4);
        } catch(Exception e) {
            System.err.println("Failed to create and print objects: \n" + e);
        }
    }
}
