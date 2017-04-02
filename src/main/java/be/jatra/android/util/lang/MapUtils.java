package be.jatra.android.util.lang;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public final class MapUtils {

    public static Map<Long, BigDecimal> deepCopy(final Map<Long, BigDecimal> map) {
        final Map<Long, BigDecimal> newMap = new HashMap<>();
        for (Map.Entry<Long, BigDecimal> entry : map.entrySet()) {
            newMap.put(
                    Long.valueOf(entry.getKey().longValue()),
                    BigDecimal.valueOf(entry.getValue().doubleValue()).setScale(2, BigDecimal.ROUND_HALF_UP));
        }
        return newMap;
    }

    public static Map.Entry<Long, BigDecimal> getMinEntry(final Map<Long, BigDecimal> map) {
        Map.Entry<Long, BigDecimal> minEntry = null;
        for (Map.Entry<Long, BigDecimal> entry : map.entrySet()) {
            if (minEntry == null || entry.getValue().compareTo(minEntry.getValue()) < 0) {
                minEntry = entry;
            }
        }
        return minEntry;
    }

    public static Map.Entry<Long, BigDecimal> getMaxEntry(final Map<Long, BigDecimal> map) {
        Map.Entry<Long, BigDecimal> maxEntry = null;
        for (Map.Entry<Long, BigDecimal> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        return maxEntry;
    }
}