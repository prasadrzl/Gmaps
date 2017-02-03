package gmaps.com.gmaps.models;

/**
 * Created by Durga Prasad on 30-01-2017.
 */
public class Transactions {
    public String amount;
    public String sku;
    public String currency;

    @Override
    public String toString() {
        return "Transactions{" +
                "amount='" + amount + '\'' +
                ", sku='" + sku + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
