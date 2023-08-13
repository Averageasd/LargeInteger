public enum Sign {

    PLUS("+"),
    MINUS("-"),

    MULTIPLY("*");

    private final String s;
    Sign(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s;
    }
}
