package be.jatra.android.util;

public final class Version {

    private final String value;

    private final Integer buildNumber;

    private String codeName;

    public Version(final String value, final Integer buildNumber) {
        this(value, buildNumber, null);
    }

    public Version(final String value, final Integer buildNumber, String codeName) {
        this.value = value;
        this.buildNumber = buildNumber;
        this.codeName = codeName;
    }

    public String getName() {
        return value;
    }

    public Integer getCode() {
        return buildNumber;
    }

    @Override
    public String toString() {
        return String.format("%1$sb%2$s (%3$s)", value, buildNumber, codeName);
    }
}
