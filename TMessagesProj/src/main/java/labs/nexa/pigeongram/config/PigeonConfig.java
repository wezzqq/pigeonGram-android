package labs.nexa.pigeongram.config;

import android.content.Context;
import android.content.SharedPreferences;

import org.telegram.messenger.ApplicationLoader;

public class PigeonConfig {

    private static final SharedPreferences preferences =
            ApplicationLoader.applicationContext.getSharedPreferences(
                    "pigeongram_config",
                    Context.MODE_PRIVATE
            );

    // Hide Stories

    public static boolean hideStories() {
        return preferences.getBoolean("hide_stories", false);
    }

    public static void setHideStories(boolean value) {
        preferences.edit()
                .putBoolean("hide_stories", value)
                .apply();
    }
}