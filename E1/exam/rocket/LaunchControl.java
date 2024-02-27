public class LaunchControl {
    public static void main(String[] args) {
        Rocket rocket = null;
        try {
            rocket = new Rocket(); // Step 1
            // The thrust of the following engines varied by exam
            rocket.addEngine(new LiquidFuelEngine(22_820_000)); // Newtons - Step 2
            rocket.addEngine(new SolidFuelEngine(6_650_000));   // Newtons - Step 3
            rocket.addEngine(new SolidFuelEngine(6_650_000));   // Newtons

            // The next two lines were NOT required for the exam!
            System.out.println(rocket);
            System.out.println("3... 2... 1... LIFTOFF!");
        
            rocket.launch();    // Step 4
        } catch(Exception e) {  // Step 5
            System.err.println("Abort!");
            System.exit(-99); // code may vary
        }
        System.out.println(rocket); // Step 6 (rocket.toString() is OK)
    }
}
