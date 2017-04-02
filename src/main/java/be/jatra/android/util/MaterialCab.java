package be.jatra.android.util;

@SuppressWarnings("ConstantConditions")
public final class MaterialCab {

    public interface Callback {

        void onCabInitialization();

        void onCabFinished();
    }

    public static class Helper {

        public static void showHamburgerIcon(final HasActionBar instance) {
            instance.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            instance.getActionBarDrawerToggle().setDrawerIndicatorEnabled(true);
        }

        public static void showBackArrow(final HasActionBar instance) {
            instance.getActionBarDrawerToggle().setDrawerIndicatorEnabled(false);
            instance.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
