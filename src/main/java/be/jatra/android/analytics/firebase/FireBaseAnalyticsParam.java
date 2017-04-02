package be.jatra.android.analytics.firebase;

import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public final class FireBaseAnalyticsParam {

    private String itemId;
    private String itemName;
    private String contentType;
    private String searchTerm;

    public FireBaseAnalyticsParam(final Builder builder) {
        this.itemId = builder.itemId;
        this.itemName = builder.itemName;
        this.contentType = builder.contentType;
        this.searchTerm = builder.searchTerm;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        addIfNotNull(bundle, FirebaseAnalytics.Param.ITEM_ID, itemId);
        addIfNotNull(bundle, FirebaseAnalytics.Param.ITEM_NAME, itemName);
        addIfNotNull(bundle, FirebaseAnalytics.Param.CONTENT_TYPE, contentType);
        addIfNotNull(bundle, FirebaseAnalytics.Param.SEARCH_TERM, searchTerm);
        return bundle;
    }

    private void addIfNotNull(final Bundle bundle, final String key, final String value) {
        if (null != value) {
            bundle.putString(key, value);
        }
    }

    public static final class Builder {

        private String itemId;
        private String itemName;
        private String contentType;
        private String searchTerm;

        public Builder() {
        }

        public Builder itemId(final String itemId) {
            this.itemId = itemId;
            return this;
        }

        public Builder itemName(final String itemName) {
            this.itemName = itemName;
            return this;
        }

        public Builder contentType(final String contentType) {
            this.contentType = contentType;
            return this;
        }

        public Builder searchTerm(final String searchTerm) {
            this.searchTerm = searchTerm;
            return this;
        }

        public FireBaseAnalyticsParam build() {
            return new FireBaseAnalyticsParam(this);
        }
    }
}
