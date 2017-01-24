package gmaps.com.gmaps.presenters;

import gmaps.com.gmaps.views.BaseView;

/**
 * Created by Durga Prasad on 21-01-2017.
 */

interface BasePresenter<V extends BaseView> {
    void attachView(V view);

    void detachView();

    boolean isViewAttached();

    V getView();
}
