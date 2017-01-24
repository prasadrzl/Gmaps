package gmaps.com.gmaps;


import android.app.Application;

import gmaps.com.gmaps.components.DaggerNetComponent;
import gmaps.com.gmaps.components.NetComponent;
import gmaps.com.gmaps.modules.AppModule;


/**
 * Created by Durga Prasad on 05-01-2017.
 */

public class GmapApplication extends Application {

    private static GmapApplication gmapApplication;
    private NetComponent netComponent;

    public static GmapApplication getInstance() {
        return gmapApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        gmapApplication = this;
        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public NetComponent getNetComponent() {
        return netComponent;
    }
}
