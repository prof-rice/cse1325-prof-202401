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
    private String[] octaves = {"⁻⁵", "⁻⁴", "⁻³", "⁻²", "⁻¹",
                             "", "¹",  "²",  "³",  "⁴",  "⁵"};
    @Override
    public String toString() {
        return (pitch != null) ? pitch.toString() + octaves[octave+5] : " ";
    }
    private Pitch pitch;
    private int octave;
}
