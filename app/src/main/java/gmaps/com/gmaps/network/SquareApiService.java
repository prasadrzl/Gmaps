package gmaps.com.gmaps.network;

import gmaps.com.gmaps.models.square.Venues;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Durga Prasad on 24-01-2017.
 */

public interface SquareApiService {

    @GET("venues/search")
    Observable<Venues> getVenues( @Query("v") String date);
}
