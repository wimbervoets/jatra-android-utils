package be.jatra.android.util.pref;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

import be.jatra.android.util.AppUtils;
import be.jatra.android.util.lang.StringUtils;

public final class PrefUtils {

    /**
     * The placeholder of the app name in the template.
     */
    private static final String APP_NAME_PLACEHOLDER = "{app_name}";

    /**
     * The placeholder of the version in the template.
     */
    private static final String VERSION_PLACEHOLDER = "{version}";

    /**
     * Boolean indicating whether the EULA has been accepted.
     */
    private static final String PREF_EULA_ACCEPTED = "pref_tos_accepted_" + VERSION_PLACEHOLDER;

    /**
     * Boolean indicating whether the example has been created.
     */
    private static final String PREF_EXAMPLE_CREATED = "pref_example_created";

    /**
     * Boolean indicating whether the initial category has been created.
     */
    private static final String PREF_DEFAULT_CATEGORIES_CREATED = "pref_initial_category_created";

    /**
     * Long indicating when a sync was last ATTEMPTED (not necessarily succeeded).
     */
    private static final String PREF_LAST_SYNC_ATTEMPTED = "pref_last_sync_attempted";

    /**
     * Long indicating when a sync last SUCCEEDED.
     */
    private static final String PREF_LAST_SYNC_SUCCEEDED = "pref_last_sync_succeeded";

    /**
     * Boolean indicating whether we performed the (one-time) welcome flow.
     */
    private static final String PREF_WELCOME_DONE = "pref_welcome_done";

    /**
     * Boolean indicating if we can collect and Analytics.
     */
    public static final String PREF_ANALYTICS_ENABLED = "pref_analytics_enabled";

    /**
     * String indicating the code of the user's language.
     */
    public static final String PREF_LANGUAGE_CODE = "pref_language_code";

    /**
     * String indicating the default currency.
     */
    public static final String PREF_CURRENCY_CODE = "pref_currency_code";

    /**
     * The preferences file name template.
     */
    private static final String PREF_FILE_NAME_TEMPLATE = APP_NAME_PLACEHOLDER + "-prefs";

    /**
     * The context.
     */
    private static Context context;

    /**
     * Available languages.
     */
    private static List<String> availableLanguages = new ArrayList<>();

    public static void init(final Context context, final List<String> availableLanguages) {
        PrefUtils.context = context;
        PrefUtils.availableLanguages.addAll(availableLanguages);
    }

    public static boolean isEulaAccepted(final int appBuildNumber) {
        return getSharedPreferences()
                .getBoolean(PREF_EULA_ACCEPTED
                        .replace(VERSION_PLACEHOLDER, String.valueOf(appBuildNumber)), false);
    }

    public static void markEulaAccepted(final int appBuildNumber) {
        getSharedPreferences()
                .edit()
                .putBoolean(PREF_EULA_ACCEPTED
                        .replace(VERSION_PLACEHOLDER, String.valueOf(appBuildNumber)), true)
                .apply();
        //getSharedPreferences().edit().putString(PREF_LANGUAGE_CODE, languageCode).commit();
    }

    public static boolean isExampleCreated() {
        return getSharedPreferences().getBoolean(PREF_EXAMPLE_CREATED, false);
    }

    public static void markExampleCreated() {
        getSharedPreferences()
                .edit()
                .putBoolean(PREF_EXAMPLE_CREATED, true)
                .apply();
    }

    public static boolean isDefaultCategoriesCreated() {
        return getSharedPreferences().getBoolean(PREF_DEFAULT_CATEGORIES_CREATED, false);
    }

    public static void markDefaultCategoriesCreated() {
        getSharedPreferences()
                .edit()
                .putBoolean(PREF_DEFAULT_CATEGORIES_CREATED, true)
                .apply();
    }

    public static boolean isWelcomeDone() {
        return getSharedPreferences().getBoolean(PREF_WELCOME_DONE, false);
    }

    public static void markWelcomeDone() {
        getSharedPreferences().edit().putBoolean(PREF_WELCOME_DONE, true).apply();
    }

    public static long getLastSyncAttemptedTime() {
        return getSharedPreferences().getLong(PREF_LAST_SYNC_ATTEMPTED, 0L);
    }

    public static void markSyncAttemptedNow() {
        getSharedPreferences().edit()
                .putLong(PREF_LAST_SYNC_ATTEMPTED, System.currentTimeMillis()).apply();
    }

    public static long getLastSyncSucceededTime() {
        return getSharedPreferences().getLong(PREF_LAST_SYNC_SUCCEEDED, 0L);
    }

    public static void markSyncSucceededNow() {
        getSharedPreferences().edit()
                .putLong(PREF_LAST_SYNC_SUCCEEDED, System.currentTimeMillis()).apply();
    }

    public static boolean isAnalyticsEnabled() {
        return getSharedPreferences().getBoolean(PREF_ANALYTICS_ENABLED, true);
    }

    public static String getLanguageCode() {
        return getSharedPreferences().getString(PREF_LANGUAGE_CODE, getDefaultLanguageCode());
    }

    public static void setLanguageCode(final String languageCode) {
        getSharedPreferences().edit().putString(PREF_LANGUAGE_CODE, languageCode).apply();
    }

    public static String getCurrencyCode() {
        return getSharedPreferences().getString(PREF_CURRENCY_CODE, getDefaultCurrencyCode());
    }

    public static void setCurrencyCode(final String currencyCode) {
        getSharedPreferences().edit().putString(PREF_CURRENCY_CODE, currencyCode).apply();
    }

    public static String getDefaultCurrencyCode() {
        String defaultCurrencyCode = "EUR";
        try {
            defaultCurrencyCode = Currency.getInstance(Locale.getDefault()).toString();
        } catch (final IllegalArgumentException e) {
        }
        return defaultCurrencyCode;
    }

    private static SharedPreferences getSharedPreferences() {
        return context.getSharedPreferences(getFileName(), Context.MODE_PRIVATE);
    }

    private static String getFileName() {
        return PREF_FILE_NAME_TEMPLATE.replace(APP_NAME_PLACEHOLDER, AppUtils.getApplicationName(context));
    }

    private static String getDefaultLanguageCode() {
        String languageCode = Locale.getDefault().getLanguage();
        if (null == languageCode || StringUtils.EMPTY_STRING.equals(languageCode) || !availableLanguages.contains(languageCode)) {
            languageCode = Locale.ENGLISH.getLanguage();
        }
        return languageCode;
    }
}
