public class SolidFuelEngine extends Engine {
    private boolean burning;
    public SolidFuelEngine(double maxThrust) {
        super(maxThrust);
        this.burning = false;
    }
    @Override
    public void startEngine() {
        burning = true;
    }
    @Override
    public double currentThrust(){
        return burning ? maxThrust : 0;
    }
    @Override
    public String toString() {
        return "Solid fuel " + (burning ? "with thrust " + maxThrust + " N" : "off");
    }
}
