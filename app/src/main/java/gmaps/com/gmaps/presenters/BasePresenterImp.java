package gmaps.com.gmaps.presenters;

import java.lang.ref.WeakReference;

import gmaps.com.gmaps.views.BaseView;
import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Durga Prasad on 21-01-2017.
 */

public class BasePresenterImp<V extends BaseView> implements BasePresenter<V> {
    private WeakReference<V> view;

    private CompositeSubscription compositeSubscription = new CompositeSubscription();

    @Override
    public void attachView(V view) {
        this.view = new WeakReference<>(view);
    }



    @Override
    public void detachView() {
        if (view != null) {
            view.clear();
            view = null;
        }
        if (!compositeSubscription.isUnsubscribed()) {
            compositeSubscription.clear();
        }
    }

    @Override
    public boolean isViewAttached() {
        return view != null && view.get() != null;
    }

    @Override
    public void addSubscription(Subscription subs) {
        compositeSubscription.add(subs);
    }

    @Override
    public V getView() {
        return view == null ? null : view.get();
    }

}
