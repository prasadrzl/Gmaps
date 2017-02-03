package gmaps.com.gmaps.models.imdbmovies;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Durga Prasad on 27-01-2017.
 */
public class Filmography {

    @SerializedName("title")
    public String title;

    @SerializedName("year")
    public String year;

    @SerializedName("info")
    public String info;

}
