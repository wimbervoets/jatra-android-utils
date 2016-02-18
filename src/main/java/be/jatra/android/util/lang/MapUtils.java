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
}
