package be.jatra.android.util.lang;

import android.util.Log;

import java.util.List;

public final class StringUtils {

    public static final String EMPTY_STRING = "";

    private static final String TAG = StringUtils.class.getSimpleName();
    private static final String SQUARE_BRACKET_OPEN = "[";
    private static final String SQUARE_BRACKET_CLOSED = "]";

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

    public static String formatAmount(final double amount) {
        Log.d(TAG, "formatAmount(amount=" + amount + ")");
        String formattedAmount = String.format("%.2f", amount);
        Log.d(TAG, "formattedAmount=" + formattedAmount);
        return formattedAmount;
    }

    public static String toCamelCase(final String s) {
        if (null == s || "".equals(s)) {
            return null;
        }

        String[] parts = s.split("_");
        String camelCaseString = "";
        for (String part : parts) {
            camelCaseString = camelCaseString + toProperCase(part);
        }
        return camelCaseString;
    }

    public static String toProperCase(String s) {
        return s.substring(0, 1).toUpperCase() +
                s.substring(1).toLowerCase();
    }
}
