package gmaps.com.gmaps.modules;

import dagger.Module;
import gmaps.com.gmaps.network.WebApiService;
import gmaps.com.gmaps.presenters.HomePresenter;

/**
 * Created by Durga Prasad on 18-01-2017.
 */

@Module(includes = {NetworkModule.class})
public class PresenterModule {

    public HomePresenter provideHomePresenter(WebApiService webApiService) {
        return new HomePresenter(webApiService);
    }
}