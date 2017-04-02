package be.jatra.android.util.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public final class ListUtils {

    public static final String JOIN_DELIMITER = StringUtils.COMMA;

    public static final String SPLIT_DELIMITER = StringUtils.SPACE;

    private static final Logger LOGGER = LoggerFactory.getLogger(ListUtils.class);

    public static <T> String join(final Iterable<T> iterable) {
        return join(iterable, JOIN_DELIMITER);
    }

    public static <T> String join(final Iterable<T> iterable, final String delimiter) {
        return android.text.TextUtils.join(delimiter, iterable);
    }

    public static List<String> asList(final String string, final String delimiter) {
        if (null == string) {
            throw new IllegalArgumentException("string param cannot be null!");
        }

        String theDelimiter = delimiter;
        if ((null == theDelimiter) || StringUtils.EMPTY_STRING.equals(theDelimiter)) {
            theDelimiter = SPLIT_DELIMITER;
        }

        final List<String> list = Arrays.asList(string.split(theDelimiter));
        LOGGER.debug("list={}", list);
        return list;
    }

    @Deprecated
    public static <T> List<T> createEmptyList(final int size, final Class<T> clazz) {
        LOGGER.debug("createEmptyList(size={}, clazz={})", size, clazz);
        final List<T> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            try {
                list.add(clazz.newInstance());
            } catch (final Exception e) {
                LOGGER.error("Error creating new instance: {}", e.getLocalizedMessage());
            }
        }
        return list;
    }
}
