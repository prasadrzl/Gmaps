package gmaps.com.gmaps.presenters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import gmaps.com.gmaps.models.SkuWithCurrency;
import gmaps.com.gmaps.models.Transactions;
import gmaps.com.gmaps.models.github.GitHubRepos;
import gmaps.com.gmaps.models.imdbmovies.ImdbMovies;
import gmaps.com.gmaps.models.square.Venues;
import gmaps.com.gmaps.network.GitApiService;
import gmaps.com.gmaps.network.MoviesApiService;
import gmaps.com.gmaps.network.SquareApiService;
import gmaps.com.gmaps.storage.ActorTable;
import gmaps.com.gmaps.views.HomeView;
import io.realm.Realm;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Durga Prasad on 17-01-2017.
 */

public class HomePresenter extends BasePresenterImp<HomeView> {

    private static final int USD = 1;
    private static final int GBP = 2;
    private static final int CAD = 3;
    private static final int AUD = 4;
    @Inject
    Gson gson;
    private HomeView homeView;
    private GitApiService gitApiService;
    private SquareApiService squareApiService;
    private MoviesApiService moviesApiService;

    @Inject
    public HomePresenter(GitApiService gitApiService, SquareApiService squareApiService, MoviesApiService
            moviesApiService) {
        this.gitApiService = gitApiService;
        this.squareApiService = squareApiService;
        this.moviesApiService = moviesApiService;
    }


    public void getReposData() {
        homeView = getView();
        if (homeView != null) {
            homeView.showProgress();

            //getDataFromGithub();
            //getDataFromSquare();
            getDataFromImdbMovies();
        }
    }

    private void getDataFromImdbMovies() {
        Observable<ImdbMovies> venuesData = moviesApiService.getActorData("nm0000151");
       Subscription subs = venuesData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ImdbMovies>() {
                    @Override
                    public void onCompleted() {
                        homeView.hideProgress();
                    }



                    @Override
                    public void onError(Throwable e) {
                        homeView.hideProgress();
                        homeView.showError(e);
                    }

                    @Override
                    public void onNext(ImdbMovies imdbMovies) {
                        storeDetailsInDb(imdbMovies);
                        homeView.showMovieContent(imdbMovies);
                    }
                });
            addSubscription(subs);
    }

    private void getDataFromSquare() {
        Observable<Venues> venuesData = squareApiService.getVenues("20170120");
        compositeSubscription.add(venuesData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Venues>() {
                    @Override
                    public void onCompleted() {
                        homeView.hideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        homeView.hideProgress();
                        homeView.showError(e);
                    }

                    @Override
                    public void onNext(Venues venues) {
                        homeView.showVenuContent(venues);
                    }
                }));


    }

    private void getDataFromGithub() {
        Observable<ArrayList<GitHubRepos>> gitHubRepos = gitApiService.getGitRepos("shivamdev31");
        compositeSubscription.add(gitHubRepos.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ArrayList<GitHubRepos>>() {
                    @Override
                    public void onCompleted() {
                        homeView.hideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        homeView.hideProgress();
                        homeView.showError(e);

                    }

                    @Override
                    public void onNext(ArrayList<GitHubRepos> gitHubReposes) {
                        homeView.showContent(gitHubReposes);
                    }
                }));
    }

    public Map<String, List<SkuWithCurrency>> getFileData(InputStream inputStream)
            throws IOException {
        Map<String, List<SkuWithCurrency>> skuMap;
        List<Transactions> trasactionList = getTransactionsesFromJson(inputStream);
        skuMap = new HashMap<>();
        addSkuIntoMap(skuMap, trasactionList);
        return skuMap;
    }

    private List<Transactions> getTransactionsesFromJson(InputStream inputStream)
            throws IOException {
        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        String json = new String(buffer, "UTF-8");
        return gson.fromJson(json,
                new TypeToken<List<Transactions>>() {
                }.getType());
    }

    private void addSkuIntoMap(Map<String, List<SkuWithCurrency>> skuMap,
                               List<Transactions> trasactionList) {
        for (Transactions transaction : trasactionList) {
            List<SkuWithCurrency> skuWithCurrencyList;
            if (skuMap.containsKey(transaction.sku)) {
                skuWithCurrencyList = skuMap.get(transaction.sku);
            } else {
                skuWithCurrencyList = new ArrayList<>();
            }
            setDataIntoSku(skuMap, transaction, skuWithCurrencyList);

        }
    }

    private void setDataIntoSku(Map<String, List<SkuWithCurrency>> skuMap, Transactions transaction,
                                List<SkuWithCurrency> skuWithCurrencyList) {
        SkuWithCurrency skuWithCurrency;
        skuWithCurrency = new SkuWithCurrency();
        skuWithCurrency.currency = transaction.currency;
        skuWithCurrencyList.add(skuWithCurrency);
        skuMap.put(transaction.sku, skuWithCurrencyList);
    }

    private void storeDetailsInDb(ImdbMovies imdbMovies) {
        Realm realm = Realm.getDefaultInstance();
        ActorTable actor = new ActorTable();
        actor.id = imdbMovies.data.id;
        realm.executeTransaction(realm1 -> {
            realm1.copyFromRealm(imdbMovies.data);
        });
    }

}

