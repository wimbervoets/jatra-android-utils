package be.jatra.android.util.seo;

import android.content.Context;
import android.support.annotation.XmlRes;

//import com.google.android.gms.analytics.GoogleAnalytics;
//import com.google.android.gms.analytics.HitBuilders;
//import com.google.android.gms.analytics.Tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.jatra.android.util.BuildConfig;
import be.jatra.android.util.pref.PrefUtils;

public class GoogleAnalyticsManager {

//    private static final Logger LOGGER = LoggerFactory.getLogger(GoogleAnalyticsManager.class);
//
//    private static Context context = null;
//
//    private static Tracker tracker;
//
//    public static synchronized void setTracker(final Tracker tracker) {
//        GoogleAnalyticsManager.tracker = tracker;
//    }
//
//    private static boolean canSend() {
//        // Google Analytics can only be sent when ALL the following conditions are true:
//        //    1. This module has been initialized.
//        //    2. The user has accepted the ToS.
//        //    3. Analytics is enabled in Settings.
//        return context != null && tracker != null && PrefUtils.isTosAccepted() &&
//                PrefUtils.isAnalyticsEnabled();
//    }
//
//    public static void logItemOverview(final String screenName) {
//        if (canSend()) {
//            tracker.setScreenName(screenName);
//            tracker.send(new HitBuilders.ScreenViewBuilder().build());
//            LOGGER.debug("Screen Name recorded: {}", screenName);
//        }
//    }
//
//    public static void sendEvent(String category, String action) {
//        sendEvent(category, action, null, 0);
//    }
//
//    public static void sendEvent(String category, String action, String label) {
//        sendEvent(category, action, label, 0);
//    }
//
//    public static void sendEvent(String category, String action, String label, long value) {
//        if (canSend()) {
//            tracker.send(new HitBuilders.EventBuilder()
//                    .setCategory(category)
//                    .setAction(action)
//                    .setLabel(label)
//                    .setValue(value)
//                    .build());
//            LOGGER.debug("Event recorded: category={}, action={}, label={}, value={}", category, action, label, value);
//        }
//    }
//
//    public Tracker getTracker() {
//        return tracker;
//    }
//
//    public static synchronized void initializeAnalyticsTracker(final Context context, @XmlRes final int debugConfig, @XmlRes int releaseConfig) {
//        GoogleAnalyticsManager.context = context;
//        if (tracker == null) {
//            int useProfile;
//            if (BuildConfig.DEBUG) {
//                LOGGER.debug("Analytics manager using DEBUG ANALYTICS PROFILE.");
//                useProfile = debugConfig;
//            } else {
//                useProfile = releaseConfig;
//            }
//            tracker = GoogleAnalytics.getInstance(context).newTracker(useProfile);
//        }
//    }
}
