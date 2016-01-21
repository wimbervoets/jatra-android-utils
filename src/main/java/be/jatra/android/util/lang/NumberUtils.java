package be.jatra.android.util.lang;

import android.util.Log;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;

import static java.math.BigDecimal.ROUND_HALF_UP;

public final class NumberUtils {

    private static final String TAG = NumberUtils.class.getSimpleName();

    private static final BigDecimal HUNDRED = new BigDecimal(100).setScale(2);

    public static BigDecimal calculateAmountCoefficient(final BigDecimal baseAmount, final BigDecimal coefficient) {
        Log.d(TAG, "calculateAmountCoefficient(baseAmount" + baseAmount + ", coefficient=" + coefficient + ")");
        final BigDecimal amount = baseAmount.multiply(coefficient).divide(HUNDRED);
        Log.d(TAG, "calculatedAmount=" + amount);
        return amount;
    }

    public static BigDecimal convert(final String amountAsString) {
        Log.d(TAG, "convert(amountAsString=" + amountAsString + ")");
        final DecimalFormat df = new DecimalFormat();
        df.setParseBigDecimal(true);
        BigDecimal amount = BigDecimal.ZERO;
        try {
            amount = (BigDecimal) df.parse(amountAsString);
        } catch (final ParseException e) {
            Log.e(TAG, e.getLocalizedMessage());
        }
        Log.d(TAG, "amount=" + amount);
        return amount.setScale(2, ROUND_HALF_UP);
    }
}
