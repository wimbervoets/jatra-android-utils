package be.jatra.android.util.seo;

import be.jatra.android.util.lang.StringUtils;

public enum CategoryConstants {

    ACTION,
    MENU;

    public String getFormattedName() {
        return StringUtils.toCamelCase(this.toString());
    }
}
