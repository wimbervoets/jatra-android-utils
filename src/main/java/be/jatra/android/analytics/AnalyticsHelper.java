package be.jatra.android.analytics;

public interface AnalyticsHelper {

    void logAppOpen();

    void logAction(final String actionName);

    void logItemOverview(String ItemOverviewName);

    void logItemDetail(String itemDetailName);

    void logSearchResults(String searchTerm);
}
