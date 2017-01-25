package gmaps.com.gmaps.models.movies;

/**
 * Created by Durga Prasad on 24-01-2017.
 */
public class Venue {

@SerializedName("id")
@Expose
public String id;
@SerializedName("name")
@Expose
public String name;
@SerializedName("contact")
@Expose
public Contact contact;
@SerializedName("location")
@Expose
public Location location;
@SerializedName("categories")
@Expose
public List<Category> categories = null;
@SerializedName("verified")
@Expose
public Boolean verified;
@SerializedName("stats")
@Expose
public Stats stats;
@SerializedName("venueRatingBlacklisted")
@Expose
public Boolean venueRatingBlacklisted;
@SerializedName("beenHere")
@Expose
public BeenHere beenHere;
@SerializedName("specials")
@Expose
public Specials specials;
@SerializedName("hereNow")
@Expose
public HereNow hereNow;
@SerializedName("referralId")
@Expose
public String referralId;
@SerializedName("venueChains")
@Expose
public List<VenueChain> venueChains = null;
@SerializedName("hasPerk")
@Expose
public Boolean hasPerk;
@SerializedName("allowMenuUrlEdit")
@Expose
public Boolean allowMenuUrlEdit;
@SerializedName("venuePage")
@Expose
public VenuePage venuePage;
@SerializedName("url")
@Expose
public String url;

}
