package be.jatra.android.util.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;

import static java.math.BigDecimal.ROUND_HALF_UP;

public final class NumberUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(NumberUtils.class);

    public static BigDecimal convert(final String amountAsString) {
        LOGGER.debug("convert(amountAsString={})", amountAsString);
        final DecimalFormat df = new DecimalFormat();
        df.setParseBigDecimal(true);
        BigDecimal amount = BigDecimal.ZERO;
        try {
            amount = (BigDecimal) df.parse(amountAsString);
        } catch (final ParseException e) {
            LOGGER.error(e.getLocalizedMessage());
        }
        LOGGER.debug("amount={}", amount);
        return amount.setScale(2, ROUND_HALF_UP);
    }

    public static BigDecimal convert(final double value) {
        LOGGER.debug("convert(value={})", value);
        final BigDecimal convertedValue = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP);
        LOGGER.debug("convertedValue={}", convertedValue);
        return convertedValue;
    }
}
