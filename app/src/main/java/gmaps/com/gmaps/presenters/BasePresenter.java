package gmaps.com.gmaps.presenters;

import gmaps.com.gmaps.views.BaseView;
import rx.Subscriber;

/**
 * Created by Durga Prasad on 21-01-2017.
 */

interface BasePresenter<V extends BaseView> {
    void attachView(V view);

    void detachView();

    boolean isViewAttached();

    void addSubscription(Subscriber subs);

    V getView();
}
