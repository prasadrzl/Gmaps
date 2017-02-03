package gmaps.com.gmaps.models.imdbmovies;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ActorData {

    @SerializedName("id")
    public String id;

    @SerializedName("type")
    public String type;

    @SerializedName("title")
    public String title;

    @SerializedName("description")
    public String description;

    @SerializedName("image")
    public String image;

    @SerializedName("mediaLinks")
    public List<String> mediaLinks ;

    @SerializedName("filmography")
    public List<Filmography> filmography ;

    @SerializedName("occupation")
    public List<String> occupation ;

}

