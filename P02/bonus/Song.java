public class Song {
    public static void main(String[] args) {
        Note pause = new Note();
        Note gb = new Note(Pitch.Gb, 0);
        Note g  = new Note(Pitch.G, 0);
        Note a  = new Note(Pitch.A, 0);
        Note b  = new Note(Pitch.B, 0);
        Note d  = new Note(Pitch.D, 1);
        Note bb3 = new Note(Pitch.Bb, 3);
        Note[] song = {b, a, g, a, b, b, b, pause,
                       a, a, a, pause,
                       b, d, d, pause,
                       b, a, g, a, b, b, b, b,
                       a, a, g, gb, g, pause,
                       bb3
        };
        for(Note note : song) {
            System.out.print(note + " ");
        }
        System.out.println();
    }
}
