package be.jatra.android.util.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public final class StringUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringUtils.class);

    public static final String EMPTY_STRING = "";

    public static final String LEFT_PARENTHESIS = "(";

    public static final String RIGHT_PARENTHESIS = ")";

    public static final String SPACE = " ";

    public static final String SQUARE_BRACKET_OPEN = "[";

    public static final String SQUARE_BRACKET_CLOSED = "]";

    public static final String SEMI_COLON = ";";

    public static final String DASH = "-";

    public static final String DOT = ".";

    public static final String COMMA = ",";

    public static final String RQUO = ">>";

    public static final String DECIMAL_SEPARATOR = DOT;

    public static final String THOUSANDS_SEPARATOR = COMMA;

    public static final String PIPE = "|";

    public static final String NEW_LINE = "\n";

    public static final String UNDERSCORE = "_";

    public static String stripBrackets(final List list) {
        if (null == list) {
            return EMPTY_STRING;
        }
        return stripBrackets(list.toString());
    }

    public static String stripBrackets(final String string) {
        if (null == string) {
            return EMPTY_STRING;
        }
        return string.replace(SQUARE_BRACKET_OPEN, EMPTY_STRING).replace(SQUARE_BRACKET_CLOSED, EMPTY_STRING);
    }

    public static String toCamelCase(final String s) {
        if (null == s || EMPTY_STRING.equals(s)) {
            return null;
        }

        String[] parts = s.split(UNDERSCORE);
        String camelCaseString = EMPTY_STRING;
        for (String part : parts) {
            camelCaseString = camelCaseString + toProperCase(part);
        }
        return camelCaseString;
    }

    public static String toProperCase(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }
}
