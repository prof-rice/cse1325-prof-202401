import java.util.ArrayList;

public class Rocket implements Launchable {
    private Type type;
    private double mass; // kg
    private ArrayList<Engine> engines;
    public Rocket(Type type, double mass) {
        if(mass <= 0) throw new IllegalArgumentException("Negative mass!");

        this.type = type;
        this.mass = mass;
        engines = new ArrayList<>();
    }
    public Rocket() {
        // The mass of the default rocket varied by exam
        this(Type.BOOSTER, 50_000); // kg
    }
    public void addEngine(Engine engine) {
        engines.add(engine);
    }
    @Override
    public void launch() {
        for(Engine engine : engines) {
            engine.startEngine();
        }
    }
    public String toString() {
        StringBuilder sb = new StringBuilder("Rocket with " + engines.size() + " engines");
        double thrust = 0;
        for(Engine engine : engines) {
            thrust += engine.currentThrust();
            sb.append("\n  " + engine);
        }
        if(thrust > 0) {
            double acceleration = thrust / mass - 9.8; // meters per second
            sb.append("\nAccelerating at " + acceleration + " m/s²");
        }
        return sb.toString();
    }
}
