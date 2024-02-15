package store;

public enum Exposure {
    SHADE, PARTSUN, SUN;
    private static final String[] text = new String[]{
        "Full Shade", "Part Sun/Shade", "Full Sun"
    };
    @Override
    public String toString() {
        return text[this.ordinal()];
    }
}
