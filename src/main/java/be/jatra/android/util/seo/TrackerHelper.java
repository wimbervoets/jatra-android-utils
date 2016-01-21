package be.jatra.android.util.seo;

import android.util.Log;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public final class TrackerHelper {

    public static final String TAG = TrackerHelper.class.getSimpleName();

    public static void trackScreen(final Tracker tracker, final String screenName) {
        Log.i(TAG, "Setting screen name: " + screenName);
        tracker.setScreenName(screenName);
        tracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    //https://developers.google.com/analytics/devguides/collection/android/v4/?configured=true
    public static void trackEvent(final Tracker tracker, final String category, final String action) {
        tracker.send(new HitBuilders.EventBuilder()
                .setCategory(category)
                .setAction(action)
                .build());
    }
}
