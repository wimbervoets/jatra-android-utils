package be.jatra.android.pref;

import org.junit.Test;

import be.jatra.android.util.pref.PrefUtils;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class PrefUtilsTest {

    @Test
    public void testGetDefaultCurrencyCode() {
        final String expected = "EUR";
        final String actual = PrefUtils.getDefaultCurrencyCode();
        assertThat(actual, equalTo(expected));
    }
}
