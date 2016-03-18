package be.jatra.android.util;

public final class Version {

    private final String name;

    private final Integer code;

    public Version(final String name, final Integer code, final Integer buildNumber) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String toString() {
        return String.format("Version %s (%s)", name, code);
    }
}
