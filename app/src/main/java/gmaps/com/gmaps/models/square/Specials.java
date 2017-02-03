package gmaps.com.gmaps.models.square;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Durga Prasad on 24-01-2017.
 */
public class Specials {

    @SerializedName("count")
    public Integer count;

    @SerializedName("items")
    public List<Object> items = null;

}
