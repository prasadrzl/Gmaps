package gmaps.com.gmaps.views;

import java.util.ArrayList;

import gmaps.com.gmaps.models.GitHubRepos;

/**
 * Created by Durga Prasad on 17-01-2017.
 */

public interface HomeView extends BaseView {
    void showContent(ArrayList<GitHubRepos> gitHubRepos);
}
