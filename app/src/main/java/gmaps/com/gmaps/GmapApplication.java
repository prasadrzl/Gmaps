package gmaps.com.gmaps;


import android.app.Application;

import gmaps.com.gmaps.components.DaggerNetComponent;
import gmaps.com.gmaps.components.NetComponent;
import gmaps.com.gmaps.modules.AppModule;
import gmaps.com.gmaps.modules.NetworkModule;
import io.realm.Realm;
import io.realm.RealmConfiguration;


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
        setRealmConfiguration();
        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .networkModule( new NetworkModule())
                .build();
    }

    private void setRealmConfiguration() {
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                                                .name("caster.pro.db")
                                                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

    public NetComponent getNetComponent() {
        return netComponent;
    }
}
