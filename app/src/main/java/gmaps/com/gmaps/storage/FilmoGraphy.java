package gmaps.com.gmaps.storage;

import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Created by Durga Prasad on 03-02-2017.
 */
@RealmClass
public class FilmoGraphy {

    @PrimaryKey
    public int filmId;
    public String title;
    public String year;
    public String info;

}
