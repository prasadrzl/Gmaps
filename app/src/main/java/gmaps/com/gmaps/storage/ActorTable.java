package gmaps.com.gmaps.storage;

import java.util.List;

import gmaps.com.gmaps.models.imdbmovies.Filmography;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Created by Durga Prasad on 03-02-2017.
 */

@RealmClass
public class ActorTable {

    @PrimaryKey
    public int id;
    public String type;
    public String title;
    public String description;
    public String image;
    public List<Filmography> filmography ;
}
