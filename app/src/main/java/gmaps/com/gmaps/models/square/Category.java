package gmaps.com.gmaps.models.square;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Durga Prasad on 24-01-2017.
 */
public class Category {

    @SerializedName("id")
    public String id;

    @SerializedName("name")
    public String name;

    @SerializedName("pluralName")
    public String pluralName;

    @SerializedName("shortName")
    public String shortName;

    @SerializedName("icon")
    public Icon icon;

    @SerializedName("primary")
    public Boolean primary;

}
