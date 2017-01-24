package gmaps.com.gmaps.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Durga Prasad on 24-10-2016.
 */

@Module
public class AppModule {
    Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application providesApplication() {
        return application;
    }
}
