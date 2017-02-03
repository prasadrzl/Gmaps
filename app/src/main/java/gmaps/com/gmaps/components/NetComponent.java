package gmaps.com.gmaps.components;

import javax.inject.Singleton;

import dagger.Component;
import gmaps.com.gmaps.modules.AppModule;
import gmaps.com.gmaps.modules.NetworkModule;
import gmaps.com.gmaps.views.home.activity.ConverationRateActivity;
import gmaps.com.gmaps.views.home.activity.GHomeActivity;
import gmaps.com.gmaps.views.home.activity.GMapHomeActivity;

/**
 * Created by Durga Prasad on 24-10-2016.
 */

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface NetComponent {
    void inject(GHomeActivity activity);
    void inject(GMapHomeActivity activity);
    void inject(ConverationRateActivity activity);
}
