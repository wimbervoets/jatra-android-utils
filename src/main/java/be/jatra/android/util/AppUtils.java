package be.jatra.android.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class AppUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppUtils.class);

    public static String getApplicationName(final Context context) {
        int stringId = context.getApplicationInfo().labelRes;
        return context.getString(stringId);
    }

    public static Version getVersion(final Context context) {
        Version version = null;
        try {
            final PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            final String name = packageInfo.versionName;
            final int code = packageInfo.versionCode;
            final Integer buildNumber = null;
            version = new Version(name, code, buildNumber);
        } catch (final PackageManager.NameNotFoundException e) {
            LOGGER.error(e.getLocalizedMessage());
        }
        return version;
    }
}
