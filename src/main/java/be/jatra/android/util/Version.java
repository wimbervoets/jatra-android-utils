package be.jatra.android.util;

public final class Version {

    private final String major;

    private final String minor;

    private final Integer buildNumber;

    private String codeName;

    public Version(final String major, final String minor, final Integer buildNumber) {
        this(major, minor, buildNumber, null);
    }

    public Version(final String major, final String minor, final Integer buildNumber, final String codeName) {
        this.major = major;
        this.minor = minor;
        this.buildNumber = buildNumber;
        this.codeName = codeName;
    }

    public final String getMajor() {
        return major;
    }

    public final String getMinor() {
        return minor;
    }

    public final Integer getBuildNumber() {
        return buildNumber;
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder("%1$s");
        if (minor != null) {
            sb.append(".%2$s");
        }
        sb.append("b%3$s (%4$s)");
        if (minor == null) {
            return String.format(sb.toString(), major, buildNumber, codeName);
        } else {
            return String.format(sb.toString(), major, minor, buildNumber, codeName);
        }
    }
}
