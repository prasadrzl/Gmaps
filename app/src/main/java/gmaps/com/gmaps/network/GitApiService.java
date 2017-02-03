package gmaps.com.gmaps.network;

import java.util.ArrayList;

import gmaps.com.gmaps.models.github.GitHubRepos;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface GitApiService {
    @GET("users/{login}/repos")
    Observable<ArrayList<GitHubRepos>> getGitRepos(@Path("login") String login);
}