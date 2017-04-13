package be.jatra.android.util;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class VersionTest {

    @Test
    public void testVersion() {
        final String expected= "2.3b12 (code-name)";
        final String actual = new Version("2", "3", 12, "code-name").toString();
        assertThat(actual, equalTo(expected));
    }
}
