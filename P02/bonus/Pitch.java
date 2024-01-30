public enum Pitch {
  C("C"),
  Db("D♭"), D("D"),
  Eb("E♭"), E("E"),
  F("F"),
  Gb("G♭"), G("G"),
  Ab("A♭"), A("A"),
  Bb("B♭"), B("B");
  private String string;
  private Pitch(String string) {
      this.string = string;
  }
  @Override
  public String toString() {
      return string;
  }
}
