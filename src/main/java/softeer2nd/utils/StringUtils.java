package softeer2nd.utils;

public class StringUtils {
    public static final String NEWLINE = System.getProperty("line.separator");
    private static final StringUtils stringUtils = new StringUtils();

    private StringUtils() { }

    public static StringUtils getInstance() {
        return stringUtils;
    }

    public static String appendNewLine(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        return stringBuilder.append(NEWLINE).toString();
    }

    public static StringBuilder appendNewLine(StringBuilder stringBuilder) {
        return stringBuilder.append(NEWLINE);
    }
}
