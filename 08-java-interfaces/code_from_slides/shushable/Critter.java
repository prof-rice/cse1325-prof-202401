import java.io.IOException;

abstract class Critter implements Shushable {
    public Critter(int frequency) {
        this.frequency = frequency; 
        this.timer = 0;
        shushed = false;
    }
    public void count() {
        if (++timer > frequency) timer = 0;
    }
    public abstract void speak();
    
    // This is the shell command for audio speech synthesis
    // It is protected so that our subclasses can call it,
    //     but other classes cannot
    protected final String speakCmd = "espeak ";
    protected void say(String s) {
        try {
            System.out.println(s);
            execCmd(speakCmd + s.split(" ")[0]);
        } catch(Exception e) {
        }
    }
    // Our fields are also protected, so our subclasses can use them
    protected int frequency;
    protected int timer;
    
    // Runs a command in the shell (returns while it runs)
    // No other class needs access to this method, so it is private
    private static void execCmd(String cmd) throws IOException {
        Runtime.getRuntime().exec(cmd);
    }
    // Implementing Shushable interface
    private boolean shushed;
    
    public void shush() {
        shushed = true;
    }
    public void unshush() {
        shushed = false;
    }
    public boolean isShushed() {
        return shushed;
    }
}