public class Note {
    public Note() {
        this.pitch = null;
    }
    public Note(Pitch pitch, int octave) {
        if(octave < -5) octave = -5;
        if(octave >  4) octave =  4;
        this.pitch = pitch;
        this.octave = octave;
    }
    public void play() {
    }
    @Override
    public String toString() {
        return (pitch != null) ? pitch.toString() + (octave == 0 ? "" : octave) : " ";
    }
    private Pitch pitch;
    private int octave;
}
