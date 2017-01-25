package gmaps.com.gmaps.models.movies;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Durga Prasad on 24-01-2017.
 */
public class Location {

    @SerializedName("address")
    public String address;

    @SerializedName("lat")
    public Float lat;

    @SerializedName("lng")
    public Float lng;

    @SerializedName("labeledLatLngs")
    public List<LabeledLatLng> labeledLatLngs = null;

    @SerializedName("distance")
    public Integer distance;

    @SerializedName("postalCode")
    public String postalCode;

    @SerializedName("cc")
    public String cc;

    @SerializedName("city")
    public String city;

    @SerializedName("state")
    public String state;

    @SerializedName("country")
    public String country;

    @SerializedName("formattedAddress")
    public List<String> formattedAddress = null;

    @SerializedName("crossStreet")
    public String crossStreet;

}
