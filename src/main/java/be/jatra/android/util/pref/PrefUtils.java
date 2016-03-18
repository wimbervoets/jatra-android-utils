package be.jatra.android.util.pref;

import android.content.Context;
import android.content.SharedPreferences;

import be.jatra.android.util.AppUtils;

public final class PrefUtils {

    /**
     * Boolean indicating whether ToS has been accepted
     */
    public static final String PREF_TOS_ACCEPTED = "pref_tos_accepted";

    /**
     * Long indicating when a sync was last ATTEMPTED (not necessarily succeeded)
     */
    public static final String PREF_LAST_SYNC_ATTEMPTED = "pref_last_sync_attempted";

    /**
     * Long indicating when a sync last SUCCEEDED
     */
    public static final String PREF_LAST_SYNC_SUCCEEDED = "pref_last_sync_succeeded";

    /**
     * Boolean indicating whether we performed the (one-time) welcome flow.
     */
    public static final String PREF_WELCOME_DONE = "pref_welcome_done";

    /**
     * Boolean indicating if we can collect and Analytics
     */
    public static final String PREF_ANALYTICS_ENABLED = "pref_analytics_enabled";

    /**
     * String indicating the code of the user's language.
     */
    public static final String PREF_LANGUAGE_CODE = "pref_language_code";

    /**
     * The placeholder of the app name in the template.
     */
    private static final String APP_NAME_PLACEHOLDER = "{app_name}";

    /**
     * The preferences file name template.
     */
    private static final String PREF_FILE_NAME_TEMPLATE = APP_NAME_PLACEHOLDER + "-prefs";

    public static void init(final Context context) {
    }

    public static boolean isTosAccepted(final Context context) {
        return getSharedPreferences(context).getBoolean(PREF_TOS_ACCEPTED, false);
    }

    public static void markTosAccepted(final Context context) {
        getSharedPreferences(context).edit().putBoolean(PREF_TOS_ACCEPTED, true).commit();
    }

    public static boolean isWelcomeDone(final Context context) {
        return getSharedPreferences(context).getBoolean(PREF_WELCOME_DONE, false);
    }

    public static void markWelcomeDone(final Context context) {
        getSharedPreferences(context).edit().putBoolean(PREF_WELCOME_DONE, true).commit();
    }

    public static long getLastSyncAttemptedTime(final Context context) {
        return getSharedPreferences(context).getLong(PREF_LAST_SYNC_ATTEMPTED, 0L);
    }

    public static void markSyncAttemptedNow(final Context context) {
        getSharedPreferences(context).edit()
                .putLong(PREF_LAST_SYNC_ATTEMPTED, System.currentTimeMillis()).commit();
    }

    public static long getLastSyncSucceededTime(final Context context) {
        return getSharedPreferences(context).getLong(PREF_LAST_SYNC_SUCCEEDED, 0L);
    }

    public static void markSyncSucceededNow(final Context context) {
        getSharedPreferences(context).edit()
                .putLong(PREF_LAST_SYNC_SUCCEEDED, System.currentTimeMillis()).commit();
    }

    public static boolean isAnalyticsEnabled(final Context context) {
        return getSharedPreferences(context).getBoolean(PREF_ANALYTICS_ENABLED, true);
    }

    private static SharedPreferences getSharedPreferences(final Context context) {
        return context.getSharedPreferences(getFileName(context), Context.MODE_PRIVATE);
    }

    private static String getFileName(final Context context) {
        return PREF_FILE_NAME_TEMPLATE.replace(APP_NAME_PLACEHOLDER, AppUtils.getApplicationName(context));
    }
}
