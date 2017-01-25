package gmaps.com.gmaps.models.movies;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Durga Prasad on 24-01-2017.
 */
public class Stats {

    @SerializedName("checkinsCount")
    public Integer checkinsCount;

    @SerializedName("usersCount")
    public Integer usersCount;

    @SerializedName("tipCount")
    public Integer tipCount;

}
