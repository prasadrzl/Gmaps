package gmaps.com.gmaps.views.home.activity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import gmaps.com.gmaps.GmapApplication;
import gmaps.com.gmaps.R;
import gmaps.com.gmaps.base.BaseActivity;
import gmaps.com.gmaps.models.Rates;
import gmaps.com.gmaps.models.SkuWithCurrency;
import gmaps.com.gmaps.presenters.ConvertionRatePresenter;
import gmaps.com.gmaps.views.ConvertionRateView;
import gmaps.com.gmaps.views.home.ConvertionRateAdapter;

/**
 * Created by Durga Prasad on 30-01-2017.
 */

public class ConverationRateActivity extends BaseActivity implements ConvertionRateView {

    @BindView(R.id.convertion_rate_recycler_view)
    RecyclerView convertionRateRecyclerView;
    @Inject
    ConvertionRatePresenter convertionRatePresenter;
    private ArrayList<SkuWithCurrency> skuWithCurrencyList;
    private List<Rates> ratesConvertionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.convertion_rate_view);
        ButterKnife.bind(this);
        GmapApplication.getInstance().getNetComponent().inject(this);
        AssetManager assetManager = getAssets();
        try {
            ratesConvertionList = convertionRatePresenter.getConvertionRateData(assetManager.open("rates.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Intent intent = getIntent();
        if (intent != null) {
            skuWithCurrencyList = intent.getParcelableArrayListExtra
                    (getResources().getString(R.string.curreny_list));
        }
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        ConvertionRateAdapter convertionRateAdapter = new
                ConvertionRateAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        convertionRateRecyclerView.setLayoutManager(linearLayoutManager);
        convertionRateAdapter.setRateJsonData(ratesConvertionList);
        convertionRateAdapter.setConvertionListData(skuWithCurrencyList);
        convertionRateRecyclerView.setAdapter(convertionRateAdapter);
    }

    @Override
    public void showContent() {

    }

    @Override
    public void showError(Throwable e) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        convertionRatePresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        convertionRatePresenter.detachView();
    }
}
