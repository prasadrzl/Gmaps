package gmaps.com.gmaps.models.square;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Durga Prasad on 24-01-2017.
 */
public class Response {

    @SerializedName("venues")
    public List<Venue> venues;

    @SerializedName("confident")
    public Boolean confident;

}
