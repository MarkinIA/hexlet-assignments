package exercise;

// BEGIN
public class ReversedSequence implements CharSequence{

    private String str;

    public ReversedSequence(String str) {
        String result = "";
        char[] array = str.toCharArray();
        for (int j = array.length - 1; j >= 0; j--) {
            result = result + array[j];
        }
        this.str = result;
    }

    public ReversedSequence(String str, boolean revFlag) {
        this.str = str;
    }

    @Override
    public int length() {
        return str.length();
    }

    @Override
    public char charAt(int i) {
        return str.charAt(i);
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        str = str.substring(i, i1);
        return str;
    }

    @Override
    public String toString() {
        return str;
    }
}
// END
