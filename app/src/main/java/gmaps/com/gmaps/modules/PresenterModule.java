package gmaps.com.gmaps.modules;

import dagger.Module;
import gmaps.com.gmaps.network.GitApiService;
import gmaps.com.gmaps.network.MoviesApiService;
import gmaps.com.gmaps.network.SquareApiService;
import gmaps.com.gmaps.presenters.ConvertionRatePresenter;
import gmaps.com.gmaps.presenters.HomePresenter;

/**
 * Created by Durga Prasad on 18-01-2017.
 */

@Module(includes = {NetworkModule.class})
public class PresenterModule {

    public HomePresenter provideHomePresenter(GitApiService webApiService,SquareApiService squareApiService
                                              ,MoviesApiService moviesApiService) {
        return new HomePresenter(webApiService, squareApiService, moviesApiService);
    }

    public ConvertionRatePresenter provideConvertionPresenter(){
        return new ConvertionRatePresenter();
    }


}