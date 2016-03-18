package be.jatra.android.util.lang;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public final class StringUtilsTest {

    @Test
    public void stripBracketsList_null() {
        final List list = null;
        assertThat(StringUtils.stripBrackets(list), isEmptyString());
    }

    @Test
    public void stripBracketsString_null() {
        final String string = null;
        assertThat(StringUtils.stripBrackets(string), isEmptyString());
    }

    @Test
    public void formatAmount() {
        final double amount = 5.4;
        final String expectedFormattedAmount = "5,40";
        final String actualFormattedAmount = String.format("%.2f", amount);
        assertThat("formatted amount not equal", actualFormattedAmount, equalTo(expectedFormattedAmount));
    }

    @Test
    public void toCamelCase() {
        final String expected = "ThisWillBeConvertedIntoCamelCase";
        final String actual = StringUtils.toCamelCase("this_will_be_converted_into_CAMEL_case");
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void toCamelCase_emptyString() {
        final String actual = StringUtils.toCamelCase("");
        assertThat(actual, nullValue());
    }

    @Test
    public void toCamelCase_null() {
        final String actual = StringUtils.toCamelCase("");
        assertThat(actual, nullValue());
    }

    @Test
    public void toProperCase() {
        final String expected = "Makota";
        final String actual = StringUtils.toProperCase("mAkoTa");
        assertThat("toPropercase not equal", actual, equalTo(expected));
    }
}
