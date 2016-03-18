package be.jatra.android.util.seo;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class TrackerHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrackerHelper.class);

    public static void trackScreen(final Tracker tracker, final String screenName) {
        LOGGER.info("Setting screen name: " + screenName);
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

//public class GAnalyticsUtils {
//
//    private static final String TAG = GAnalyticsUtils.class.getSimpleName();
//
//    public static void trackScreen(Context ctx, String screenName) {
//        // May return null if EasyTracker has not yet been initialized with a property ID.
//        Tracker easyTracker = EasyTracker.getInstance(ctx);
//
//        // This screen name value will remain set on the tracker and sent with
//        // hits until it is set to a new value or to null.
//        // easyTracker.set( Fields.SCREEN_NAME, screenName );
//
//        // Set dispatch period.
//        easyTracker.send( MapBuilder
//                .createAppView()
//                .set( Fields.SCREEN_NAME, screenName )
//                .set( Fields.HIT_TYPE, "appview" )
//                .build() );
//    }
//
//    /****
//     *
//     * @param ctx Context.
//     * @param eventCatagory Required. For e.g. ui_event, ux_event
//     * @param eventName Required. Name of the event. For e.g. button_press
//     * @param eventLabel
//     * @param eventValue
//     * ***/
//    public static void trackEvent(Context ctx, String eventCatagory, String eventName, String eventLabel, long eventValue) {
//        // May return null if a EasyTracker has not yet been initialized with a
//        // property ID.
//        EasyTracker easyTracker = EasyTracker.getInstance(ctx);
//
//        // MapBuilder.createEvent().build() returns a Map of event fields and values
//        // that are set and sent with the hit.
//        easyTracker.send(MapBuilder
//                        .createEvent(eventCatagory,     // Event category (required)
//                                eventName,  // Event action (required)
//                                eventLabel,   // Event label
//                                eventValue)            // Event value
//                        .build()
//        );
//    }
//
//}