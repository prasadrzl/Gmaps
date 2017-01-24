package gmaps.com.gmaps.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Durga Prasad on 17-01-2017.
 */
public class CountryMo {

    @SerializedName("status")
    public Integer status;

    @SerializedName("countries")
    public List<Country> countries;

}
