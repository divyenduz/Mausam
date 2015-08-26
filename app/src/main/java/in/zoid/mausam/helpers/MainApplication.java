package in.zoid.mausam.helpers;

import android.app.Application;

import com.firebase.client.Firebase;
import com.firebase.client.Logger;

import in.zoid.mausam.BuildConfig;

/**
 * Created by divyendusingh on 8/26/15.
 */
public class MainApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(getApplicationContext());
        Firebase.getDefaultConfig().setPersistenceEnabled(true);
        if (BuildConfig.BUILD_TYPE.equals("debug")) {
            Firebase.getDefaultConfig().setLogLevel(Logger.Level.DEBUG);
        } else {
            Firebase.getDefaultConfig().setLogLevel(Logger.Level.NONE);
        }
    }
}
