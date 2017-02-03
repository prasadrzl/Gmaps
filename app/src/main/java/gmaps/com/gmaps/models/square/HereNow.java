package gmaps.com.gmaps.models.square;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Durga Prasad on 24-01-2017.
 */
public class HereNow {

    @SerializedName("count")
    public Integer count;

    @SerializedName("summary")
    public String summary;

    @SerializedName("groups")
    public List<Object> groups = null;

}
