package gmaps.com.gmaps.models.movies;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Durga Prasad on 24-01-2017.
 */
public class LabeledLatLng {

    @SerializedName("label")
    public String label;

    @SerializedName("lat")
    public Float lat;

    @SerializedName("lng")
    public Float lng;

}
