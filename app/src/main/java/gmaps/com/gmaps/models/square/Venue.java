package gmaps.com.gmaps.models.square;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Durga Prasad on 24-01-2017.
 */
public class Venue {

    @SerializedName("id")
    public String id;

    @SerializedName("name")
    public String name;

    @SerializedName("contact")
    public Contact contact;

    @SerializedName("location")
    public Location location;

    @SerializedName("categories")
    public List<Category> categories = null;

    @SerializedName("verified")
    public Boolean verified;

    @SerializedName("stats")
    public Stats stats;

    @SerializedName("venueRatingBlacklisted")
    public Boolean venueRatingBlacklisted;

    @SerializedName("beenHere")
    public BeenHere beenHere;

    @SerializedName("specials")
    public Specials specials;
    @SerializedName("hereNow")
    public HereNow hereNow;

    @SerializedName("referralId")
    public String referralId;

    @SerializedName("venueChains")
    public List<VenueChain> venueChains = null;

    @SerializedName("hasPerk")
    public Boolean hasPerk;

    @SerializedName("allowMenuUrlEdit")
    public Boolean allowMenuUrlEdit;

    @SerializedName("venuePage")
    public VenuePage venuePage;

    @SerializedName("url")
    public String url;

}
