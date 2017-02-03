package gmaps.com.gmaps.views;

import java.util.ArrayList;

import gmaps.com.gmaps.models.github.GitHubRepos;
import gmaps.com.gmaps.models.imdbmovies.ImdbMovies;
import gmaps.com.gmaps.models.square.Venues;

/**
 * Created by Durga Prasad on 17-01-2017.
 */

public interface HomeView extends BaseView {
    void showContent(ArrayList<GitHubRepos> gitHubRepos);
    void showVenuContent(Venues venues);
    void showMovieContent(ImdbMovies imdbMovies);
}
