package exercise;

// BEGIN
public class NegativeRadiusException extends Exception {

    public static final NegativeRadiusException RADIUS_IS_INCORRECT = new NegativeRadiusException("Radius is less than 0!");

    private String text;
    public NegativeRadiusException(String text) {
        this.text = text;
    }

    public String throwErrorMessage(String text) {
        return text;
    }
}
// END
