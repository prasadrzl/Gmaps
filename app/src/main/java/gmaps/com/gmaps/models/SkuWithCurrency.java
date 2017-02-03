package gmaps.com.gmaps.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Durga Prasad on 30-01-2017.
 */
public class SkuWithCurrency implements  Parcelable {
    public String currency;
    public int skuCount;

    @Override
    public String toString() {
        return "SkuWithCurrency{" +
                "currency='" + currency + '\'' +
                ", skuCount=" + skuCount +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.currency);
        dest.writeInt(this.skuCount);
    }

    public SkuWithCurrency() {
    }

    protected SkuWithCurrency(Parcel in) {
        this.currency = in.readString();
        this.skuCount = in.readInt();
    }

    public static final Parcelable.Creator<SkuWithCurrency> CREATOR = new Parcelable.Creator<SkuWithCurrency>() {
        @Override
        public SkuWithCurrency createFromParcel(Parcel source) {
            return new SkuWithCurrency(source);
        }

        @Override
        public SkuWithCurrency[] newArray(int size) {
            return new SkuWithCurrency[size];
        }
    };
}
