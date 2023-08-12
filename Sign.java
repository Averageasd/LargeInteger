public enum Sign {

    PLUS("+"),
    MINUS("-");

    private final String s;
    Sign(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s;
    }
}
