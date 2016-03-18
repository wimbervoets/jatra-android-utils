package be.jatra.android.util;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public final class KeyboardUtils {

    /**
     * Helper to hide the keyboard.
     *
     * @param activity
     */
    public static void hideKeyboard(final Activity activity) {
        if (null == activity) {
            return;
        }

        final View view = activity.getCurrentFocus();
        if (view != null) {
            final InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void hideKeyboard(final Fragment fragment) {
        if (null == fragment) {
            return;
        }
        hideKeyboard(fragment.getActivity());
    }
}
