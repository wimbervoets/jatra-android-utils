package be.jatra.android.analytics.firebase;

import com.google.firebase.analytics.FirebaseAnalytics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.jatra.android.analytics.AnalyticsHelper;
import be.jatra.android.util.pref.PrefUtils;

public final class FireBaseAnalyticsHelper implements AnalyticsHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(FireBaseAnalyticsHelper.class);

    private static FireBaseAnalyticsHelper instance;

    private final FirebaseAnalytics firebaseAnalytics;

    private final int appBuildNumber;

    private FireBaseAnalyticsHelper(
            final FirebaseAnalytics firebaseAnalytics, final int appBuildNumber) {
        this.firebaseAnalytics = firebaseAnalytics;
        this.appBuildNumber = appBuildNumber;
    }

    public static FireBaseAnalyticsHelper getInstance(
            final FirebaseAnalytics firebaseAnalytics, final int appBuildNumber) {
        if (null == instance) {
            instance = new FireBaseAnalyticsHelper(firebaseAnalytics, appBuildNumber);
        }
        return instance;
    }

    @Override
    public void logAppOpen() {
        FireBaseAnalyticsParam param = new FireBaseAnalyticsParam.Builder().build();
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.APP_OPEN, param.toBundle());
        LOGGER.debug("logAppOpen recorded={}");
    }

    @Override
    public void logAction(final String actionName) {
        if (canSend()) {
            FireBaseAnalyticsParam param = new FireBaseAnalyticsParam.Builder()
                    .build();
            firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, param.toBundle());
        }
    }

    @Override
    public void logItemOverview(final String itemOverviewName) {
        if (canSend()) {
            FireBaseAnalyticsParam param = new FireBaseAnalyticsParam.Builder()
                    .itemName(itemOverviewName)
                    .build();
            firebaseAnalytics.logEvent(FirebaseAnalytics.Event.VIEW_ITEM, param.toBundle());
            LOGGER.debug("itemOverviewName recorded={}", itemOverviewName);
        }
    }

    @Override
    public void logItemDetail(final String itemDetailName) {
        if (canSend()) {
            FireBaseAnalyticsParam param = new FireBaseAnalyticsParam.Builder()
                    .itemName(itemDetailName)
                    .build();
            firebaseAnalytics.logEvent(FirebaseAnalytics.Event.VIEW_ITEM_LIST, param.toBundle());
            LOGGER.debug("itemDetailName recorded={}", itemDetailName);
        }
    }

    @Override
    public void logSearchResults(final String searchTerm) {
        if (canSend()) {
            FireBaseAnalyticsParam param = new FireBaseAnalyticsParam.Builder()
                    .searchTerm(searchTerm)
                    .build();
            firebaseAnalytics.logEvent(FirebaseAnalytics.Event.VIEW_SEARCH_RESULTS, param.toBundle());
            LOGGER.debug("searchTerm recorded={}", searchTerm);
        }
    }

    private boolean canSend() {
        // Google Analytics can only be sent when ALL the following conditions are true:
        //    1. This module has been initialized.
        //    2. The user has accepted the EULA, always true; otherwise he could not use the app.
        //    3. Analytics is enabled in Settings.
        boolean isEulaAccepted = PrefUtils.isEulaAccepted(appBuildNumber);
        boolean isAnalyticsEnabled = PrefUtils.isAnalyticsEnabled();
        LOGGER.debug("canSend() - isEulaAccepted={}, isAnalyticsEnabled={}", isEulaAccepted, isAnalyticsEnabled);
        return instance != null && firebaseAnalytics != null && isEulaAccepted && isAnalyticsEnabled;
    }
}
