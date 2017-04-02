package be.jatra.android.util;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;

public interface HasActionBar {

    ActionBar getSupportActionBar();

    ActionBarDrawerToggle getActionBarDrawerToggle();
}
