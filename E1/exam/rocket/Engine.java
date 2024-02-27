public abstract class Engine {
    protected final double maxThrust;
    public Engine(double maxThrust) {
        // This data validation was NOT required by the exam!
        if(maxThrust <= 0) throw new IllegalArgumentException("No thrust!");
        this.maxThrust = maxThrust;
    }
    public abstract void startEngine();
    public abstract double currentThrust();
}
