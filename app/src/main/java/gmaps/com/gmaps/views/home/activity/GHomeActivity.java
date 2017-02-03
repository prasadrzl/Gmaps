package gmaps.com.gmaps.views.home.activity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import gmaps.com.gmaps.GmapApplication;
import gmaps.com.gmaps.R;
import gmaps.com.gmaps.base.BaseActivity;
import gmaps.com.gmaps.listeners.OnRecycleViewItemClickListener;
import gmaps.com.gmaps.models.SkuWithCurrency;
import gmaps.com.gmaps.models.github.GitHubRepos;
import gmaps.com.gmaps.models.imdbmovies.ImdbMovies;
import gmaps.com.gmaps.models.square.Venues;
import gmaps.com.gmaps.presenters.HomePresenter;
import gmaps.com.gmaps.views.HomeView;
import gmaps.com.gmaps.views.TransactionRecyclerViewAdapter;
import timber.log.Timber;

/**
 * Created by Durga Prasad on 15-01-2017.
 */

public class GHomeActivity extends BaseActivity implements
        HomeView, SwipeRefreshLayout.OnRefreshListener,
        NavigationView.OnNavigationItemSelectedListener,
        OnRecycleViewItemClickListener {

    private static final String TAG = GHomeActivity.class.getName();

    @Inject
    HomePresenter homePresenter;
    @BindView(R.id.recylcerView)
    RecyclerView recylcerView;
    private Map<String, List<SkuWithCurrency>> transactionMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        GmapApplication.getInstance().getNetComponent().inject(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        homePresenter.attachView(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_camera:
                homePresenter.getReposData();
                break;
            case R.id.nav_gallery:
                AssetManager assetManager = getAssets();
                try {
                    transactionMap = homePresenter.getFileData(assetManager.open("transactions.json"));
                    setUpRecyclerView();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
            case R.id.nav_slideshow:
                break;
            case R.id.nav_manage:
                break;
            case R.id.nav_share:
                break;
            case R.id.nav_send:
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setUpRecyclerView() {
        TransactionRecyclerViewAdapter transactionRecyclerViewAdapter = new
                TransactionRecyclerViewAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recylcerView.setLayoutManager(linearLayoutManager);
        transactionRecyclerViewAdapter.setTransactionMapData(transactionMap);
        recylcerView.setAdapter(transactionRecyclerViewAdapter);
        transactionRecyclerViewAdapter.setOnRecyclerViewItemClickListener(this);
    }


    @Override
    public void showProgress() {
        super.showProgress();
    }

    @Override
    public void hideProgress() {
        super.hideProgress();
    }

    @Override
    public void showError(Throwable e) {
        Timber.e(e, TAG + "Github error : ");
    }

    @Override
    public void showContent(ArrayList<GitHubRepos> gitHubRepos) {
        Timber.i(TAG + "Github Data : %s", gitHubRepos.toString());
    }

    @Override
    public void showVenuContent(Venues venues) {
        Timber.i(TAG + "Square Data : %s", venues.toString());
    }

    @Override
    public void showMovieContent(ImdbMovies imdbMovies) {
        Timber.i(TAG + "Imdb Movies : %s", imdbMovies.toString());
    }

    @Override
    public void onRefresh() {

    }

    @Override
    protected void onDestroy() {
        if (homePresenter.isViewAttached()) {
            homePresenter.detachView();
        }
        super.onDestroy();
    }

    @Override
    public void setOnRecycleViewItemClickListener(int position, String skuName) {
        Intent intent = new Intent(GHomeActivity.this, ConverationRateActivity.class);
        intent.putParcelableArrayListExtra(getResources().getString(R.string.curreny_list),
                new ArrayList<>(transactionMap.get(skuName)));
        startActivity(intent);
    }
}
