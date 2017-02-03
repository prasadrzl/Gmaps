package gmaps.com.gmaps.models.imdbmovies;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Durga Prasad on 27-01-2017.
 */
public class ImdbMovies {

    @SerializedName("status")
    public String status;

    @SerializedName("code")
    public Integer code;

    @SerializedName("message")
    public String message;

    @SerializedName("data")
    public ActorData data;

    @SerializedName("donation")
    public Donation donation;

    @Override
    public String toString() {
        return "ImdbMovies{" +
                "code=" + code +
                ", status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", donation=" + donation +
                '}';
    }
}
