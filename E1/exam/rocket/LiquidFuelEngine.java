public class LiquidFuelEngine extends Engine {
    private double currentPowerFraction;
    public LiquidFuelEngine(double maxThrust) {
        super(maxThrust);
        this.currentPowerFraction = 0;
    }
    @Override
    public void startEngine() {
        this.setPower(0.8);
    }
    public void setPower(double powerFraction) {
        this.currentPowerFraction = powerFraction;
    }
    @Override
    public double currentThrust(){
        return maxThrust * currentPowerFraction;
    }
    @Override
    public String toString() {
        return "Liquid fuel " + ((currentPowerFraction > 0) ? "with thrust " + currentThrust() + " N" : "off");
    }
}
