package gmaps.com.gmaps.models;

/**
 * Created by Durga Prasad on 30-01-2017.
 */

public class Rates {
    public  String from;
    public  String to;
    public  String rate;

    @Override
    public String toString() {
        return "Rates{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", rate='" + rate + '\'' +
                '}';
    }
}
