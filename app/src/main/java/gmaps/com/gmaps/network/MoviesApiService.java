package gmaps.com.gmaps.network;

import gmaps.com.gmaps.models.imdbmovies.ImdbMovies;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Durga Prasad on 28-01-2017.
 */

public interface MoviesApiService {

    @GET("{actorCode}")
    Observable<ImdbMovies> getActorData(@Path("actorCode") String actorCode);

}
