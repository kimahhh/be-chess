package softeer2nd.utils;

public class StringUtils {
    public static final String NEWLINE = System.getProperty("line.separator");

    private StringUtils() { }

    public static String appendNewLine(String string) {
        return string + NEWLINE;
    }

    public static StringBuilder appendNewLine(StringBuilder stringBuilder) {
        return stringBuilder.append(NEWLINE);
    }
}
