package gmaps.com.gmaps.views;

/**
 * Created by Durga Prasad on 21-01-2017.
 */

public interface BaseView {
    void showProgress();

    void hideProgress();

    void showError(Throwable e);
}
