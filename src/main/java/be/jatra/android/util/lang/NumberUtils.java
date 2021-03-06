package be.jatra.android.util.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigDecimal.ROUND_HALF_UP;

public final class NumberUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(NumberUtils.class);

    public static BigDecimal convert(final String amountAsString) {
        final DecimalFormat df = new DecimalFormat();
        df.setParseBigDecimal(true);
        BigDecimal amount = BigDecimal.ZERO;
        try {
            amount = new BigDecimal(amountAsString).setScale(2, ROUND_HALF_UP);
        } catch (final NumberFormatException e) {
            LOGGER.error(e.getLocalizedMessage());
        }
        LOGGER.debug("convert(amountAsString={}) - amount={}", amountAsString, amount);
        return amount.setScale(2, ROUND_HALF_UP);
    }

    public static BigDecimal convert(final double value) {
        final BigDecimal convertedValue = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP);
        LOGGER.debug("convert(value={}) - convertedValue={}", value, convertedValue);
        return convertedValue;
    }

    public static List<BigDecimal> convert(final List<String> amountsAsString) {
        final List<BigDecimal> amounts = new ArrayList<>();
        for (String amountAsString : amountsAsString) {
            amounts.add(convert(amountAsString));
        }
        return amounts;
    }

    public static String formatAmount(final double amount) {
        String formattedAmount = String.format("%.2f", amount);
        LOGGER.debug("formatAmount(amount={}) - formattedAmount={}", amount, formattedAmount);
        return formattedAmount;
    }

    public static String formatAmount(final BigDecimal amount) {
        return formatAmount(amount.doubleValue());
    }
}
