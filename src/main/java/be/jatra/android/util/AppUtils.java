package be.jatra.android.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

public final class AppUtils {

    public interface Callback {
        String getCodeName();
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(AppUtils.class);

    public static String getApplicationName(final Context context) {
        int stringId = context.getApplicationInfo().labelRes;
        return context.getString(stringId);
    }

    public static Version getVersion(final Context context, final Callback callback) {
        Version version = null;
        try {
            final PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            final String name = packageInfo.versionName;
            final int code = packageInfo.versionCode;
            version = new Version(name, null, code, callback.getCodeName());
        } catch (final PackageManager.NameNotFoundException e) {
            LOGGER.error(e.getLocalizedMessage());
        }
        LOGGER.debug("version={}", version);
        return version;
    }

    public static void configureLocale(final Resources resources, final String languageCode) {
        LOGGER.debug("configureLocale(Resources, language={})", languageCode);
        Locale locale = new Locale(languageCode, Locale.getDefault().getCountry());
        Locale.setDefault(locale);
        Configuration config = resources.getConfiguration();
        config.locale = locale;
        resources.updateConfiguration(config, resources.getDisplayMetrics());
    }
}
