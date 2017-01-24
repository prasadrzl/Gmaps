package gmaps.com.gmaps.views.home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceFragment;

import gmaps.com.gmaps.R;

/**
 * Created by Durga Prasad on 18-01-2017.
 */

public class DetailsFragment extends MvpLceFragment {
    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return null;
    }

    @Override
    public MvpPresenter createPresenter() {
        return null;
    }

    @Override
    public void setData(Object data) {

    }

    @Override
    public void loadData(boolean pullToRefresh) {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
